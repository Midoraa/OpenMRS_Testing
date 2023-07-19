package function;

import config.WebConnect;
import model.Account;
import org.openqa.selenium.By;
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
        WebDriver driver = WebConnect.connect();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");

        WebElement location = driver.findElement(By.name("sessionLocation"));
        location.sendKeys("2");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
