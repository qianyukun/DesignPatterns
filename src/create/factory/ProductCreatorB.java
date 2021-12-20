package create.factory;

public class ProductCreatorB extends ProductCreator {
    @Override
    IProduct createProduct() {
        return new ProductB();
    }
}
