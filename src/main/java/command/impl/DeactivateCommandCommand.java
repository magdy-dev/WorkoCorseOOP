package command.impl;

import Exceptions.ServiceException;
import command.Command;
import entities.Account;
import entities.User;
import service.impl.AccountService;
import service.impl.TransactionService;
import service.impl.UserService;

import java.util.Scanner;

public class DeactivateCommandCommand implements Command {
    @Override
    public boolean execute() throws ServiceException{
        System.out.println("for deactivating press 1 and for going back press 2");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("1")){
            System.out.println("enter your username");
            String userName = scanner.nextLine();
            System.out.println("enter your password");
            String pass = scanner.nextLine();
            Account account = new Account();
            AccountService accountService = new AccountService();
            account.setUserName(userName);
            account.setPassword(pass);
            Account account1 = accountService.readByUsername(userName, pass);
            if (account1 != null){
                UserService userService = new UserService();
                User user = userService.readByUsernameAndPassword(userName, pass);
                TransactionService transactionService = new TransactionService();
                System.out.println("account deactivated");
            }
        } else {
            if (choice.equals("2")) {
                return true;
            } else {
                System.out.println("invalid entry");
            }
        }
        return true;
    }
}


