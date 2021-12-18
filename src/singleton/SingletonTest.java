package singleton;

public class SingletonTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
    }
}
