package command.impl;

import Exceptions.ServiceException;
import command.Command;
import entities.Author;
import entities.Book;
import service.impl.AuthorService;
import service.impl.BookService;

import java.util.Scanner;

public class ExchangeBookCommand implements Command {
    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();

    @Override
    public boolean execute() throws ServiceException {
        Book book = new Book();
        Author author = new Author();
        Scanner scanner = new Scanner(System.in);
            System.out.println("enter title of the old book");
            String oldBookName = scanner.nextLine();
            System.out.println("enter the author's of the old book's first name");
            String oldAuthorFirstName = scanner.nextLine();
            System.out.println("enter the author's of the old book's last name");
            String oldAuthorLastName = scanner.nextLine();
            System.out.println("enter the title of the required book");
            String newBookName = scanner.nextLine();
            System.out.println("enter the author of the required book's first name");
            String newBookAuthorFirstName = scanner.nextLine();
            System.out.println("enter the author of the required book's last name");
            String newBookAuthorLastName = scanner.nextLine();
            Book book1 = bookService.readByName(newBookName);
            Author author1 = authorService.readByName(newBookAuthorFirstName, newBookAuthorLastName);
            book.setName(oldBookName);
            author.setFirstName(oldAuthorFirstName);
            author.setLastName(oldAuthorLastName);
            bookService.create(book);
            authorService.create(author);
            if ( book.isReserved() && newBookAuthorFirstName.equals(author1.getFirstName())
                    && newBookAuthorLastName.equals(author1.getLastName())
                    && newBookName.equals(book1.getName()) ) {
                System.out.println(book1.toString());
                System.out.println("book exchanged successfully");
            } else {
                System.out.println("no such book is available or reserved");
            }
        return true;
    }
}
