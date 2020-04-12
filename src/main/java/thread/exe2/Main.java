package thread.exe2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Long>> res = new ArrayList<>();
        for (Integer n : new int[]{100, 50, 17, 22, 43}) {
            Future<Long> fut = exec.submit(new FibCall(n));
            res.add(fut);
        }
        while (res.size() > 0) {
            Thread.sleep(5);
            for (Iterator<Future<Long>> it = res.iterator(); it.hasNext(); ) {
                Future<Long> fut = it.next();
                if (fut.isDone()) {
                    System.out.println("Result: " + fut.get());
                }
                it.remove();
                System.out.println("Remaining: " + res.size());
            }
        }
        exec.shutdown();


        System.out.println("===========");
        ExecutorService execc = Executors.newCachedThreadPool();
        for (Integer n : new int[]{ 44, 17, 22, 43}) {
           execc.execute(new FutureFib(new FibCall((n))));
        }
        execc.shutdown();
    }
}
