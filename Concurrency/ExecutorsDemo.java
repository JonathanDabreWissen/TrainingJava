// package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 1; i<10; i++) {
            int finalI = i;
            executor.submit(
                ()->{
                    long result = factorial(finalI);
                    System.out.println(result);
                }
            );
        }

        executor.shutdown();// After shutdown we cannot submit more tasks
        try{
            //executor.awaitTermination(100, TimeUnit.SECONDS);//finite wait
            //executor.awaitTermination(1, TimeUnit.SECONDS); //Returns True if terminatio successfull, False if time elapses
            //Infinite wait
            while(!executor.awaitTermination(1, TimeUnit.SECONDS)){
                System.out.println("waiting...");
            }
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Total time: " +(System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long result = 1;
        for(int i = 1; i<=n; i++){
            result *=i;
        }
        return result;
    }
}
