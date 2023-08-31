package com.example.oop3;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class BAI2_JDBC {
    public static void main(String[] args) throws SQLException {
        JDBC jdbcConnect = new JDBC();
        Boolean run = true;
        while (run) {
            choice();
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    People people = createPeople();
                    jdbcConnect.addUserToDatabase(people);
                    break;
                case 2:
                    Scanner in = new Scanner(System.in);
                    System.out.println("ID user: ");
                    String id = in.nextLine();
                    jdbcConnect.updateUserFromDatabase(id);
                    break;
                case 3:
                    jdbcConnect.showAllUserFromDatabase();
                    break;
                case 4:
                    Scanner input = new Scanner(System.in);
                    System.out.println("ID user: ");
                    String ID = input.nextLine();
                    jdbcConnect.showUserFromDatabase(ID);
                    break;
                case 5:
                    Scanner numID  = new Scanner(System.in);
                    System.out.println("ID user: ");
                    String iD = numID.nextLine();
                    jdbcConnect.deleteUserFromDatabase(iD);
                    break;
                case 6:
                    run = false;
                    break;
            }
        }
    }
    public static People createPeople () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("FirstName: ");
        String firstName = scanner.nextLine();
        System.out.println("LastName: ");
        String lastName = scanner.nextLine();
        System.out.println("Birthday: ");
        String birthday = scanner.nextLine();
        System.out.println("Gmail: ");
        String gmail = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();

        People people = new People(id, firstName, lastName, birthday, gmail, address);

        return people;
    }

    public static void choice() {
        System.out.println("1: Them du lieu");
        System.out.println("2: Sua du lieu nguoi dung");
        System.out.println("3: Xem du lieu toan bo Database");
        System.out.println("4: Xem du lieu 1 nguoi");
        System.out.println("5: Xoa du lieu nguoi dung");
        System.out.println("6: Dong chuong trinh");

        System.out.print("Please choice: ");
    }
}
