package create.factory;

public class SimpleFactory {
    public static IProduct createProdcut(String type) {
        if (type.equals("1")) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }
}


