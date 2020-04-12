package thread.exe2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureFib extends FutureTask<Long> {
    private Callable<Long> callable;

    public FutureFib(Callable<Long> callable) {
        super(callable);
        this.callable = callable;
    }

    protected void done() {
        String msg = "Result: " + callable + " =";
        if (this.isCancelled()) {
            msg += " ... task cancelled";
        } else {
            try {
                msg += this.get();
            } catch (InterruptedException | ExecutionException e) {
                msg += " ... exception " + e;
            }
            System.out.println(msg);
        }
    }
}
