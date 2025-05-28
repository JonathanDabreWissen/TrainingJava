// package Concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, NullPointerException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(()->42);
        System.out.println(future.get());

        Callable<String> c1 = ()-> "Hello World";
        Future<String> future2 = executorService.submit(c1);
        System.out.println(future2.get());
        
        Future<String> future3 = executorService.submit(()->System.out.println("Task Performing"), "Task Performed Succesfully");
        System.out.println(future3.isDone());
        System.out.println(future3.get());
        System.out.println(future3.isDone());

        Callable<Integer> call1 = ()->1;
        Callable<Integer> call2 = ()->2;
        Callable<Integer> call3 = ()->3;


        List<Callable<Integer>> list = Arrays.asList(call1, call2, call3);
        List<Future<Integer>> futures = executorService.invokeAll(list);
        for (Future<Integer> f : futures) {
            System.out.println(f.get());
        }

        executorService.shutdown();
        System.out.println(executorService.isTerminated());
    }

}
