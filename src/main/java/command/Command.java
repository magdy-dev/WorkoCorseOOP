package command;

import Exceptions.DAOException;
import Exceptions.ServiceException;


public interface Command {

    boolean execute() throws ServiceException, DAOException;


}
