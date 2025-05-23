// package Lamdas&FunctionalInterface;

public class LambaVsAnonymousClass {
    public static void main(String[] args) {
        Runnable task = new Runnable(){
            public void run(){
                System.out.println("This is anonymous class example");
            }
        };

        Runnable task2 = ()-> System.out.println("This is lambda example");

        Thread t = new Thread(task);
        Thread t2 = new Thread(task2);

        t.start();
        t2.start();
    }
}