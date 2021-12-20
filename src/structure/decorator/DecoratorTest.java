package structure.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConCreateDecorator1(new ConCreateDecorator(new ConCreateComponent()));
        component.component();
    }
}

interface Component{
    void component();
}

class ConCreateComponent implements Component {

    @Override
    public void component() {
        System.out.println("拍照");
    }
}

abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConCreateDecorator extends Decorator{

    public ConCreateDecorator(Component component) {
        super(component);
    }

    @Override
    public void component() {
        System.out.println("美颜");
        component.component();
    }
}

class ConCreateDecorator1 extends Decorator{

    public ConCreateDecorator1(Component component) {
        super(component);
    }

    @Override
    public void component() {
        System.out.println("美颜1");
        component.component();
    }
}
