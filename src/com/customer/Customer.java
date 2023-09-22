package com.customer;
import java.util.Scanner;

public class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Address address;
    private String creditCardNumber;
    private double accountBalance;

    public Customer() {
        this.id = 0;
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
        this.address = new Address();
        this.creditCardNumber = "";
        this.accountBalance = 0.0;
    }

    public Customer(int id, String lastName, String firstName, String middleName, String city, String street, String houseNum, String creditCardNumber, double accountBalance) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = new Address(city, street, houseNum);
        this.creditCardNumber = creditCardNumber;
        this.accountBalance = accountBalance;
    }

    public void setValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть прізвище: ");
        this.lastName = scanner.nextLine();
        System.out.print("Введіть ім'я: ");
        this.firstName = scanner.nextLine();
        System.out.print("Введіть по батькові: ");
        this.middleName = scanner.nextLine();

        this.address = new Address();
        System.out.print("Введіть місто: ");
        this.address.setCity(scanner.nextLine());
        System.out.print("Введіть вулицю: ");
        this.address.setStreet(scanner.nextLine());
        System.out.print("Введіть номер будинку: ");
        this.address.setHouseNum(scanner.nextLine());

        System.out.print("Введіть номер кредитної картки: ");
        this.creditCardNumber = scanner.nextLine();
        System.out.print("Введіть баланс рахунку: ");
        this.accountBalance = scanner.nextDouble();
    }

    public String getValue() {
        return "ID: " + id + "\nПрізвище: " + lastName + "\nІм'я: " + firstName + "\nПо батькові: " + middleName
                + "\nАдреса: " + address + "\nНомер кредитної картки: " + creditCardNumber + "\nБаланс рахунку: " + accountBalance;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public String toString() {
        return getValue();
    }

    public boolean hasDebt() {
        return accountBalance < 0;
    }

    public String getFirstName() {
        return firstName;
    }
}

class Address {
    private String city;
    private String street;
    private String houseNum;

    public Address() {

    }

    public Address(String city, String street, String houseNum) {
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    @Override
    public String toString() {
        return city + ", " + street + ", буд. " + houseNum;
    }
}
