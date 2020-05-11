package Controler;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import command.Command;
import command.CommandFactory;
import command.CommandList;
import command.impl.LogInCommand;
import command.impl.RegisterCommand;
import dao.connection.ConnBuilder;
import dao.impl.AccountDAO;
import dao.impl.UserDAO;
import entities.*;
import service.impl.*;
import java.util.Scanner;

public class Controller {
    public static User user;

    public static void main(String[] args) throws ServiceException, DAOException {
        Scanner scanner = new Scanner(System.in);

        int input = 100;

        while (input != 0) {
            if (user == null) {
                System.out.println("1)register or 2)login");
                input = scanner.nextInt();
                Command command = null;
                switch (input) {
                    case 1:
                        command = new RegisterCommand();
                        break;
                    case 2:
                        command = new LogInCommand();
                        break;
                }
                if (command != null) {
                    command.execute();
                }
            } else {
                Command commandList = new CommandList();
                commandList.execute();
                input = scanner.nextInt();
                Command command = CommandFactory.getCommand(input);
                boolean result = command.execute();
                if (!result) {
                    System.out.println("invalid main.java,command");
                }
            }
        }
    }


    public static void init() throws ServiceException {
        TransactionService transactionService = new TransactionService();
        CategoryService categoryService = new CategoryService();
        AccountService accountService = new AccountService();
        AddressService addressService = new AddressService();
        AuthorService authorService = new AuthorService();
        UserService userService = new UserService();
        BookService bookService = new BookService();

        Transaction transaction = new Transaction();
        Category category = new Category();
        Account account = new Account();
        Address address = new Address();
        Author author = new Author();
        User user = new User();
        Book book = new Book();

        user.setPhoneNumber("08255422125");
        user.setFirstName("magdy");
        user.setLastName("shenoda");
        user.setStatus(true);
        user.setAddressId(address.getId());
        user.setId(user.hashCode());
        userService.create(user);

        address.setCountry("egypt");
        address.setRegion("hurgada");
        address.setStreet("sherton");
        address.setApartment(20);
        address.setId(address.hashCode());
        addressService.create(address);

        account.setUserName("jon");
        account.setPassword("wick");
        account.setRole("guest");
        account.setUserId(user.getId());
        account.setId(account.hashCode());
        accountService.create(account);

        author.setFirstName("jon");
        author.setLastName("wang");
        author.setId(author.hashCode());
        authorService.create(author);

        category.setCategory("horror");
        category.setId(category.hashCode());
        categoryService.create(category);

        book.setName("ages");
        book.setNumberOfPages(600);
        book.setCategoryId(category.getId());
        book.setAuthorId(author.getId());
        book.setId(book.hashCode());
        bookService.create(book);

        transaction.setDate("15th of april");
        transaction.setPrice(50);
        transaction.setUserId(user.getId());
        transaction.setBookId(book.getId());
        transaction.setId(transaction.hashCode());
        transactionService.create(transaction);
    }
}

