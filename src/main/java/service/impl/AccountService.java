package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.AccountDAO;
import entities.Account;
import entities.Singleton;
import service.CURDService;

public class AccountService extends CURDService<Account> {
    private AccountDAO dao = Singleton.getInstance().getAccountDAO();


    @Override
    public void create(Account entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create an account", e);
        }
    }

    @Override
    public void update(Account entity) throws ServiceException {
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update the account", e);
        }
    }

    @Override
    public Account read(int id) throws ServiceException {
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read the account", e);
        }
    }

    public Account readByUsername(String username, String password) throws ServiceException {
        try {
            return dao.selectByUsernameAndPassword(username, password);
        } catch (DAOException e) {
            throw new ServiceException("cant get this info", e);
        }
    }

}

