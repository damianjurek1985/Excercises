package thread.synchro.exe1;

import java.util.concurrent.Callable;

public class BalanceTask implements Callable<Integer> {
    private int count;
    private Balanc balance; //reference

    public BalanceTask(Balanc balance, int count) {
        this.balance = balance;
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result = balance.balance();
            if (result != 0) break;
        }
        return result;
    }
}
