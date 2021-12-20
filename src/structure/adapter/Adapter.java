package structure.adapter;


class Adaptee {
    public int outV() {
        return 220;
    }
}

interface TargetV {
    int outputV();
}


public class Adapter extends Adaptee implements TargetV {

    @Override
    public int outputV() {
        System.out.println(outV() + " -> " + 5);
        return 5;
    }

    public static void main(String[] args) {
        TargetV adapter = new Adapter();
        adapter.outputV();
    }
}
