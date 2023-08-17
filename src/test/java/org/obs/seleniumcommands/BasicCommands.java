package org.obs.seleniumcommands;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
        System.out.println("value attribute value of register button:" + valueAttributeValue);
        System.out.println("type attribute value:" + typeAttributeValue);
        System.out.println("class attribute value:" + classAttributeValue);
        String tagName = registerButton.getTagName();//for getting tag name
        System.out.println("tag name of the registerButton :" + tagName);
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

    @Test
    public void verifyFormSubmit() {
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        String fName2 = RandomData.getFirstName();
        String lName1 = RandomData.getLastName();
        String city3 = RandomData.getCity();
        String state4 = RandomData.getState();
        String zip3 = RandomData.getPinCode();
        String username1 = fName2 + lName1;
        WebElement firstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys(fName2);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys(lName1);
        WebElement city2 = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        city2.sendKeys(city3);
        WebElement state1 = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        state1.sendKeys(state4);
        WebElement zip1 = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zip1.sendKeys(zip3);
        WebElement userName = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
        userName.sendKeys(username1);
        // WebElement checkBox=driver.findElement(By.xpath(""))
        WebElement submit1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        //submit1.click();
        submit1.submit();
    }

    @Test
    public void verifyCssValue() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement getFirstSelectedButton = driver.findElement(By.xpath("//button[@id='button-first']"));
        String buttonColour = getFirstSelectedButton.getCssValue("background-color");
        System.out.println("the colour of the getFirstSelected button is :" + buttonColour);
        String buttonFondFamily = getFirstSelectedButton.getCssValue("font-family");
        System.out.println("the fond family of the button is :" + buttonFondFamily);
        String borderColor = getFirstSelectedButton.getCssValue("border-color");
        System.out.println("the border color is: " + borderColor);

    }

    @Test
    public void verifyLocation() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
        Point location = showMessageButton.getLocation();
        System.out.println("Element location:(" + location.getX() + "," + location.getY() + ")");
    }

    @Test
    public void verifyGetSize() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement button = driver.findElement(By.xpath("//button[@id='button-one']"));
        Dimension sizeOfButton = button.getSize();
        System.out.println("the size of the button:(" + sizeOfButton.getWidth() + "," + sizeOfButton.getHeight() + ")");
    }


    @Test
    public void verifyNavigationCommands() throws InterruptedException {
        // driver.get("https://demowebshop.tricentis.com/");
        driver.navigate().to("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='ico-register']"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement fName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        fName.sendKeys("anas");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("izin");
        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.sendKeys("anas@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://demowebshop.tricentis.com/cart");
    }

    @Test
    public void verifySelectGender() {
        driver.get("https://demowebshop.tricentis.com/register");
        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='Gender']"));
        selectGender("female", genders);
    }

    public void selectGender(String gender, List<WebElement> genders) {
        for (int i = 0; i < genders.size(); i++) {
            WebElement gen = genders.get(i);
            String idAttributeValue = gen.getAttribute("id");
            if (idAttributeValue.contains("gender")) {
                gen.click();
                break;

            }
        }
    }

    @Test
    public void verifyPanelSelection() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        List<WebElement> panels = driver.findElements(By.xpath("//a[@style='margin-left: 5px;color: #0000ee;text-decoration: underline;'] "));
        selectPanel("Flights", panels);
    }

    public void selectPanel(String panel, List<WebElement> panels) {
        for (int i = 0; i < panels.size(); i++) {
            WebElement panel1 = panels.get(i);
            String tagValue = panel1.getText();
            if (tagValue.contains(panel)) {
                panel1.click();
                break;
            }

        }
    }

}

