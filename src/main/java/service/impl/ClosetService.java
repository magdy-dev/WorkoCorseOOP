package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.ClosetDAO;
import entities.Closet;
import entities.Singleton;
import service.CURDService;

public class ClosetService extends CURDService<Closet> {
    private ClosetDAO dao = Singleton.getInstance().getClosetDAO();


    @Override
    public void create(Closet entity) throws ServiceException{
        try {
            dao.insert(entity);
        }catch (DAOException e) {
            throw new ServiceException("cant create the closet", e);
        }
    }

    @Override
    public void update(Closet entity) throws ServiceException{
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create the closet", e);
        }
    }

    @Override
    public Closet read(int id) throws ServiceException {
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant create the closet", e);
        }
    }

}