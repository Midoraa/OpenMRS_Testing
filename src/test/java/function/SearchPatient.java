package function;

import config.WebConnect;
import model.PatientRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPatient {
    public static void SearchPatient(){
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

        // Get the selected location valuee
        String selectedLocation = desiredLocationOption.getText();
        System.out.println("Selected Location: " + selectedLocation);


        WebElement button =  driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        button.click();
//                  ---Login xong r moi tiep tuc duoc---

//      Click vao nut Data Management
        WebElement buttonDataManagemet = driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/a[9]"));
        buttonDataManagemet.click();

//        Click vao nut Merge Patient Electronic Records
        WebElement buttonMergePatient = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/a"));
        buttonMergePatient.click();

//        Nhap data vo test
        PatientRecord pr = new PatientRecord("1001PD", "Mary Thompson");

        WebElement inputField = driver.findElement(By.id("patient-search"));

//        Search by true id
        inputField.sendKeys(pr.getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.clear();

//        Search by true Name
        inputField.sendKeys(pr.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.clear();

//        Seach by Wrong ID
        inputField.sendKeys("1231abcxyzdasdqwerqwmc");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.clear();

//        Seach by wrong Name
        inputField.sendKeys("Hello World It's Me!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.clear();

//        Search by multiple Name
        inputField.sendKeys("John");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.clear();

//        Search by blank space
        inputField.sendKeys("      ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.clear();
    }
}
