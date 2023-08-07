package org.obs.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement register = driver.findElement(By.xpath("//a[text()='REGISTER']"));
        register.click();
        // String title=driver.getTitle();
        //System.out.println(title);
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("Anas ");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys("Nazar");
        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("9846749753");
        WebElement email = driver.findElement(By.xpath("//input[@id='userName']"));
        email.sendKeys("anas@gmail.com");
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys("vilayil veedu");
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("trivandrum");
        WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys("kerala");
        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys("695141");
        WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
        userName.sendKeys("AnasNazar880");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("Izin@2020");
        WebElement confirmPass = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPass.sendKeys("Izin@2020");
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
    }
}
