package thread.synchro.exe1;

public abstract class Balanc {
    protected int number = 0;

    public abstract int balance();
}

class Balance extends Balanc {
    @Override
    public int balance() {
        number++;
        number--;
        return number;
    }
}

class SynchronizedBalance extends Balanc {
    @Override
    public int balance() {
        return doBalance();
    }

    private synchronized int doBalance() {
        number++;
        number--;
        return number;
    }
}

