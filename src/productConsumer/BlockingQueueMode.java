package productConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueMode {

    public static void main(String[] args) {
        BlockingQueueMode blockingQueueMode = new BlockingQueueMode();
        new Thread(() -> {
            try {
                blockingQueueMode.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                blockingQueueMode.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                blockingQueueMode.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                blockingQueueMode.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(5);

    void produce() throws InterruptedException {
        String s = String.valueOf(System.currentTimeMillis());
        blockingQueue.put(s);
        System.out.println(s);
    }

    void consume() throws InterruptedException {
        String take = blockingQueue.take();
        System.out.println(take);
    }
}
