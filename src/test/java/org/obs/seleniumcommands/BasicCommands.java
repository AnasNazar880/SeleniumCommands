package org.obs.seleniumcommands;

import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicCommands extends Base {
    @Test
    public void verifyPageTitle() {
        driver.get("https://demowebshop.tricentis.com/");
        String actTitle = driver.getTitle();
        String expTitle = "Demo Web Shop";
        Assert.assertEquals(actTitle, expTitle, "Invalid page title found");
    }

    @Test
    public void verifyLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        String emailId = "anas1@gmail.com";
        email.sendKeys(emailId);
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        String pass1 = "Izin@2020";
        password.sendKeys(pass1);
        WebElement loginClick = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginClick.click();
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        userAccountEmail.getText();
        String actualEmailId = userAccountEmail.getText();
        Assert.assertEquals(actualEmailId, emailId, "login failed");
    }

    @Test
    public void verifyRegistration() {
        driver.get("https://demowebshop.tricentis.com/");
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
    public void verifyDifferentWebElementCommands() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        String valueAttributeValue = registerButton.getAttribute("value");
        String classAttributeValue = registerButton.getAttribute("class");
        String typeAttributeValue = registerButton.getAttribute("type");
        System.out.println(valueAttributeValue);
        System.out.println(typeAttributeValue);
        System.out.println(classAttributeValue);
        String tagName = registerButton.getTagName();
        System.out.println(tagName);
    }

    @Test
    public void verifyRegisterButtonDisplayedOrNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean status = registerButton.isDisplayed();
        System.out.println(status);
        Assert.assertTrue(status, "register button not displayed");
    }

    @Test
    public void verifyRegisterButtonEnabledOrNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean enableStatus = registerButton.isEnabled();
        System.out.println(enableStatus);
        Assert.assertTrue(enableStatus, "registerButton not enabled");
    }

    @Test
    public void verifyGenderSelectedOrNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement maleCheckBox = driver.findElement(By.id("gender-male"));
        boolean enableMaleCheckBoxBeforeClicking = maleCheckBox.isSelected();
        Assert.assertFalse(enableMaleCheckBoxBeforeClicking, "checkbox selected");
        System.out.println("before clicking male checkbox:" + enableMaleCheckBoxBeforeClicking);
        maleCheckBox.click();
        boolean afterMaleCheck = maleCheckBox.isSelected();
        System.out.println("after clicking male checkbox:" + afterMaleCheck);
        Assert.assertTrue(afterMaleCheck, "checkbox not selected");
    }

}
