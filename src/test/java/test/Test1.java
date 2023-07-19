package test;

import function.Login;
import function.Logout;

public class Test1 {
    public static void main(String[] args) {
        Login.TestLogin();
        try { Thread.sleep(15000); } catch (InterruptedException e) { e.printStackTrace(); }
        Logout.TestLogout();
    }
}
