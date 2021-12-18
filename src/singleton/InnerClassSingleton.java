package singleton;

//step 1
public class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    //step 2
    public static InnerClassSingleton getSingleTon() {
        //step 3
        return InnerClassSingletonHolder.innerClassSingletonHolder;
    }

    //step 4 静态内部类加载
    private static class InnerClassSingletonHolder {
        //step 5 类加载完成时创建
        private static InnerClassSingleton innerClassSingletonHolder = new InnerClassSingleton();
    }
}
