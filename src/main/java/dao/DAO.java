package dao;

import Exceptions.DAOException;
import dao.impl.*;
import entities.*;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    List<Category> categories = new ArrayList<Category>();
    public boolean add(Category c) throws DAOException {
        if (categories.isEmpty()){
            throw new DAOException("this category already exists");
        }
        return categories.add(c);
    }
    public Category get_C(Category c) throws DAOException {
        if (categories.isEmpty()){
            throw new DAOException("category does not exist");
        }
        return c;
    }

    List<Transaction> transactions = new ArrayList<Transaction>();
    public boolean add(Transaction t) throws DAOException {
        if (transactions.isEmpty()){
            throw new DAOException("this transactions is insufficient");
        }
        return transactions.add(t);
    }
    public Transaction get_T(Transaction t) throws DAOException {
        if (transactions.isEmpty()){
            throw new DAOException("transaction does not exist");
        }
        return t;
    }

    List<Library> libraries = new ArrayList<Library>();
    public boolean add(Library l) throws DAOException {
        if (libraries.contains(l)){
            throw new DAOException("this library already exists");
        }
        return libraries.add(l);
    }
    public Library get_L(Library l) throws DAOException {
        if (libraries.isEmpty()){
            throw new DAOException("library does not exist");
        }
        return l;
    }

    List<Closet> closets = new ArrayList<Closet>();
    public boolean add(Closet c) throws DAOException {
        if (closets.contains(c)){
            throw new DAOException("this closet already exist");
        }
        return closets.add(c);
    }
    public Closet get_C(Closet t) throws DAOException {
        if (closets.isEmpty()){
            throw new DAOException("this closet does not exist");
        }
        return t;
    }

    List<Account> accounts = new ArrayList<Account>();
    public boolean add(Account a) throws DAOException {
        if (accounts.contains(a)){
            throw new DAOException("this account already exists");
        }
        return accounts.add(a);
    }
    public Account get_A(Account a) throws DAOException {
        if (accounts.isEmpty()){
            throw new DAOException("account does not exist");
        }
        return a;
    }

    List<Address> addresses = new ArrayList<Address>();
    public boolean add(Address a) throws DAOException {
        if (addresses.contains(a)){
            throw new DAOException("this address already exists");
        }
        return addresses.add(a);
    }
    public Address get_A(Address a) throws DAOException {
        if (addresses.isEmpty()){
            throw new DAOException("address does not exist");
        }
        return a;
    }

    private CategoryDAO categoryDAO = new CategoryDAO();
    private TransactionDAO transactionDAO = new TransactionDAO();
    private LibraryDAO libraryDAO = new LibraryDAO();
    private ClosetDAO closetDAO = new ClosetDAO();
    private AccountDAO accountDAO = new AccountDAO();
    private AddressDAO addressDAO = new AddressDAO();
    private BookDAO bookDAO = new BookDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private ShelfDAO shelfDAO = new ShelfDAO();
    private BasketDAO basketDAO = new BasketDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private UserDAO userDAO = new UserDAO();

    public CategoryDAO getCategoryDAO(){
        return categoryDAO;
    }
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public TransactionDAO getTransactionDAO(){
        return transactionDAO;
    }
    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public LibraryDAO getLibraryDAO() {
        return libraryDAO;
    }
    public void setLibraryDAO(LibraryDAO libraryDAO) {
        this.libraryDAO = libraryDAO;
    }

    public ClosetDAO getClosetDAO() {
        return closetDAO;
    }
    public void setClosetDAO(ClosetDAO closetDAO) {
        this.closetDAO = closetDAO;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }
    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AddressDAO getAddressDAO() {
        return addressDAO;
    }
    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public ShelfDAO getShelfDAO() {
        return shelfDAO;
    }
    public void setShelfDAO(ShelfDAO shelfDAO) {
        this.shelfDAO = shelfDAO;
    }

    public BasketDAO getBasketDAO() {
        return basketDAO;
    }
    public void setBasketDAO(BasketDAO basketDAO) {
        this.basketDAO = basketDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
