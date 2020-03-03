package thread;

public class ExeThread {
    private Object helpStick1 = new Object();
    private Object helpStick2 = new Object();
    private Object helpStick3 = new Object();


    public void startReverseNestedThreads(int i) throws InterruptedException {
        Thread thread = new Thread(() -> {
            if (i > 1) {
                try {
                    this.startReverseNestedThreads(i - 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println(thread.getName());
    }

    public void startNestedThreads(int i) {
        Thread thread = new Thread(() -> {
            if (i > 1) {
                this.startNestedThreads(i - 1);
            }
        });
        System.out.println(thread.getName());
        thread.start();

    }

    public static void main(String[] args) throws InterruptedException {
//        new ExeThread().startNestedThreads(3);
        new ExeThread().startReverseNestedThreads(3);

    }
}