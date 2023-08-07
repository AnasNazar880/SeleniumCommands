package org.obs.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male' and @name='Gender']"));
        gender.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName' and @name='FirstName']"));
        firstName.sendKeys("Anas");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName' and @name='LastName']"));
        lastName.sendKeys("Nazar");
        WebElement email = driver.findElement(By.xpath("//input[@class='text-box single-line' and @id='Email']"));
        email.sendKeys("anas1@gmail.com");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password' and @name='Password']"));
        passWord.sendKeys("Izin@2020");
        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='ConfirmPassword' and @name='ConfirmPassword']"));
        confirmPass.sendKeys("Izin@2020");
        WebElement register1 = driver.findElement(By.xpath("//input[@id='register-button' and @name='register-button' ]"));
        register1.click();
    }
}
