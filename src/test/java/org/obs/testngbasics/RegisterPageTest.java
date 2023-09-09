package org.obs.testngbasics;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends Base{
    @Test
    public void verifyUserRegistration(){
        WebElement register = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='ico-register']"));
        register.click();
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
        gender.click();
        String fName = RandomData.getFirstName();
        String lName = RandomData.getLastName();
        String eMail1 = fName + "." + lName + "@obsquira.com";
        String passWord1 = fName + "." + lName;
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys(lName);
        WebElement emailId = driver.findElement(By.xpath("//input[@id='Email']"));
        emailId.sendKeys(eMail1);
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password']"));
        passWord.sendKeys(passWord1);
        WebElement confPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confPassword.sendKeys(passWord1);
        WebElement RegisterButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        RegisterButton.click();
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualEmailId1 = userAccountEmail.getText();
        Assert.assertEquals(actualEmailId1, eMail1, "Registration failed");
    }
    @Test
    public void verifyRegisterPageTitle(){
        WebElement register = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='ico-register']"));
        register.click();
        String actTitle = driver.getTitle();
        String expTitle = "Demo Web Shop. Register";
        Assert.assertEquals(actTitle, expTitle, " register  page title mismatch ");
    }

}
