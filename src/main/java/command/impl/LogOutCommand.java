package command.impl;

import Controler.Controller;
import Exceptions.ServiceException;
import command.Command;

public class LogOutCommand implements Command {

    @Override
    public boolean execute() throws ServiceException {
        Controller.user.setStatus(false);
        Controller.user = null;
        return true;
    }
}
