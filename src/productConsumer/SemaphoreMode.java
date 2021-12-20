package productConsumer;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreMode {
    public static void main(String[] args) {
        SemaphoreMode sm = new SemaphoreMode();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    sm.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    sm.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private final Semaphore canProduct = new Semaphore(5);
    private final Semaphore canConsume = new Semaphore(5);

    private final LinkedList<String> buffer = new LinkedList<>();
    private final Semaphore lock = new Semaphore(1);

    void product() throws InterruptedException {
        if (canProduct.tryAcquire()) {
            lock.acquire();
            String s = String.valueOf(System.currentTimeMillis());
            System.out.println("product "+s);
            buffer.push(s);
            lock.release();
            canConsume.release();
        }
    }

    void consume() throws InterruptedException {
        if (canConsume.tryAcquire()) {
            lock.acquire();
            String s = buffer.removeFirst();
            System.out.println("consume "+s);
            lock.release();
            canProduct.release();
        }
    }
}
