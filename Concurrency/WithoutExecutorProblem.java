// package Concurrency;

public class WithoutExecutorProblem {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];

        for(int i = 1; i<10; i++) {
            int finalI = i;
            threads[i-1] = new Thread(()->{
                long result = factorial(finalI);
                System.out.println(result);
            });

            threads[i-1].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
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
