package productConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMode {
    public static void main(String[] args) {
        ReentrantLockMode reentrantLockMode = new ReentrantLockMode();
        new Thread(reentrantLockMode::produce).start();
        new Thread(reentrantLockMode::produce).start();
        new Thread(reentrantLockMode::produce).start();
        new Thread(reentrantLockMode::produce).start();
        new Thread(reentrantLockMode::produce).start();
        new Thread(reentrantLockMode::consume).start();
        new Thread(reentrantLockMode::consume).start();
        new Thread(reentrantLockMode::consume).start();
        new Thread(reentrantLockMode::consume).start();
        new Thread(reentrantLockMode::consume).start();
    }
    private LinkedList<String> buffer = new LinkedList<>();
    private int MAX = 5;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    void produce(){
        lock.lock();
        while (buffer.size()>=MAX){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.addFirst(String.valueOf(System.currentTimeMillis()));
        condition.signalAll();
        lock.unlock();
    }

    void consume(){
        lock.lock();
        while (buffer.isEmpty()){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(buffer.removeFirst());
        condition.signalAll();
        lock.unlock();
    }
}
