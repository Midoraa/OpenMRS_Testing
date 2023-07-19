package function;

import config.WebConnect;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public static void TestLogin() {
        int testcase = 1;
        for (Account l: listInput() ) {
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
//          Print Test Case
            System.out.println("Test Case: " + testcase);
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

            testcase++;

//          Close Tab when test finish
            driver.quit();
        }
    }
}
