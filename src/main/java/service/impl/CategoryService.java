package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.CategoryDAO;
import entities.Category;
import entities.Singleton;
import service.CURDService;

public class CategoryService extends CURDService<Category> {
private CategoryDAO dao = Singleton.getInstance().getCategoryDAO();


    @Override
    public void create(Category entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create the category", e);
        }
    }

    @Override
    public void update(Category entity) throws ServiceException{
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update the category", e);
        }
    }

    @Override
    public Category read(int id) throws ServiceException{
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read the category", e);
        }
    }


}
