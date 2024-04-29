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
    // will get minute changes in data due to atomic level 
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
                CounterWithoutSynchronization.increment();
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i=0;i<1000;i++){
                CounterWithoutSynchronization.decrement();
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


        Thread thread3 = new Thread(()->{
            for(int i=0;i<1000;i++){
                CounterWithStaticSynchronization.increment();
            }
        });

        Thread thread4 = new Thread(()->{
            for(int i=0;i<1000;i++){
                CounterWithStaticSynchronization.decrement();
            }
        });
        thread3.start();
        thread4.start();
        try{
            thread3.join();
            thread4.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter2.getCount());

        Thread thread5 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter3.increment();
            }
        });

        Thread thread6 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter3.decrement();
            }
        });
        thread5.start();
        thread6.start();
        try{
            thread5.join();
            thread6.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter3.getCount());

        Thread thread7 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter4.increment();
            }
        });

        Thread thread8 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter4.decrement();
            }
        });
        thread7.start();
        thread8.start();
        try{
            thread7.join();
            thread8.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter4.getCount());

        Thread thread9 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter5.increment();
            }
        });

        Thread thread10 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter5.decrement();
            }
        });
        thread9.start();
        thread10.start();
        try{
            thread9.join();
            thread10.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter5.getCount());
    }
}
