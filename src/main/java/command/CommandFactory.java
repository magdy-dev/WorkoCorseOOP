package command;

import command.impl.*;

public class CommandFactory {

    public static Command getCommand(int commandType) {


        switch (commandType) {

            case 1:
                return new BuyBookCommand();
            case 2:
                return new ExchangeBookCommand();
            case 3:
                return new FindCommand();
            case 4:
                return new LogOutCommand();
            case 5:
                return new RentBookCommand();
            case 6:
                return new ReserveBookCommand();
            case 7:
                return new SellBookCommand();
            case 8:
                return new ViewLibraryCommand();
            case 9:
                return new DeactivateCommandCommand();
            case 10:
                return new ChangeAccountInfoCommand();
            default:
                return new CommandList();
        }
    }
}
