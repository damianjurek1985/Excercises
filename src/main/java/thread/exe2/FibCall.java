package thread.exe2;

import java.util.concurrent.Callable;

public class FibCall implements Callable<Long> {
    private int num;

    public FibCall(int n) throws InterruptedException {
        Thread.sleep(n);
        num = n;
    }

    private long fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }

    public Long call() throws Exception {
        return fib(num);
    }

    @Override
    public String toString() {
        return "fib(" + num + ")";
    }
}
