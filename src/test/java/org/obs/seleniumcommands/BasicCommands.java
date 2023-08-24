package org.obs.seleniumcommands;

import org.bouncycastle.util.Arrays;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.obs.utility.RandomData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        List<WebElement> panels = driver.findElements(By.xpath("//table/tbody//tr[contains(@class,'mouse')]//a"));
        selectPanel("Flights", panels);
    }

    public void selectPanel(String panel, List<WebElement> panels) {
        for (int i = 0; i < panels.size(); i++) {
            WebElement panel1 = panels.get(i);
            String tagValue = panel1.getText();
            if (tagValue.equals(panel)) {
                panel1.click();
                break;
            }

        }
    }

    @Test
    public void verifyDiffrenceBtFindelementAndFindElements() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        // WebElement panel = driver.findElement(By.xpath("//table/tbody//tr[contains(@class,'mouse123')]//a"));
        List<WebElement> panels = driver.findElements(By.xpath("//table/tbody//tr[contains(@class,'mouse123')]//a"));
        System.out.println(panels.size());
    }

    @Test
    public void verifySimpleAlerts() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();//switching to alert
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

    @Test
    public void verifyConfirmationAlertOkButton() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement confAlertOk = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        confAlertOk.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String confAlertText = alert.getText();
        System.out.println(confAlertText);
        alert.accept();

    }

    @Test
    public void verifyconfirAlertDeleteButton() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement confirAlertDelete = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirAlertDelete.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String deleteAlertText = alert.getText();
        System.out.println(deleteAlertText);
        alert.dismiss();

    }

    @Test
    public void verifyPromptButton() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement promptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String promptAlertText = alert.getText();
        System.out.println(promptAlertText);
        alert.sendKeys("my name is Anas");
        // alert.accept();

    }

    @Test
    public void verifySimpleAlert() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickButton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        clickButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String simpleAlertText = alert.getText();
        System.out.println(simpleAlertText);
        alert.accept();
    }

    @Test
    public void verifyConfirAlertOkButton() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement confAlertOk = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        confAlertOk.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String confAlertText = alert.getText();
        System.out.println(confAlertText);
        alert.accept();
    }

    @Test
    public void verifyConfAlertDelete() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement confAlertDelete = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        confAlertDelete.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String alertDeleteText = alert.getText();
        System.out.println(alertDeleteText);
        alert.dismiss();
    }

    @Test
    public void verifyPromptAlert() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement promptButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        promptButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String promAlertText = alert.getText();
        System.out.println(promAlertText);
        alert.sendKeys("i am anas");
        alert.accept();
    }

    @Test
    public void verifyUserEdit() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'and @name='username']"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name='password']"));
        passWord.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
        List<WebElement> panels = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        selectPanels("Admin", panels);
        List<WebElement> admins = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        String targetAdminName = driver.findElement(By.xpath("//div[@class='oxd-table-card'][2]/div[@class='oxd-table-row oxd-table-row--with-border']/div[@class='oxd-table-cell oxd-padding-cell'][2]")).getText();

        WebElement editButton = driver.findElement(By.xpath("//div[@class='oxd-table-card'][2]/div[@class='oxd-table-row oxd-table-row--with-border']/div[@class='oxd-table-cell oxd-padding-cell']/div[@class='oxd-table-cell-actions']/button/i[@class='oxd-icon bi-pencil-fill']"));
        editButton.click();
        WebElement targetAdminElement = findAdminElementByUseName(admins, targetAdminName);
        WebElement employeeName = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']"));
        employeeName.sendKeys("Abdulsamad123");
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        submitButton.click();
        if (targetAdminElement != null) {
            targetAdminElement.click();
            // Perform actions on the selected admin's profile page
        } else {
            System.out.println("Admin not found: " + targetAdminName);
        }

    }

    public void selectPanels(String panel, List<WebElement> panels) {
        for (int i = 0; i < panels.size(); i++) {
            WebElement panel1 = panels.get(i);
            String tagValue = panel1.getText();
            if (tagValue.equals(panel)) {
                panel1.click();
                break;
            }

        }
    }

    public WebElement findAdminElementByUseName(List<WebElement> admins, String adminName) {
        for (WebElement adminElement : admins) {
            if (adminElement.getText().equals(adminName)) {
                return adminElement;
            }
        }
        return null; // Admin not found
    }

    @Test//most important
    public void verifyMultipleWindowHandling() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();//for getting handle id of parent window
        WebElement clickHereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereButton.click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (!parentWindow.equals(element)) {//element is for getting child window handle id.
                driver.switchTo().window(element);//divert atention to child window
                WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
                email.sendKeys("anas.tuv@gmail.com");
                WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
                submitButton.click();
                driver.close();//for closing child window
            }
        }
        driver.switchTo().window(parentWindow);//to divert attention from child window to parent window
    }

    @Test
    public void validateCountryDropDownValues() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        //select.selectByVisibleText("INDIA");
        //select.selectByValue("INDIA");
        select.selectByIndex(43);
        List<WebElement> dropdownValues = select.getOptions();
        int size = dropdownValues.size();
        System.out.println("The size of the list is :" + size);
//        Iterator<WebElement>itr=dropdownValues.iterator();
//        while(itr.hasNext()){
//            WebElement dropDown= itr.next();
//            String countryNames=dropDown.getText();
//            System.out.println(countryNames);
//        }
        for (int i = 0; i < size; i++) {
            WebElement dropDown = dropdownValues.get(i);
            String countryName = dropDown.getText();
            System.out.println(countryName);
        }
    }

    @Test
    public void valueCountrySelector() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        List<WebElement> dropDownValues = select.getOptions();
        int size = dropDownValues.size();
        selectCountry("AUSTRIA", dropDownValues);

    }

    public void selectCountry(String country, List<WebElement> dropDownValues) {
        boolean countryFound = false;
        for (int i = 0; i < dropDownValues.size(); i++) {
            WebElement dropValue = dropDownValues.get(i);
            String countryNames = dropValue.getText();
            if (countryNames.equals(country)) {
                dropValue.click();
                countryFound = true;
                break;
            }
        }
        if (!countryFound) {
            System.out.println("The selected country not in the list");
        }

    }
}




