package singleton;

/**
 * 饿汉模式
 * <p>
 * 类加载初始化阶段完成了实例的初始化，借助JVM保证单例唯一性
 * <p>
 * 类加载过程：
 * 1、加载二进制数据到内存，生成Class数据结构
 * 2、链接：a、验证；b、准备（静态变量赋默认值）；c、解析
 * 3、初始化：静态变量赋初值
 * <p>
 * 只有使用到时才会加载和初始化，比如：new，访问静态属性，访问方法，反射访问类，初始化子类等
 */
public class HungrySingleton {
    private HungrySingleton() {
    }

    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getSingleton() {
        return singleton;
    }
}
