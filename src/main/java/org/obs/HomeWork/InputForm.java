package org.obs.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputForm {
    public static void main(String[] args) {
        WebDriver driver;
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        WebElement enterMessageField=driver.findElement(By.id("single-input-field"));
        enterMessageField.sendKeys("Welcome to obsquira");
        WebElement showMessageButton=driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
        showMessageButton.click();
        WebElement enterValueAField=driver.findElement(By.cssSelector("#value-a"));
        enterValueAField.sendKeys("6");
        WebElement enterValueBField= driver.findElement(By.cssSelector("#value-b"));
        enterValueBField.sendKeys("9");
        WebElement getTotalButton=driver.findElement(By.cssSelector("#button-two"));
        getTotalButton.click();



        
    }
}
