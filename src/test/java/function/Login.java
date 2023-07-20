package function;

import config.WebConnect;
import model.Account;
import model.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public static List<Register> listInputRegister(){
        List<Register> listAccountRegister = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            listAccountRegister.add(new Register("John", "Doe", "Smith", "Male", "10", "May", "1990", "123 Main St", "hgh", "New York", "NY", "USA", "10001", "1234567890", "Friend", "Jane Doe"));
            listAccountRegister.add(new Register("Alice", "Lee", "Johnson", "Female", "15", "August", "1995", "456 Oak St", "dfsf", "Los Angeles", "CA", "USA", "90001", "9876543210", "Family", "Bob Johnson"));
        }
        return listAccountRegister;
    }
    public static void LoginTrue(){
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

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.findElement(By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]")).click();


        // Khởi tạo đối tượng Register với các giá trị cần điền vào form Register
        Register register = new Register("John", "", "Doe", "Male", "10", "May", "1990", "123 Main St", "ttds", "New York", "NY", "USA", "10001", "57892347384", "Doctor", "Jane Doe");

        // Điền thông tin vào các trường trong form
        WebElement firstName = driver.findElement(By.name("givenName"));
        firstName.sendKeys(register.getFirstName());

        WebElement midleName = driver.findElement(By.name("middleName"));
        midleName.sendKeys(register.getMidleName());

        WebElement lastName = driver.findElement(By.name("familyName"));
        lastName.sendKeys(register.getLastName());

        driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();

        WebElement gender = driver.findElement(By.cssSelector("option[value='M']"));
        gender.click();

        driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();


        WebElement days = driver.findElement(By.name("birthdateDay"));
        days.sendKeys(register.getDays());

        WebElement month = driver.findElement(By.cssSelector("option[value='4']"));
        month.click();

        WebElement years = driver.findElement(By.name("birthdateYear"));
        years.sendKeys(register.getYears());

        driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();

        WebElement address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address.sendKeys(register.getAddress());

        WebElement address1 = driver.findElement(By.xpath("//*[@id=\"address2\"]"));
        address1.sendKeys(register.getAddress1());

        WebElement cityOrVillage = driver.findElement(By.xpath("//*[@id=\"cityVillage\"]"));
        cityOrVillage.sendKeys(register.getCityOrVillage());

        WebElement stateOrProvince = driver.findElement(By.xpath("//*[@id=\"stateProvince\"]"));
        stateOrProvince.sendKeys(register.getStateOrProvince());

        WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        country.sendKeys(register.getCountry());

        WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"postalCode\"]"));
        postalCode.sendKeys(register.getPostalCode());

        driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();

        WebElement numberPhone = driver.findElement(By.name("phoneNumber"));
        numberPhone.sendKeys(register.getNumberPhone());

        driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();

        WebElement relationship = driver.findElement(By.cssSelector("option[data-val='Doctor']"));
        relationship.click();

        WebElement personName = driver.findElement(By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]"));
        personName.sendKeys(register.getPersonName());

        driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

    }
    public static void TestLogin() {
        WebDriver driver = WebConnect.connect();
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");

        WebElement location = driver.findElement(By.name("sessionLocation"));
        location.sendKeys("2");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[6]/div[2]/form/div[3]/button")).click();

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
