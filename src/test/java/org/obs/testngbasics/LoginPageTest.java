package org.obs.testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base{
    @Test
    public void verifyUserLogin(){
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        String  expectedEmailId = "anas1@gmail.com";
        email.sendKeys(expectedEmailId);
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        String pass1 = "Izin@2020";
        password.sendKeys(pass1);
        WebElement loginClick = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginClick.click();
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        userAccountEmail.getText();
        String actualEmailId = userAccountEmail.getText();
        Assert.assertEquals(actualEmailId, expectedEmailId, "login failed");
    }
    @Test
    public void verifyLoginPageTitle(){
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        String actualLoginTitle = driver.getTitle();
        String expectedLoginTitle="Demo Web Shop. Login";
        Assert.assertEquals(actualLoginTitle,expectedLoginTitle,"login page title mismatch");
    }
    @Test(dataProvider = "userCredentialsFromExcel" ,dataProviderClass = LoginDataProvider.class)
    public void verifyInvalidUserLogin(String uName,String pWord){
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        String  emailId = uName;
        email.sendKeys(emailId);
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        String pass1 =pWord;
        password.sendKeys(pass1);
        WebElement loginClick = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginClick.click();
        WebElement errorMessage= driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"));
       String actualErrorMessage= errorMessage.getText();
       String expectedErrorMessage="Login was unsuccessful. Please correct the errors and try again.";
       Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"error message not displayed");
    }
}
