package thread.exe1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Executorr {

    public static void main(String[] args) {
        java.util.concurrent.Executor exec = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 4; i++) {
            exec.execute(new Task("task" + i, i * 1000));
        }
    }

    private static class Task implements Runnable {
        private String name;
        private final int N;

        public Task(String name, int n) {
            this.name = name;
            N = n;
        }

        public void run() {
            int sum = 0;
            for (int i = 1, k = 0; i <= N; i++) {
                if (i % 1000 == 0) {
                    System.out.println(name + " ...count " + (k += 1000));
                    sum +=i;
                }
                System.out.println(name + ", sum = " + sum);
            }
        }
    }
}