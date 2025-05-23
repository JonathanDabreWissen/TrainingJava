// package Lamdas&FunctionalInterface;

public class AnonymousClass {
    public static void main(String[] args) {
        Runnable task = new Runnable(){
            public void run(){
                System.out.println("This is anonymous class example");
            }
        };

        Thread t = new Thread(task);
        t.start();
    }
}
