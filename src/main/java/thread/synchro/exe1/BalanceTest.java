package thread.synchro.exe1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BalanceTest {
    static final int NUMBER_TASK = 10;
    static final int LOOP_ITERATION = 1000000;

    private static void doStaf(Balanc balance) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < NUMBER_TASK; i++) {
            executor.execute(new BalanceFuture("w" + i, new BalanceTask(balance, LOOP_ITERATION)));
        }
        System.out.println(System.lineSeparator());
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BalanceTest test = new BalanceTest();
        long start = System.nanoTime();

        doStaf(new Balance());

        long end = System.nanoTime();
        long noSynchronizedTimeExecute = (end - start) / 1000000;

        start = System.nanoTime();

        doStaf(new SynchronizedBalance());

        end = System.nanoTime();
        long synchronizedTimeExecution = (end - start) / 1000000;

        System.out.println("Synchronized: " + synchronizedTimeExecution +
                "milisec  NO synchro: " + noSynchronizedTimeExecute+"milisec");
    }
}
