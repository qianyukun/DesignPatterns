package factory;

public class ProductCreatorA extends ProductCreator {
    @Override
    IProduct createProduct() {
        return new ProductA();
    }
}
