package org.obs.seleniumcommands;

import org.obs.utility.RandomData;
import org.obs.utility.TableUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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
        String countryToSelect = "AUSTRIA";
        selectCountry(countryToSelect, dropDownValues, select);
        WebElement selectedValue = select.getFirstSelectedOption();
        String actualSelectedValue = selectedValue.getText();
        Assert.assertEquals(actualSelectedValue, countryToSelect, "country not selected");
    }

    public void selectCountry(String country, List<WebElement> dropDownValues, Select select) {
        boolean countryFound = false;
        for (int i = 0; i < dropDownValues.size(); i++) {
            WebElement dropValue = dropDownValues.get(i);
            String countryNames = dropValue.getText();
            if (countryNames.equals(country)) {
                select.selectByValue(country);
                countryFound = true;
                break;
            }
        }
        if (!countryFound) {
            throw new RuntimeException("The selected country is  not in the dropdown");
        }

    }

    @Test
    public void validateDeSelect() {
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='second']"));
        Select select = new Select(countryDropDown);
        boolean isMultiple = select.isMultiple();
        Assert.assertTrue(isMultiple, "given dropdown is not a multiselect");
        select.selectByVisibleText("Pizza");
        select.selectByVisibleText("Donut");
        //select.deselectAll();
        //select.deselectByVisibleText("Pizza");
        List<WebElement> options = select.getAllSelectedOptions();
        for (int i = 0; i < options.size(); i++) {
            WebElement option = options.get(i);
            String dropdown = option.getText();
            System.out.println(dropdown);
        }
    }

    @Test
    public void selectDropDown() {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
        WebElement tutorialsButton = driver.findElement(By.xpath("//button[@id='menu1']"));
        tutorialsButton.click();
        List<WebElement> options = driver.findElements(By.xpath("//a[@role='menuitem']"));
        selectValue("HTML", options);
    }

    public void selectValue(String selectedOption, List<WebElement> options) {
        for (int i = 0; i < options.size(); i++) {
            WebElement option = options.get(i);
            String dropDown = option.getText();
            if (!dropDown.equals(selectedOption)) {
                option.click();
                break;
            }

        }
    }

    @Test
    public void verifyFileUploader() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("C:\\selenium\\selenium.jpg.jpg");
        WebElement uploadButton = driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();
        String expectedMessage = "File Uploaded!";
        WebElement actualMessag = driver.findElement(By.xpath("//div[@id='content']//div//h3"));
        String actualMessage = actualMessag.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "file upload  failed");

    }

    @Test
    public void verifyRightClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).build().perform();//right click
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']//li//span"));
        String[] expectedTexts = {"Edit", "Cut", "Copy", "Paste", "Delete", "Quit"};
        for (int i = 0; i < dropDownOptions.size(); i++) {
            WebElement dropDown = dropDownOptions.get(i);
            String actualTexts = dropDown.getText();
            Assert.assertEquals(actualTexts, expectedTexts[i], "texts are not similar");
        }
    }

    @Test
    public void verifyDoubleClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).build().perform();
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText = "You double clicked me.. Thank You..";
        alert.accept();
        Assert.assertEquals(actualAlertText, expectedAlertText, "alert message not shown as expected");
    }

    @Test
    public void verifyMoveToClickAndHold() {
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        WebElement tileA = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='A']"));
        WebElement tileC = driver.findElement(By.xpath("//ul[@id='sortable']//li[text()='C']"));
        Actions action = new Actions(driver);
        action.moveToElement(tileA);
        action.moveToElement(tileC);
        // action.build().
    }

    @Test
    public void verifyDragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMe, dropHere).build().perform();
    }

    @Test
    public void verifyDragAndDropByOffset() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragMe = driver.findElement(By.id("dragBox"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(dragMe, 150, 100).build().perform();

    }

    @Test
    public void verifyMoveToElement() {
        driver.get("https://demoqa.com/menu/");
        WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions action = new Actions(driver);
        action.moveToElement(mainItem2).build().perform();
        WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.moveToElement(subSubList).build().perform();
        WebElement subSubItem1 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        action.moveToElement(subSubItem1).build().perform();
    }

    @Test
    public void verifyProgressBar() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar1 = driver.findElement(By.xpath("//div[@class='range']//input[@name='range']"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar1).clickAndHold().moveToElement(progressBar1, 83, 0).release().build().perform();
    }

    @Test
    public void verifyTestFrames() {
        driver.get("https://demoqa.com/frames");
        // driver.switchTo().frame("frame1");//method overloading
        //driver.switchTo().frame(1);
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        WebElement text = driver.findElement(By.id("sampleHeading"));
        String sampleText = text.getText();
        System.out.println(sampleText);
        //driver.switchTo().parentFrame();//switch back to parent frame
        driver.switchTo().defaultContent();//switch back to parent frame
    }

    @Test
    public void verifyDefaultValue20() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar2 = driver.findElement(By.xpath("//div[@class='range range-primary']//input"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar2).clickAndHold().moveToElement(progressBar2, 85, 0).release().build().perform();
    }

    @Test
    public void verifyDefaultValue30() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar3 = driver.findElement(By.xpath("//div[@class='range range-success']//input"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar3).clickAndHold().moveToElement(progressBar3, 78, 0).release().build().perform();

    }

    @Test
    public void verifyDefaultValue40() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar4 = driver.findElement(By.xpath("//div[@class='range range-info']//input"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar4).clickAndHold().moveToElement(progressBar4, 90, 0).release().build().perform();
    }

    @Test
    public void verifyDefaultValue50() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar5 = driver.findElement(By.xpath("//div[@class='range range-warning']//input"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar5).clickAndHold().moveToElement(progressBar5, 76, 0).release().build().perform();
    }

    @Test
    public void verifyDefaultValue60() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar6 = driver.findElement(By.xpath("//div[@class='range range-danger']//input"));
        Actions action = new Actions(driver);
        action.moveToElement(progressBar6).clickAndHold().moveToElement(progressBar6, 89, 0).release().build().perform();
    }

    @Test
    public void verifyDraggableItemList() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/drag-drop.php");
        Actions action = new Actions(driver);
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='mydropzone']"));
        WebElement draggable1 = driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[text()='Draggable n°2']"));
        WebElement draggable3 = driver.findElement(By.xpath("//span[text()='Draggable n°3']"));
        WebElement draggable4 = driver.findElement(By.xpath("//span[text()='Draggable n°4']"));
        action.dragAndDrop(draggable1, dropHere).build().perform();
        action.dragAndDrop(draggable2, dropHere).build().perform();
        action.dragAndDrop(draggable3, dropHere).build().perform();
        action.dragAndDrop(draggable4, dropHere).build().perform();
    }

    @Test
    public void verifyJavaScriptExecutor() {
        driver.get("https://demowebshop.tricentis.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('Email').value='muhammadanas.n@gmail.com';");
        js.executeScript("document.getElementById('Password').value='Hyrin@2023';");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        js.executeScript("arguments[0].click();", loginButton);
    }

    @Test
    public void verifySubscription() {
        driver.get("https://demowebshop.tricentis.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('newsletter-email').value='anas@gmail.com';");
        js.executeScript("document.getElementById('newsletter-subscribe-button').click();");
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);
    }

    @Test
    public void verifyVerticalScroll() {
        driver.get("https://demowebshop.tricentis.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
    }

    @Test
    public void verifyHorizontalScroll() {//scroll horizontally by a certain defined distance
        driver.get("https://demo.guru99.com/test/guru99home/scrolling.html");
        WebElement vbScript = driver.findElement(By.xpath("//a[text()='VBScript']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", vbScript);
    }

    @Test
    public void verifyScrollIntoTotalHeight() {
        driver.get("https://demo.guru99.com/test/guru99home/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    @Test
    public void verifyVerticalScrollIntoView() {
        driver.get("https://demo.guru99.com/test/guru99home/");
        WebElement linuxButton = driver.findElement(By.xpath("//a[text()='Linux']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", linuxButton);
    }

    @Test
    public void verifyCompanyDetails() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        for (int i = 2; i < rows.size(); i++) {
            WebElement company = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[1]"));
            String companyValue = company.getText();
            if (companyValue.equals("Island Trading")) {
                WebElement contact = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[2]"));
                System.out.println(contact.getText());
                WebElement country = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[3]"));
                System.out.println(country.getText());
                break;
            }
        }
    }

    @Test
    public void verifyTableValues() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        List<WebElement> columnElements = driver.findElements(By.xpath("//table[@id='customers']//tr//td"));
        List<ArrayList<String>> actualTableValues = TableUtility.get_Dynamic_TwoDimension_TablElemnts(rowElements, columnElements);
        System.out.println(actualTableValues);
        int rowSize = actualTableValues.size();
        int columnSize = actualTableValues.get(0).size();
        System.out.println("the number of rows will be :" + rowSize);
        System.out.println("the number of columns will be :" + columnSize);
        for (int i = 0; i < rowSize; i++) {
            String company = actualTableValues.get(i).get(0);
            if (company.equals("Island Trading")) {
                System.out.println(actualTableValues.get(i).get(1));
                System.out.println(actualTableValues.get(i).get(2));
                break;
            }
        }
    }

    @Test
    public void verifyUserManagementEdit() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement userName = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'and @name='username']"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name='password']"));
        passWord.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        List<WebElement> panels = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        selectPanels1("Admin", panels);
        List<WebElement> rowElements = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        List<WebElement> columnElements = driver.findElements(By.xpath("//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']"));
        List<ArrayList<String>> actualTableValues = TableUtility.get_Dynamic_TwoDimension_TablElemnts(rowElements, columnElements);
        int rowSize = actualTableValues.size();
        int columnSize = actualTableValues.get(0).size();
        for (int i = 0; i < rowSize; i++) {
            String userNames = actualTableValues.get(i).get(0);
            if (userNames.equals("Alice.Duval")) {
                System.out.println("the user role will be :" + actualTableValues.get(i).get(2));
                System.out.println("the Employee name will be :" + actualTableValues.get(i).get(3));
                break;
            }
        }
    }

    public void selectPanels1(String panel, List<WebElement> panels) {
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
    public void verifyImplicitWait() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    }

    @Test
    public void verifyExplicitWait() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("anas1@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Izin@2020");
        WebElement loginClick = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginClick.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-links']//a[@class='account']")));
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        userAccountEmail.getText();
        String actualEmailId = userAccountEmail.getText();
        Assert.assertEquals(actualEmailId, "anas1@gmail.com", "login failed");
    }

    @Test
    public void verifyWaitForAlertToBePresent() {
        driver.get("https://demoqa.com/alerts");
        WebElement confAlertOk = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        confAlertOk.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test 
    public void verifyFluentWait() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("anas1@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Izin@2020");
        WebElement loginClick = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginClick.click();
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-links']//a[@class='account']")));
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        userAccountEmail.getText();
        String actualEmailId = userAccountEmail.getText();
        Assert.assertEquals(actualEmailId, "anas1@gmail.com", "login failed");
    }

    @Test
    public void verifyFluentWaitForAlertToBePresent() {
        driver.get("https://demoqa.com/alerts");
        WebElement confAlertOk = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        confAlertOk.click();
        FluentWait wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void verifySubscriberMessage(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement emailField=driver.findElement(By.xpath("//input[@id='newsletter-email']"));
        emailField.sendKeys("anas@gmail.com");
        WebElement subscribeButton=driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
        subscribeButton.click();
        WebElement actualTextElement=driver.findElement(By.xpath("//div[@id='newsletter-result-block']"));
        String actualTextMessage=actualTextElement.getText();
        String expectedTextMessage="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        Assert.assertEquals(actualTextMessage,expectedTextMessage,"Email Subscription is failed");
    }
}









