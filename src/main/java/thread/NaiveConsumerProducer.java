package thread;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class NaiveConsumerProducer {
    private static final Random generator = new Random();
    private static final Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        int itemCount = 5;
        Thread producer = new Thread(() -> {
            for (int i = 0; i < itemCount; i++) {
                try {
                    Thread.sleep(Duration.ofSeconds(generator.nextInt(5)).toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (queue) {
                    queue.add("Item no. " + i);
                    queue.notify();  //check without notify(),and simples implementation synchronized(queue)
                }
            }
        });
        AtomicLong numbersOfConsumerWork = new AtomicLong();
        Thread consumer = new Thread(() -> {
            int itemsLeft = itemCount;
            while (itemsLeft > 0) {
                String item;
                numbersOfConsumerWork.getAndIncrement();
//                synchronized (queue) {
//                    if (queue.isEmpty()) {
//                        continue;
//                    }
//                    item = queue.poll();
//                }
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    item = queue.poll();
                }
                itemsLeft--;
                System.out.println("Consumer got item: " + item);
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Consumer Work times: "+numbersOfConsumerWork);
    }
}