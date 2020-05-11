package command.impl;

import Exceptions.ServiceException;
import command.Command;
import entities.Author;
import entities.Book;
import entities.Category;
import entities.Transaction;
import service.impl.BookService;
import service.impl.TransactionService;

import java.util.Scanner;

public class SellBookCommand implements Command {

    BookService bookService = new BookService();
    TransactionService transactionService = new TransactionService();
    @Override
    public boolean execute() throws ServiceException {
        System.out.println("enter category");
        Scanner scanner = new Scanner(System.in);
        String categoryName = scanner.nextLine();
        System.out.println("enter name");
        String tittle = scanner.nextLine();
        System.out.println("enter author's first name");
        String authorFirstName = scanner.nextLine();
        System.out.println("enter author's last name");
        String authorLastName = scanner.nextLine();

        Book book = new Book();
        Category category = new Category();
        category.setCategory(categoryName);
        category.setId(categoryName.hashCode());
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        author.setId(author.hashCode());
        book.setName(tittle);
        book.setNumberOfPages(30);
        book.setId(book.hashCode());
        book.setCategoryId(category.getId());
        book.setAuthorId(author.getId());
        bookService.create(book);
        Transaction transaction = new Transaction();
        transaction.setId(2);
        transaction.setPrice(-50);
        transaction.setBookId(book.getId());
        transaction.setUserId(-1);
        transactionService.create(transaction);
        System.out.println("book saved successfully!");
            return true;
    }
}
