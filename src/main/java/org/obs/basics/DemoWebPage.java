package org.obs.basics;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DemoWebPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com");
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        String fName=RandomData.getFirstName();
        String lName=RandomData.getLastName();
        String emailId=fName+"."+lName+"@obsquira.com";
        String passWord1=fName+"@"+lName;
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male' and @name='Gender']"));
        gender.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName' and @name='FirstName']"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName' and @name='LastName']"));
        lastName.sendKeys(lName);
        WebElement email = driver.findElement(By.xpath("//input[@class='text-box single-line' and @id='Email']"));
        email.sendKeys(emailId);
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        passWord.sendKeys(passWord1);
        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='ConfirmPassword' and @name='ConfirmPassword']"));
        confirmPass.sendKeys(passWord1);
        WebElement register1 = driver.findElement(By.xpath("//input[@id='register-button' and @name='register-button' ]"));
        register1.click();
        driver.close();
    }
}
