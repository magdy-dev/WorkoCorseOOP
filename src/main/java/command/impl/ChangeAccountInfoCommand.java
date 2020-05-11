package command.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import command.Command;
import entities.Account;
import service.impl.AccountService;

import java.util.Scanner;

public class ChangeAccountInfoCommand implements Command {
    @Override
    public boolean execute() throws ServiceException, DAOException {
        System.out.println("to change your username enter 1 \nto change your password enter 2\nto change both enter 3");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1": {
                System.out.println("enter your current username");
                String originalUsername = scanner.nextLine();
                System.out.println("enter your current password");
                String pass = scanner.nextLine();
                System.out.println("enter new username");
                String newUsername = scanner.nextLine();
                AccountService accountService = new AccountService();
                Account account = accountService.readByUsername(originalUsername, pass);
                account.setUserName(newUsername);
                System.out.println("username has been changed successfully");
                break;
            }
            case "2": {
                System.out.println("enter your current username");
                String username = scanner.nextLine();
                System.out.println("enter your current password");
                String password = scanner.nextLine();
                System.out.println("enter your new password");
                String newPass = scanner.nextLine();
                AccountService accountservice = new AccountService();
                Account account = accountservice.readByUsername(username, password);
                account.setPassword(newPass);
                System.out.println("password has been changed successfully");
                break;
            }
            case "3": {
                System.out.println("enter your current username");
                String username = scanner.nextLine();
                System.out.println("enter your current password");
                String password = scanner.nextLine();
                System.out.println("enter your new password");
                String newPass = scanner.nextLine();
                System.out.println("enter your new username");
                String newUsername = scanner.nextLine();
                AccountService accountservice = new AccountService();
                Account account = accountservice.readByUsername(username, password);
                account.setUserName(newUsername);
                account.setPassword(newPass);
                System.out.println("password and username has been changed successfully");
                break;
            }
            default:
                System.out.println("invalid main.java.command");
                break;
        }
        return true;
    }
}
//changing the username and password of said account
//