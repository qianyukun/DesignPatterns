package create.singleton;

public class SingletonTest {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(LazySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(HungrySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(HungrySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(HungrySingleton.getSingleton())).start();
//        new Thread(() -> System.out.println(InnerClassSingleton.getSingleTon())).start();
//        new Thread(() -> System.out.println(InnerClassSingleton.getSingleTon())).start();
//        new Thread(() -> System.out.println(InnerClassSingleton.getSingleTon())).start();
//        new Thread(() -> System.out.println(InnerClassSingleton.getSingleTon())).start();
        new Thread(EnumSingleton.SINGLETON::print).start();
        new Thread(EnumSingleton.SINGLETON::print).start();
        new Thread(EnumSingleton.SINGLETON::print).start();
        new Thread(EnumSingleton.SINGLETON::print).start();
        new Thread(EnumSingleton.SINGLETON::print).start();
    }
}
