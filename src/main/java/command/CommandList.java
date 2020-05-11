package command;

public class CommandList implements Command {
    @Override
    public boolean execute() {
        System.out.println("Command list:\n1) buy_command\n2) exchange_command\n3) find_command" +
                "\n4) logout_command\n5) rent_command\n6) reserve_command\n7) sell_command" +
                "\n8) view_command\n9) deactivate_account_command\n10) change_account_info_command");
        return true;
    }
}
