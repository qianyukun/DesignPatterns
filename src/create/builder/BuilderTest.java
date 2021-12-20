package create.builder;

public class BuilderTest {
    public static void main(String[] args) {
        ProductBuilder productBuilder = new DefaultConCreateBuilder();
        Computer computer = productBuilder
                .productName("name")
                .productName1("name1")
                .productName2("name2")
                .productName3("name3")
                .productName4("name4")
                .productName5("name5").build();
    }
}
