package function;

import config.WebConnect;
import model.SeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

    public static List<SeviceType> ServiceDetailInput(){
        List<SeviceType> list = new ArrayList<>();
        list.add(new SeviceType("New Service Full","120","New Service To Test Automation! With All Field Correct"));
        list.add(new SeviceType("","120","New Service To Test Automation! With Duration && Description Field Correct, Name is Empty"));
        list.add(new SeviceType("New Service Empty Duration","","New Service To Test Automation! With Name && Description Field Correct, Duration is Empty"));
        list.add(new SeviceType("New Service Empty Description","120",""));
        list.add(new SeviceType("","","New Service To Test Automation! With Name && Duration Field Empty, Description is Correct"));
        list.add(new SeviceType("","120",""));
        list.add(new SeviceType("New Service Empty Duration, Description","",""));
        list.add(new SeviceType("New Service Duration is Character","Time","New Service To Test Automation! With Name && Description Correct, Duration is character"));
        list.add(new SeviceType("","",""));
        list.add(new SeviceType("","Time",""));
        list.add(new SeviceType("New Service Empty Description","Time",""));
        list.add(new SeviceType("","Time","New Service To Test Automation! With Duration Field Incorrect && Description Field Correct, Name is Empty"));
        list.add(new SeviceType("New Service Duration Negative","-2",""));
        list.add(new SeviceType("","-6","New Service To Test Automation! With Duration Field Incorrect && Duration is Negative && Description Field Correct, Name is Empty"));
        list.add(new SeviceType("","-15",""));
        return list;
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
        name.sendKeys("2. Service New");

        WebElement duration = driver.findElement(By.name("duration"));
        duration.sendKeys("180");

        WebElement description = driver.findElement(By.name("description"));
        description.sendKeys("120 Add New Service");

        driver.findElement(By.id("save-button")).click();

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        TestListManageServiceTypes();
        driver.quit();
    }

    public static void TestNewServiceTypesList(List<SeviceType> list){
        for (SeviceType st: list) {
            WebDriver driver = TestBookAppointment();
            driver.findElement(By.xpath("//*[@id=\"appointmentschedulingui-manageAppointmentTypes-app\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/button")).click();

            WebElement name = driver.findElement(By.name("name"));
            name.sendKeys(st.getName());
            System.out.println(st.getName());

            WebElement duration = driver.findElement(By.name("duration"));
            duration.sendKeys(st.getDuration());
            System.out.println(st.getDuration());
            WebElement description = driver.findElement(By.name("description"));
            description.sendKeys(st.getDescription());
            System.out.println(st.getDescription());

            driver.findElement(By.id("save-button")).click();

            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            driver.quit();
        }
        TestListManageServiceTypes();
    }

    public static void TestCase(){
        System.out.println("1. Read List Manage Service Types");
        System.out.println("2. Create New Service Types");
        System.out.println("3. Create New Service Types With List Detail");

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
            case 3:
                System.out.println("Create New Service Types With List Detail");
                TestNewServiceTypesList(ServiceDetailInput());
                break;
            default:
                System.out.println("Exit!");
                break;
        }
    }

    public static void main(String[] args) {
        TestCase();
    }

}
