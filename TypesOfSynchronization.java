class CounterWithoutSynchronization{
    static int count = 0;
    public static void increment(){
        count++;
    }
    public static void decrement(){
        count--;
    }
    public int getCount(){
        return count;
    }
}

class CounterWithStaticSynchronization{
    static int count = 0;
    public static synchronized void increment(){
        count++;
    }
    public static synchronized void decrement(){
        count--;
    }
    public int getCount(){
        return count;
    }
}

class CounterWithSynchronizedBlock{
    int count = 0;
    public void increment(){
        synchronized(this){
            count++;
        }
    }
    public  void decrement(){
        synchronized(this){
            count--;
        }
    }
    public int getCount(){
        return count;
    }
}

class CounterWithSynchronizedMethod{
    int count = 0;
    public synchronized void increment(){
        count++;
    }
    public synchronized void decrement(){
        count--;
    }
    public int getCount(){
        return count;
    }
}

class CounterWithVolatile {
    private volatile int count = 0; 
    public void increment() {
        count++;
    }
    public void decrement() {
        count--;
    }
    public int getCount() {
        return count;
    }
}


public class TypesOfSynchronization {
    public static void main(String[] args) {
        CounterWithoutSynchronization counter1 = new CounterWithoutSynchronization();
        CounterWithStaticSynchronization counter2 = new CounterWithStaticSynchronization();
        CounterWithSynchronizedBlock counter3 = new CounterWithSynchronizedBlock();
        CounterWithSynchronizedMethod counter4 = new CounterWithSynchronizedMethod();
        CounterWithVolatile counter5 = new CounterWithVolatile();

        Thread thread1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter1.increment();
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter1.decrement();
            }
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter1.getCount());
    }
}
