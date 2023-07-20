package function;

import config.WebConnect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewPatient {

    public static void ViewPatient() {
        WebDriver driver = WebConnect.connect();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");

        WebElement locationDropdown = driver.findElement(By.id("sessionLocation"));

        // Click on the dropdown to open the options
        locationDropdown.click();

        // Find the desired location option by its value attribute
        WebElement desiredLocationOption = driver.findElement(By.cssSelector("li[value='6']")); // Replace '4' with the desired value

        // Click on the desired location option
        desiredLocationOption.click();

        // Get the selected location value
        String selectedLocation = desiredLocationOption.getText();
        System.out.println("Selected Location: " + selectedLocation);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        button.click();

//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        WebElement buttonFind = driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/a[1]"));
        buttonFind.click();
        WebElement buttonView = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr[1]"));
        buttonView.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
