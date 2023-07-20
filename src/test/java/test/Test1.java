package test;

import function.BookAppointment;
import function.Login;
import function.Logout;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("1. Test Login");
        System.out.println("2. Test Logout");
        System.out.println("3. Test BookAppointment");
        System.out.println("4. Exit!");

        System.out.print("Enter Your Choose:");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        int testcase = sc.nextInt();

        switch (testcase){
            case 1:
                Login.TestCase();
                break;
            case 2:
                Logout.TestLogout();
                break;
            case 3:
                BookAppointment.TestCase();
                break;
            default:
                System.out.println("Exit!");
                break;
        }
    }
}
