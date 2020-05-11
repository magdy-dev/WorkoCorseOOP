package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.LibraryDAO;
import entities.Library;
import entities.Singleton;
import service.CURDService;

public class LibraryService extends CURDService<Library> {
    private LibraryDAO dao = Singleton.getInstance().getLibraryDAO();

    @Override
    public void create(Library entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create the library", e);
        }
    }

    @Override
    public void update(Library entity) throws ServiceException{
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update the library", e);
        }
    }

    @Override
    public Library read(int id) throws ServiceException{
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read the library", e);
        }
    }

}
