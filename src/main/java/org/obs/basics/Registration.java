package org.obs.basics;
import com.github.javafaker.PhoneNumber;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Registration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement register = driver.findElement(By.xpath("//a[text()='REGISTER']"));
        register.click();
        String fName=RandomData.getFirstName();
        String lName=RandomData.getLastName();
        String pNumber= RandomData.getMobileNumber();
        String eMailId=fName+"."+lName+"@obsqiura.com";
        String state1=RandomData.getState();
        String city1=RandomData.getCity();
        String pinCode1=RandomData.getPinCode();
        String StreetName1=RandomData.getStreetName();
        String passWord1=fName+"@"+lName;

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys(lName);
        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(pNumber);
        WebElement email = driver.findElement(By.xpath("//input[@id='userName']"));
        email.sendKeys(eMailId);
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys(StreetName1);
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys(city1);
        WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys(state1);
        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys(pinCode1);
        WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
        userName.sendKeys(fName+"."+lName);
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(passWord1);
        WebElement confirmPass = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPass.sendKeys(passWord1);
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        driver.close();
    }
}
