package structure.facade;

public class FacadeTest {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doSomething();
    }
}

class System1 {
    public void doSomething() {
        System.out.println("System1");
    }
}

class System2 {
    public void doSomething() {
        System.out.println("System2");
    }
}

class System3 {
    public void doSomething() {
        System.out.println("System3");
    }
}

class Facade {
    private System1 system1 = new System1();
    private System2 system2 = new System2();
    private System3 system3 = new System3();

    public void doSomething() {
        system1.doSomething();
        system2.doSomething();
        system3.doSomething();
    }
}
