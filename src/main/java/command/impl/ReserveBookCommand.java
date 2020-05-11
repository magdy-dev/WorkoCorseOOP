package command.impl;

import Exceptions.ServiceException;
import command.Command;
import entities.Book;
import service.impl.BookService;

import java.util.Scanner;


public class ReserveBookCommand implements Command {

    @Override
    public boolean execute() throws ServiceException {
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the book you want to reserve");
        String bookName = scanner.nextLine();
        Book book = bookService.readByName(bookName);
        if (book.isReserved()) {
            System.out.println("book is already reserved");
        } else {
            book.setStatus(true);
            System.out.println("book reserved successfully");
        }
        return true;
    }
}
