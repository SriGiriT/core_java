class SharedResource{
    private int data;
    private volatile boolean available = false;
    public synchronized void produce(int newData){
        while(available){
            try{
                wait();
            }catch(InterruptedException e){
                // System.out.println(Thread.currentThread().interrupted());
                return;
            }
            data = newData;
            available = true;
            System.out.println("Produced: "+data);
            notify();
        }
    }
    public synchronized int consume(){
        while(!available){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
                return -1;
            }
        }
        int consumedData = data;
        available = false;
        System.out.println("Consumed: "+consumedData);
        notify();
        return consumedData;
    }
}
class Producer extends Thread{
    private SharedResource sharedResource;
    public Producer(SharedResource sharaResource){
        this.sharedResource = sharaResource;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            sharedResource.produce(i);
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Consumer extends Thread{
    private SharedResource sharedResource;
    public Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            sharedResource.consume();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }
}
public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}
