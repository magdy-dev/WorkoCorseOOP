package command.impl;

import Exceptions.ServiceException;
import command.Command;

import entities.Book;
import service.impl.BookService;

import java.util.Scanner;

public class FindCommand implements Command {


    @Override
    public boolean execute() throws ServiceException {
        System.out.println("by tittle or by author?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("tittle")){
            System.out.println("book tittle");
            String bookName = scanner.nextLine();
            BookService bookService = new BookService();
            Book book = bookService.readByName(bookName);
            if (!book.isReserved()) {
                System.out.println(book.toString());
                System.out.println("book found");
            } else {
                System.out.println("book is reserved");
            }
            System.out.println("book found");
        } else if(choice.equals("author")) {
            System.out.println("enter author name");
            String authorName = scanner.nextLine();
            System.out.println("enter author last name");
            String authorLastName = scanner.nextLine();
            BookService bookService = new BookService();
            Book book = bookService.readByAuthorFullName(authorName, authorLastName);
            if (!book.isReserved()) {
                System.out.println(book.toString());
                System.out.println("book found");
            } else {
                System.out.println("book is reserved");
            }
        } else {
            System.out.println("book not found");
        }
        return true;
    }
}

