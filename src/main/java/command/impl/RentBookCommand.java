package command.impl;

import Exceptions.ServiceException;
import command.Command;
import entities.Book;
import service.impl.BookService;

import java.util.Scanner;

public class RentBookCommand implements Command {


    @Override
    public boolean execute() throws ServiceException {
        System.out.println("by book name or author name");
        Scanner scanners = new Scanner(System.in);
        String method = scanners.nextLine();
        if (method.equals("book name")){
            System.out.println("enter book name");
            String bookName = scanners.nextLine();
            System.out.println("enter category");
            String category = scanners.nextLine();
            BookService bookService = new BookService();
            Book book = bookService.readByName(bookName);
            Book book1 = bookService.readByCategory(category);
            if (book1.getCategoryId() == book.getCategoryId() && !book.isReserved()) {
                System.out.println(book.toString());
            } else {
                System.out.println("book is reserved");
            }
        } else if(method.equals("author")){
            System.out.println("enter author first name");
            String firstName = scanners.nextLine();
            System.out.println("enter author last name");
            String lastName = scanners.nextLine();
            BookService bookService = new BookService();
            Book book1 = bookService.readByAuthorFullName(firstName, lastName);
            if (book1.isReserved() == false) {
                System.out.println(book1.toString());
            } else {
                System.out.println("book is reserved");
            }
        } else{
            System.out.println("invalid main.java.command");
        }

        return true;
    }
}
