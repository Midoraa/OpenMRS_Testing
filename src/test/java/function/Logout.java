package function;

import config.WebConnect;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Logout {
    public static void TestLogout(){
        WebDriver driver = WebConnect.connect();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");
        driver.findElement(By.cssSelector("li[value='6']")).click();
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();

//      Login to Logout
        System.out.println("Login: ");
        SessionId sessionBeforeLogout = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session Before Logout: " + sessionBeforeLogout);
        Cookie[] cookie = driver.manage().getCookies().toArray(new Cookie[0]);
        for (Cookie cookieBeforeLogout : cookie) { System.out.println("Cookie Before Logout: " + cookieBeforeLogout); }
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

//        Cookie session2 = driver.manage().getCookieNamed("JSESSIONID");

//      Start Logout
        driver.findElement(By.xpath("//li[@class='nav-item logout']/a")).click();
        System.out.println("Logout: ");
        SessionId sessionAfterLogout = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session After Logout: " + sessionAfterLogout.toString());
        Cookie[] cookieAfterLogout = driver.manage().getCookies().toArray(new Cookie[0]);
        for (Cookie c : cookieAfterLogout) { System.out.println("Cookie After Logout: " + c); }
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

//        driver.manage().addCookie(session2);

//      Back Navigate First
        driver.navigate().back();
        System.out.println("Back Navigate First: ");
        SessionId sessionAfterLogout2 = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session After Logout: " + sessionAfterLogout2.toString());
        Cookie[] cookieAfterLogout2 = driver.manage().getCookies().toArray(new Cookie[0]);
        for (Cookie c : cookieAfterLogout2) { System.out.println("Cookie After Logout: " + c); }
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

//      Back Navigate Second
        driver.navigate().back();
        System.out.println("Back Navigate Second: ");
        SessionId sessionAfterLogout3 = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session After Logout: " + sessionAfterLogout3.toString());
        Cookie[] cookieAfterLogout3 = driver.manage().getCookies().toArray(new Cookie[0]);
        for (Cookie c : cookieAfterLogout3) { System.out.println("Cookie After Logout: " + c); }
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

//        System.out.println("Just get Cookie of JSession!");
//        Cookie cookieAfterLogout4 = driver.manage().getCookieNamed("JSESSIONID");
//        System.out.println("Cookie JSession: " + cookieAfterLogout4);

        driver.quit();
    }
}
