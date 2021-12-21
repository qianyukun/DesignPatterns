package behavior.template;

public class TemplateTest {
    public static void main(String[] args) {
        TemplateClass templateClass = new SubClass();
        templateClass.operate();
    }
}

/**
 * 定义算法模板，子类去做具体实现
 */
abstract class TemplateClass {
    void operate() {
        System.out.println("step1");
        System.out.println("step2");
        templateMethod();
    }

    abstract void templateMethod();
}

/**
 * 子类实现具体的模板方法
 */
class SubClass extends TemplateClass {

    @Override
    void templateMethod() {
        System.out.println("sub class templateMethod()");

    }
}
