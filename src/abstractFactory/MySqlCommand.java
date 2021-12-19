package abstractFactory;

public class MySqlCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("MySqlConnection.command");
    }
}
