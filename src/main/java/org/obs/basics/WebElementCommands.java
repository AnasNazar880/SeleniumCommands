package org.obs.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementCommands {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();//for deleting all cockies
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement emailField = driver.findElement(By.id("Email"));//to find web element of the email field using id find textarea
        emailField.sendKeys("muhammadanas.n@gmail.com");
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("Hyrin@2023");
        WebElement loginButton=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();

    }
}
