package function;
import config.WebConnect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import model.CaptureVitals;

public class FindCaptureVitals {

    public static void FindCaptureVitals() {

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

        WebElement button =  driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        button.click();

//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();



        WebElement buttonFind = driver.findElement(By.xpath("//*[@id=\"referenceapplication-vitals-referenceapplication-vitals-extension\"]"));
        buttonFind.click();

        CaptureVitals p1 = new CaptureVitals("100199", "Jessica Smith");
        CaptureVitals p2 = new CaptureVitals("10010W", "John Taylor");
        WebElement findField = driver.findElement(By.id("patient-search"));

//        search by id
        findField.sendKeys(p1.getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

//        search by name
        findField.sendKeys(p1.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

//        search by Wrong data
        findField.sendKeys("123zo23zo23uong");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

        //        search by Multiple name
        findField.sendKeys(p2.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

        //        search by Blank Space
        findField.sendKeys("    ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findField.clear();

//        driver.quit();
    }
}