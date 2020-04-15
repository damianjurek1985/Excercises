package thread.exe3;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static class LetterTask implements Runnable {
        private String letters;

        public LetterTask(String letters) {
            this.letters = letters;
        }

        @Override
        public void run() {
            String out = "";
           outLoop: while (true) {
                for (int i = 0; i < 20000; i++) {
                    if(Thread.interrupted()) break outLoop;
                    out += letters;
                }
                System.out.println(letters);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println(letters = " length = " + out.length());
        }
    }

    public static void main(String[] args) {
        Map<String, Future<?>> taskMap = new HashMap<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        for(char c: "ABCDEF".toCharArray()){
            String letters = ""+c;
            taskMap.put(letters,executor.submit(new LetterTask(letters)));
        }

        while(true){
            String s = JOptionPane.showInputDialog("Task to stop [A B ..],PUT A B C D E F");
            if( s == null){
                break;
            }
            for(String taskLett:s.trim().toUpperCase().split("\\s")){//\\s - shite space
                Future<?> task= taskMap.get(taskLett);
                if(task !=null){
                    task.cancel(true);
                    taskMap.remove(taskLett);
                }
            }
            if(taskMap.size() == 0) break;
        }
        executor.shutdown();
    }
}
