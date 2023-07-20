package function;

import config.WebConnect;
import model.AccountGuru;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginGuru {
    public static void loginGuru(){
        WebDriver driver = WebConnect.connectGuru();

        AccountGuru accTrue = new AccountGuru("mngr516516", "qyzEqYj");
        AccountGuru accFail = new AccountGuru("helloworldhehe", "helloworl");

//        Username password TRUE
        WebElement username = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username.sendKeys(accTrue.getUsername());

        WebElement password = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password.sendKeys(accTrue.getPassword());

        WebElement button = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();


//        Username password FAIL
        driver = WebConnect.connectGuru();
        WebElement username2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username2.sendKeys(accFail.getUsername());

        WebElement password2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password2.sendKeys(accFail.getPassword());

        WebElement button2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button2.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();

//       Wrong Username True password
        driver = WebConnect.connectGuru();
        WebElement username3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username3.sendKeys(accFail.getUsername());

        WebElement password3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password3.sendKeys(accTrue.getPassword());

        WebElement button3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button3.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();

//       True Username Wrong password
        driver = WebConnect.connectGuru();
        WebElement username4 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username4.sendKeys(accTrue.getUsername());

        WebElement password4 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password4.sendKeys(accFail.getPassword());

        WebElement button4 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button4.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();

//       Empty Username and Password
        driver = WebConnect.connectGuru();
        WebElement username5 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username5.sendKeys("");

        WebElement password5 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password5.sendKeys("");

        WebElement button5 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button5.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();

//       Empty Username and  True Password
        driver = WebConnect.connectGuru();
        WebElement username6 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username6.sendKeys("");

        WebElement password6 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password6.sendKeys(accTrue.getPassword());

        WebElement button6 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button6.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();

//       True Username and  Empty Password
        driver = WebConnect.connectGuru();
        WebElement username7 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username7.sendKeys(accTrue.getUsername());

        WebElement password7 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password7.sendKeys("");

        WebElement button7 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button7.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();


//       Wrong Username and  Empty Password
        driver = WebConnect.connectGuru();
        WebElement username8 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username8.sendKeys(accFail.getUsername());

        WebElement password8 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password8.sendKeys("");

        WebElement button8 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button8.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();


//       Empty Username and  Wrong Password
        driver = WebConnect.connectGuru();
        WebElement username9 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        username9.sendKeys("");

        WebElement password9 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        password9.sendKeys(accFail.getPassword());

        WebElement button9 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        button9.click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();


    }
}
