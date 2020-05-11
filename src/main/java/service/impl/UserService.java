package service.impl;


import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.AccountDAO;
import dao.impl.UserDAO;
import entities.Account;
import entities.Singleton;
import entities.User;
import service.CURDService;

public class UserService extends CURDService<User> {

    private AccountDAO accountDAO = Singleton.getInstance().getAccountDAO();
    private UserDAO user = Singleton.getInstance().getUserDAO();

    @Override
    public void create(User entity) throws ServiceException {
        try {
            user.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("Array is already full",e);
        }
    }

    @Override
    public void update(User entity) throws ServiceException {
        try {
            user.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("User not found",e);
        }
    }

    @Override
    public User read(int id) throws ServiceException {
        try {
            return user.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("ID not found",e);
        }
    }

    public User readByUsernameAndPassword(String username, String password) throws ServiceException {
        try {
            Account account = accountDAO.selectByUsernameAndPassword(username, password);
            return user.selectById(account.getUserId());
        } catch (DAOException e) {
            throw new ServiceException("no user by this id exists");
        }
    }

}
