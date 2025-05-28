// package Concurrency;

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());

        Thread.sleep(100);
        System.out.println(t1.getState());

        t1.join(); // Wait for t1 to get completed/terminated
        System.out.println(t1.getState());

    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
