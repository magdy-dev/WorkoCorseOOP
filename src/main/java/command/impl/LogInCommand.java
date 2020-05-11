package command.impl;

import Controler.Controller;
import Exceptions.ServiceException;
import command.Command;
import entities.Account;
import entities.User;
import service.impl.AccountService;

import java.util.Scanner;

public class LogInCommand implements Command {


    @Override
    public boolean execute() throws ServiceException {
        Account account = new Account();
        AccountService accountService = new AccountService();
        User user1 = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("user name:");
        String userName = scanner.nextLine();
        System.out.println("password:");
        String pass = scanner.nextLine();
        account.setUserName(userName);
        account.setPassword(pass);
        accountService.readByUsername(userName, pass);
        if (userName.equals(account.getUserName()) && pass.equals(account.getPassword())){
            Controller.user = user1;
            user1.setStatus(true);
            System.out.println("logged in successfully");
            } else {
            user1.setStatus(false);
            System.out.println("username or password incorrect");
        }

        return true;
    }
}
