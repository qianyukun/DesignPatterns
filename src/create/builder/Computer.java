package create.builder;

public class Computer {
    private String name;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;


    public Computer(String name, String name1, String name2, String name3, String name4, String name5) {
        this.name = name;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
    }
}

/**
 * 定义属性创建,这里采用流式调用方式
 */
interface ProductBuilder {
    ProductBuilder productName(String name);

    ProductBuilder productName1(String name1);

    ProductBuilder productName2(String name2);

    ProductBuilder productName3(String name3);

    ProductBuilder productName4(String name4);

    ProductBuilder productName5(String name5);

    Computer build();
}

/**
 * 默认创建器
 */
class DefaultConCreateBuilder implements ProductBuilder {
    private String name;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;

    @Override
    public ProductBuilder productName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilder productName1(String name1) {
        this.name = name1;
        return this;
    }

    @Override
    public ProductBuilder productName2(String name2) {
        this.name = name2;
        return this;
    }

    @Override
    public ProductBuilder productName3(String name3) {
        this.name = name3;
        return this;
    }

    @Override
    public ProductBuilder productName4(String name4) {
        this.name = name4;
        return this;
    }

    @Override
    public ProductBuilder productName5(String name5) {
        this.name = name5;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(name, name1, name2, name3, name4, name5);
    }
}