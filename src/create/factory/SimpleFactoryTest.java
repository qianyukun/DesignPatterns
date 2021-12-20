package create.factory;

public class SimpleFactoryTest{
    public static void main(String[] args) {
        System.out.println(SimpleFactory.createProdcut("1"));
        System.out.println(new ProductCreatorA().createProduct());
    }
}