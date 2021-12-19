package abstractFactory;

public interface IDataBaseUtils {
    IConnection getConnection();

    ICommand getCommand();
}
