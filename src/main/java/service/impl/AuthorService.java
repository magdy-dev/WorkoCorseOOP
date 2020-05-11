package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.AuthorDAO;
import entities.Author;
import entities.Singleton;
import service.CURDService;

public class AuthorService extends CURDService<Author> {

    private AuthorDAO author = Singleton.getInstance().getAuthorDAO();

    @Override
    public void create(Author entity) throws ServiceException {
        try {
            author.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("Array is already full",e);
        }
    }

    @Override
    public void update(Author entity) throws ServiceException {
        try {
            author.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("Author not found",e);
        }
    }

    @Override
    public Author read(int id) throws ServiceException {
        try {
            return author.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("ID not found",e);
        }
    }

    public Author readByName(String firstName, String lastName) throws ServiceException {
        try {
            return author.selectByAuthorName(firstName, lastName);
        } catch (DAOException e) {
            throw new ServiceException("cant get this info", e);
        }
    }

}

