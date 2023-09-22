package com.main;

import com.customer.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = new Customer[4];
        customers[0] = new Customer(1, "Кіцанюк", "Павло", "Юрійович", "Коломия", "Дорошенка", "12", "4149-4999-9836-4069", 1000.0);
        customers[1] = new Customer(2, "Дмитренко", "Владислав", "Ярославович", "Івано-Франківськ", "Шевченка", "40", "4151-4991-4586-9572", -500.0);
        customers[2] = new Customer(3, "Гоянюк", "Іван", "Васильович", "Львів", "Довбуша", "22", "2149-3245-6555-4582", 300.0);
        customers[3] = new Customer();
        customers[3].setValue();

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1 - Переглянути всіх покупців");
            System.out.println("2 - Список покупців з заданим іменем");
            System.out.println("3 - Список покупців з номером кредитної картки в заданому інтервалі");
            System.out.println("4 - Список покупців з заборгованістю");
            System.out.println("5 - Вихід");
            System.out.print("Виберіть дію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nСписок всіх покупців:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    waitForEnter();
                    break;

                case 2:
                    System.out.print("Виберіть ім'я: ");
                    String name = scanner.nextLine();
                    System.out.println("\nСписок покупців з іменем " + name + ":");
                    findCustomersByName(customers, name);
                    waitForEnter();
                    break;

                case 3:
                    System.out.println("\nВведіть початок інтервалу:");
                    String startInterval = scanner.next();
                    System.out.println("Введіть кінець інтервалу:");
                    String endInterval = scanner.next();
                    System.out.println("Список покупців з номером кредитної картки в інтервалі " + startInterval + " - " + endInterval + ":");
                    findCustomersByCreditCardInterval(customers, startInterval, endInterval);
                    waitForEnter();
                    break;

                case 4:
                    System.out.println("\nСписок покупців з заборгованістю:");
                    findCustomersWithDebt(customers);
                    waitForEnter();
                    break;

                case 5:
                    exit = true;
                    scanner.close();
                    break;
            }

            if (!exit) {
                System.out.println("\n\n\n\n\n");
            }
        }
    }

    private static void waitForEnter() {
        new Scanner(System.in).nextLine();
    }

    public static void findCustomersByName(Customer[] customers, String name) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equalsIgnoreCase(name)) {
                System.out.println(customer);
            }
        }
    }

    public static void findCustomersByCreditCardInterval(Customer[] customers, String startInterval, String endInterval) {
        for (Customer customer : customers) {
            String cardNumber = customer.getCreditCardNumber();
            String cardNumberFirstPart = cardNumber.substring(0, 4);
            String cardNumberLastPart = cardNumber.substring(15);

            if (cardNumberFirstPart.compareTo(startInterval) >= 0 && cardNumberLastPart.compareTo(endInterval) <= 0) {
                System.out.println(customer);
            }
        }
    }



    public static void findCustomersWithDebt(Customer[] customers) {
        for (Customer customer : customers) {
            if (customer.hasDebt()) {
                System.out.println(customer);
            }
        }
    }
}
