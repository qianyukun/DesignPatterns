package create.abstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDataBaseUtils dataBaseUtils = new MySqlDataBaseUtil();
        IConnection connection = dataBaseUtils.getConnection();
        connection.connect();
        ICommand command = dataBaseUtils.getCommand();
        command.command();
    }
}
