package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.OrderDAO;
import entities.Order;
import entities.Singleton;
import service.CURDService;

public class OrderService extends CURDService<Order> {

    private OrderDAO order = Singleton.getInstance().getOrderDAO();

    @Override
    public void create(Order entity) throws ServiceException {
        try {
            order.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("Array is already full",e);
        }
    }

    @Override
    public void update(Order entity) throws ServiceException {
        try {
            order.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("Order not found",e);
        }
    }

    @Override
    public Order read(int id) throws ServiceException {
        try {
            return order.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("ID not found",e);
        }
    }


}
