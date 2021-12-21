package behavior.responsibility;

public class ResponseChain {
    public static void main(String[] args) {
        BeijingPostman beijingPostman = new BeijingPostman();
        ShanghaiPostman shanghaiPostman = new ShanghaiPostman();
        beijingPostman.nextPostman = shanghaiPostman;
        beijingPostman.handleCourier("Shanghai");
    }
}

abstract class Postman {
    protected Postman nextPostman;

    public abstract boolean handleCourier(String address);
}

class BeijingPostman extends Postman {

    @Override
    public boolean handleCourier(String address) {
        if ("Beijing".equals(address)) {
            System.out.println("Beijing handle msg");
            return true;
        } else {
            System.out.println("Beijing send to next postman...");
            return nextPostman.handleCourier(address);
        }
    }
}

class ShanghaiPostman extends Postman {

    @Override
    public boolean handleCourier(String address) {
        if ("Shanghai".equals(address)) {
            System.out.println("Shanghai handle msg");
            return true;
        } else {
            return nextPostman.handleCourier(address);
        }
    }
}
