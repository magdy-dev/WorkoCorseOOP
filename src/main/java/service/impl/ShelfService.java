package service.impl;


import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.ShelfDAO;
import entities.Shelf;
import entities.Singleton;
import service.CURDService;

public class ShelfService extends CURDService<Shelf> {

    private ShelfDAO shelf = Singleton.getInstance().getShelfDAO();

    @Override
    public void create(Shelf entity) throws ServiceException {
        try {
            shelf.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("Array is already full", e);
        }
    }

    @Override
    public void update(Shelf entity) throws ServiceException {
        try {
            shelf.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("Shelf not found", e);
        }
    }

    @Override
    public Shelf read(int id) throws ServiceException {
        try {
            return shelf.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("ID not found", e);
        }
    }

}
