package productConsumer;

import java.util.LinkedList;

public class SynchronizeMode {
    public static void main(String[] args) {
        SynchronizeMode synchronizeMode = new SynchronizeMode();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::product).start();
        new Thread(synchronizeMode::consume).start();
        new Thread(synchronizeMode::consume).start();
        new Thread(synchronizeMode::consume).start();
        new Thread(synchronizeMode::consume).start();
        new Thread(synchronizeMode::consume).start();
        new Thread(synchronizeMode::consume).start();
    }

    private LinkedList<String> buffer = new LinkedList<>();
    private int MAX = 5;
    private Object lock = new Object();

    public void product() {
        //获取锁
        synchronized (lock) {
            //如果满，
            if (buffer.size() >= MAX) {
                try {
                    //循环等待
                    while (true) {
                        System.out.println("product wait");
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.addLast(String.valueOf(System.currentTimeMillis()));
            System.out.println("product");
            //唤醒所有等待锁的线程
            lock.notifyAll();
        }
    }

    public void consume() {
        synchronized (lock) {
            if (buffer.isEmpty()) {
                try {
                    lock.wait();
                    System.out.println("consume wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("consume");
            buffer.removeFirst();
            lock.notifyAll();
        }

    }
}
