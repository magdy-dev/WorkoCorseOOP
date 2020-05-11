package command.impl;
//done
import Controler.Controller;
import Exceptions.ServiceException;
import command.Command;
import entities.Account;
import entities.Address;
import entities.User;
import service.impl.AccountService;
import service.impl.AddressService;
import service.impl.UserService;

import java.util.Scanner;

public class RegisterCommand implements Command {
    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();
    private AddressService addressService = new AddressService();

    @Override
    public boolean execute() throws ServiceException {
        Account account = new Account();
        Address address = new Address();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        //String setups = scanner.nextLine();
        System.out.println("username:");
        String userName = scanner.nextLine();
        System.out.println("password:");
        String pass = scanner.nextLine();
        System.out.println("country:");
        String addressInfoCountry = scanner.nextLine();
        System.out.println("region:");
        String addressInfoRegion = scanner.nextLine();
        System.out.println("street:");
        String addressInfoStreet = scanner.nextLine();
        System.out.println("apartment:");
        int addressInfoApartment = scanner.nextInt();
        scanner.nextLine();
        System.out.println("first name:");
        String firstName = scanner.nextLine();
        System.out.println("last name:");
        String lastName = scanner.nextLine();
        System.out.println("phone number:");
        String phoneNum = scanner.nextLine();
        account.setUserName(userName);
        account.setPassword(pass);
        address.setCountry(addressInfoCountry);
        address.setRegion(addressInfoRegion);
        address.setStreet(addressInfoStreet);
        address.setApartment(addressInfoApartment);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNum);
        user.setAddressId(1);
        user.setId(user.hashCode());
        account.setUserId(1);
        account.setId(1);
        userService.create(user);
        accountService.create(account);
        addressService.create(address);
        Controller.user = user;
        System.out.println("register completed");

        return true;
    }
}
