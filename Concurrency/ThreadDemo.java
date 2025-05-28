// package Concurrency;

public class ThreadDemo {
    public static void main(String[] args) {
        
        World world = new World();
        // world.run(); //Would have ran this in the main thread and not seperate one.
        world.start(); //Creates new Call stack.

        Thread t1 = new Thread(new World2());
        t1.start();

        for(int i=0; i<100; i++ ){
            System.out.println("Hello");
        }
    }   
}

class World extends Thread{
    @Override
    public void run(){
        for(int i=0; i<100; i++ ){
            System.out.println("World");
        }
    }
}

class World2 implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<100; i++ ){
            System.out.println("World2");
        }
    }
}

