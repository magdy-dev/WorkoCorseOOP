package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.BasketDAO;
import entities.Basket;
import entities.Singleton;
import service.CURDService;

public class BasketService extends CURDService<Basket> {

    private BasketDAO basket = Singleton.getInstance().getBasketDAO();

    @Override
    public void create(Basket entity) throws ServiceException {
        try {
            basket.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("Array is already full",e);
        }
    }

    @Override
    public void update(Basket entity) throws ServiceException {
        try {
            basket.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("Basket not found",e);
        }
    }

    @Override
    public Basket read(int id) throws ServiceException {
        try {
            return basket.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("ID not found",e);
        }
    }
}
