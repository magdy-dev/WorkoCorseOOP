package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.AuthorDAO;
import dao.impl.BookDAO;
import dao.impl.CategoryDAO;
import entities.Author;
import entities.Book;
import entities.Category;
import entities.Singleton;
import service.CURDService;



public class BookService extends CURDService<Book> {

    private BookDAO book = Singleton.getInstance().getBookDAO();
    private AuthorDAO author = Singleton.getInstance().getAuthorDAO();
    private CategoryDAO category = Singleton.getInstance().getCategoryDAO();

    @Override
    public void create(Book entity) throws ServiceException {
        try {
            book.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("Array is already full",e);
        }
    }

    @Override
    public void update(Book entity) throws ServiceException {
        try {
            book.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("Book not found",e);
        }
    }

    @Override
    public Book read(int id) throws ServiceException {
        try {
            return book.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("ID not found",e);
        }
    }

    public Book readByName(String bookName) throws ServiceException {
        try {
            return book.selectByBookName(bookName);
        } catch (DAOException e) {
            throw new ServiceException("book not found", e);
        }
    }

    public Book readByAuthorFullName(String firstName, String lastName) throws ServiceException {
        try {
            Author au = author.selectByAuthorName(firstName, lastName);
            if (au != null) {
                return book.selectByAuthorId(au.getId());
            }
            return null;
        } catch (DAOException e) {
            throw new ServiceException("no author with this name exists", e);
        }
    }

    public Book readByCategory(String category1) throws ServiceException {
        try {
            Category category2 = category.selectByCategory(category1);
            return book.selectByCategoryId(category2.getId());
        } catch (DAOException e) {
            throw new ServiceException("no such category exists", e);
        }
    }


}
