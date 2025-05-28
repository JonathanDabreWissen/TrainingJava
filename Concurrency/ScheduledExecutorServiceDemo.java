// package Concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    
    public static void main(String[] args) {
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(
            ()-> System.out.println("Task executing after every 5 seconds !!"), 
            5, 
            5, 
            TimeUnit.SECONDS
        );

        scheduler.schedule(()->{
            System.out.println("Initiating shutdown...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}
