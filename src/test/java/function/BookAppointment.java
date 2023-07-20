package function;

import config.WebConnect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Scanner;

public class BookAppointment {

    public static WebDriver TestBookAppointment(){
        WebDriver driver = WebConnect.connect();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");
        driver.findElement(By.cssSelector("li[value='6']")).click();
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension\"]")).click();
        return driver;
    }

    public static void TestListManageServiceTypes(){
        WebDriver driver = TestBookAppointment();
        driver.findElement(By.xpath("//*[@id=\"appointmentschedulingui-manageAppointmentTypes-app\"]")).click();

        Boolean status = true;

        while (status ){
            List<WebElement> listElementsTr = driver.findElements(By.tagName("tr"));
            for (WebElement ltr: listElementsTr) {
                List<WebElement> listElementsTd = ltr.findElements(By.tagName("td"));
                for (WebElement ltd: listElementsTd) {
                    System.out.println(ltd.getText());
                }
                System.out.println("-------------------------------------------------------");
            }

            String updateStatus = driver.findElement(By.id("appointmentTypesTable_next")).getAttribute("class");

            if(updateStatus.contains("ui-state-disabled")){
                status = false;
            }
            driver.findElement(By.xpath("//*[@id=\"appointmentTypesTable_next\"]")).click();
        }

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();
    }

    public static void TestNewServiceTypes(){
        WebDriver driver = TestBookAppointment();
        driver.findElement(By.xpath("//*[@id=\"appointmentschedulingui-manageAppointmentTypes-app\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/button")).click();

        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("1. Service New");

        WebElement duration = driver.findElement(By.name("duration"));
        duration.sendKeys("180");

        WebElement description = driver.findElement(By.name("description"));
        description.sendKeys("120 Add New Service");

        driver.findElement(By.id("save-button")).click();

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        TestListManageServiceTypes();
        driver.quit();
    }

    public static void TestCase(){
        System.out.println("1. Read List Manage Service Types");
        System.out.println("2. Create New Service Types");

        System.out.print("Enter Your Choose:");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        int a = sc.nextInt();

        switch (a){
            case 1:
                System.out.println("Read List Manage Service Types");
                TestListManageServiceTypes();
                break;
            case 2:
                System.out.println("Create New Service Types");
                TestNewServiceTypes();
                break;
            default:
                System.out.println("Exit!");
                break;
        }
    }

}
