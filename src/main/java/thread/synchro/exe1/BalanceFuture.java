package thread.synchro.exe1;

import java.util.concurrent.FutureTask;

public class BalanceFuture extends FutureTask<Integer> {
    private String name;

    public BalanceFuture(String name, BalanceTask task) {
        super(task);
        this.name = name;
    }

    @Override
    protected void done() {
        String message = name;
        try {
            message += " End with result: " + get();
        } catch (Exception e) {
            message += " End with result: " + e;
        }
        System.out.println(message);
    }
}
