package function;

import config.WebConnect;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    public static List<Account> listInput(){
        List<Account> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            String location = String.valueOf(i);
            list.add(new Account("Admin", "Admin123", location));
            list.add(new Account("Admin", "Admin12", location));
            list.add(new Account("User", "Admin123", location));
            list.add(new Account("", "", location));
            list.add(new Account("Admin", "", location));
            list.add(new Account("", "Admin123", location));
        }
        return list;
    }

    public static List<Account> listTest(){
        List<Account> list = new ArrayList<>();
//        Kiểm tra điền trường username và password nhưng không chọn giá trị ở Location
        list.add(new Account("Admin", "Admin123", "1"));
//        Kiểm tra đăng nhập thành công với các giá trị Location
        for (int i = 2; i < 7; i++){
            String location = String.valueOf(i);
            list.add(new Account("Admin", "Admin123", location));
        }
//        Kiểm tra trường username hoặc password không đúng
        list.add(new Account("Admin", "Admin12", "6"));
        list.add(new Account("User", "Admin123", "6"));
//        Kiểm tra trường username hoặc password hoặc cả hai để trống
        list.add(new Account("", "", "6"));
        list.add(new Account("Admin", "", "6"));
        list.add(new Account("", "Admin123", "6"));
        return list;
    }

    public static void TestLogin(List<Account> listTest) {

        int testcaseID = 1;
        for (Account l: listTest ) {
            WebDriver driver = WebConnect.connect();
//          Send Value Username
            WebElement username = driver.findElement(By.name("username"));
            username.sendKeys(l.getUsername());
//          Send value Password
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys(l.getPassword());

            String location = "";
            if(!l.getLocation().equals("1")){
//          Send value Location
                String choose = "li[value='" + l.getLocation() + "']";
                WebElement desiredLocationOption = driver.findElement(By.cssSelector(choose));
                location =  desiredLocationOption.getText();
                desiredLocationOption.click();
            }

            System.out.println("Test Case: " + testcaseID);
//          Print Username and Password and Location Selected
            System.out.println("Login Username: " + l.getUsername() + ", Password: "+ l.getPassword() + ", Location: " + location);

//          Click on Button Login
            driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();

//          Sleep Waiting After Click Login to Waiting Process
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

            if(location.equals("")){
                String noSelected = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/p[3]/label")).getText();
                System.out.println(noSelected);
            }else {
//          Test Content Login Success or Fail
                if (l.getUsername().equals("Admin") && l.getPassword().equals("Admin123")) {
                    String success = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/h4")).getText();
                    System.out.println("Success! " + success);
                } else {
                    String alert = driver.findElement(By.xpath("//*[@id=\"error-message\"]")).getText();
                    System.out.println("Fail! Message: " + alert);
                }

                Cookie[] cookie = driver.manage().getCookies().toArray(new Cookie[0]);
                for (Cookie c : cookie
                ) {
                    System.out.println("Cookie: " + c);

                }
            }
            testcaseID++;
            driver.quit();
        }
    }

    public static void TestCase(){
        List<Account> list;
        System.out.println("1. Test Detail! 36 Test Case");
        System.out.println("2. Test Consolidation/Merging! 11 Test Case");

        System.out.print("Enter Your Choose:");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) { sc.next(); }
        int a = sc.nextInt();

        switch (a){
            case 1:
                System.out.println("List Detail");
                TestLogin(listInput());
                break;
            case 2:
                System.out.println("List Consolidation/Merging");
                TestLogin(listTest());
                break;
            default:
                System.out.println("Exit!");
                break;
        }
    }
}


//            int step = 1;
//
//            if(!l.getUsername().equals("")){
//                System.out.println(step++ + ") Enter a value in Username Field");
//                System.out.println(step++ + ") Press TAB and move to next Field");
//            }else{
//                System.out.println(step++ + ") Leave the Username Field blank");
//            }
//
//            if(!l.getPassword().equals("")){
//                System.out.println(step++ + ") Enter a value in Password Field");
//                System.out.println(step++ + ") Press TAB and move to next Field");
//            }else{
//                System.out.println(step++ + ") Leave the Password Field blank");
//            }
//
//            if(!l.getLocation().equals("1")){
//                System.out.println(step++ + ") Click on a value in Location for this session Field");
//            }else{
//                System.out.println(step++ + ") Leave the Location for this session Field blank");
//            }
//
//            System.out.println(step++ + ") Click on button \"Log In\"");
