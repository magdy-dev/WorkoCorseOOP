package command.impl;

import Exceptions.ServiceException;
import command.Command;
import entities.Book;
import service.impl.BookService;
import service.impl.LibraryService;

import java.util.Scanner;

public class ViewLibraryCommand implements Command {

    private LibraryService libraryService = new LibraryService();
    private BookService bookService = new BookService();


    @Override
    public boolean execute() throws ServiceException {
        System.out.println("by category or author?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("author")){
            System.out.println("enter author's first name");
            String authorFirstName = scanner.nextLine();
            System.out.println("enter author's last name");
            String authorLastName = scanner.nextLine();
            Book book = bookService.readByAuthorFullName(authorFirstName, authorLastName);
            System.out.println(book.toString());
        } else if (choice.equals("category")){
            System.out.println("enter required category");
            String category = scanner.nextLine();
            Book book = bookService.readByCategory(category);
            System.out.println(book.toString());
        } else {
            System.out.println("invalid main.java.command");
        }

        return true;
    }
}
