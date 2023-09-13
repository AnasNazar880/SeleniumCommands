package org.obs.testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidOrangeLoginCredentials extends Base {
    @Test(dataProvider = "OrangeLoginCredentials", dataProviderClass = LoginDataProvider.class)
    public void verifyInvalidOrangeLoginCredentials(String uName, String passWrd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(uName);
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(passWrd);
        WebElement login = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        login.click();
        //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
        WebElement actualMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String actualMessageDisplayed = actualMessage.getText();
        String expectedMessageDisplayed = "Invalid credentials";
        Assert.assertEquals(actualMessageDisplayed, expectedMessageDisplayed, "error message not displayed");
    }
}
