package abstractFactory;

public class MySqlDataBaseUtil implements IDataBaseUtils {

    @Override
    public IConnection getConnection() {
        return new MySqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MySqlCommand();
    }
}
