package singleton;

public class LazySingleton {
    //禁止指令重排
    private static volatile LazySingleton singleton;

    private LazySingleton() {
    }

    public static LazySingleton getSingleton() {
        //如果已经有实例，就没有必要加锁
        if (singleton == null) {
            //加锁较耗性能，范围越小越好
            synchronized (LazySingleton.class) {
                //多线程下可能会有已经实例化
                if (singleton == null) {
                    //这一行代码，实际上在字节码中，需要三个步骤才能完成；
                    //1、分配空间
                    //2、初始化
                    //3、赋值
                    //没有volatile修饰时，会出现指令重排导致的异常情况
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

}
