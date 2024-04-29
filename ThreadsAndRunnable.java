class PrintNumbers{
    public void print(int n){
        for(int i=n;i<n+5;i++){
            System.out.println(Thread.currentThread());
            System.out.println(i);
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+" done the process");
    }
}

class PrintNumbersRunnable implements Runnable{
    int n;
    PrintNumbers printNumbers;
    PrintNumbersRunnable(int n, PrintNumbers printNumbers){
        this.n = n;
        this.printNumbers = printNumbers;
    }
    @Override
    public void run() {
        printNumbers.print(n);
    }
}

class PrintNumbersThread extends Thread{
    int n;
    PrintNumbers printNumbers;
    PrintNumbersThread(int n, PrintNumbers printNumbers){
        this.n = n;
        this.printNumbers = printNumbers;
    }
    @Override
    public void run() {
        printNumbers.print(n);
    }
}



public class ThreadsAndRunnable {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        PrintNumbersThread printNumbersThread = new PrintNumbersThread(10, printNumbers);
        PrintNumbersThread printNumbersThread2 = new PrintNumbersThread(100, printNumbers);
        printNumbersThread.start();
        printNumbersThread2.start();
        try{
            printNumbersThread.join();
            printNumbersThread2.join();
        }catch(Exception e){
            e.printStackTrace();
        }

        PrintNumbersRunnable printNumbersRunnable1 = new PrintNumbersRunnable(50, printNumbers);
        PrintNumbersRunnable printNumbersRunnable2 = new PrintNumbersRunnable(500, printNumbers);
        Thread printNumbersRunnableThread1 = new Thread(printNumbersRunnable1);
        Thread printNumbersRunnableThread2 = new Thread(printNumbersRunnable2);
        printNumbersRunnableThread1.start();
        printNumbersRunnableThread2.start();
        try{
            printNumbersThread.join();
            printNumbersThread2.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
