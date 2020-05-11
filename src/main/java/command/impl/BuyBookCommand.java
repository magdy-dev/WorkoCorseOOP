package command.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import command.Command;
import dao.impl.BookDAO;
import entities.Author;
import entities.Book;
import entities.Transaction;
import service.impl.BookService;
import service.impl.TransactionService;
import java.util.Scanner;

public class BuyBookCommand implements Command {

    private BookService bookService = new BookService();
    private TransactionService transactionService = new TransactionService();
    BookDAO bookDAO = new BookDAO();
    Transaction transaction = new Transaction();

    @Override
    public boolean execute() throws ServiceException, DAOException {
        System.out.println("by name or by author?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("name")) {
            System.out.println("book name");
            String bookName = scanner.nextLine();
            Book book1 = new Book();
            book1.setName(bookName);
            //book1.setNumberOfPages(30);
            //book1.setId(book1.hashCode());
            Book book = bookService.readByName(bookName);
            if (book != null && !book.isReserved()) {
                System.out.println(book.toString());
                transaction.setId(2);
                transaction.setUserId(-1);
                transaction.setBookId(book1.getId());
                transaction.setPrice(52);
                transactionService.create(transaction);
                bookDAO.deleteById(book1.getId());
            } else {
                System.out.println("book doesnt exist or reserved");
                return false;
            }
        } else {
            if (choice.equals("author")) {
                System.out.println("enter author first name");
                String authorName = scanner.nextLine();
                System.out.println("enter author last name");
                String authorLastName = scanner.nextLine();
                Book book = new Book();
                Author author = new Author();
                author.setFirstName(authorName);
                author.setLastName(authorLastName);
                book.setId(book.hashCode());
                Book book1 = bookService.readByAuthorFullName(authorName, authorLastName);
                if (book1 != null && book.isReserved()) {
                    System.out.println(book.toString());
                    //transaction.setId(1);
                    //transaction.setPrice(52);
                    //transactionService.create(transaction);
                } else {
                    System.out.println("book doesnt exist or reserved");
                    return false;
                }
            } else {
                System.out.println("invalid main.java.command");
            }
        }
        System.out.println("book bought successfully");

        return true;
    }
}