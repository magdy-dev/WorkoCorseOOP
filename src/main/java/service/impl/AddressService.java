package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.AddressDAO;
import entities.Address;
import entities.Singleton;
import service.CURDService;

public class AddressService extends CURDService<Address> {

    private AddressDAO dao = Singleton.getInstance().getAddressDAO();

    @Override
    public void create(Address entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create the address", e);
        }
    }

    @Override
    public void update(Address entity) throws ServiceException{
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update the address", e);
        }
    }

    @Override
    public Address read(int id) throws ServiceException{
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read the address", e);
        }
    }

}
