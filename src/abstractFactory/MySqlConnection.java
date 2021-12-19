package abstractFactory;

public class MySqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("MySqlConnection.connect");
    }
}
