package org.obs.homeWork;
import com.beust.ah.A;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FormSubmit extends Base{
    @Test
    public void formSubmit(){
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        String expectedFName= RandomData.getFirstName();
        String expectedLName=RandomData.getLastName();
        String cityName=RandomData.getCity();
        String expectedStateName=RandomData.getState();
        String userNames=expectedFName+"."+expectedLName;
        String actualZipCode=RandomData.getPinCode();
        WebElement firstName=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys(expectedFName);
        String actualFirstName=firstName.getAttribute("value");
        Assert.assertEquals(actualFirstName,expectedFName,"First name does not match");
        WebElement lastName=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys(expectedLName);
        String actualLastName=lastName.getAttribute("value");
        Assert.assertEquals(actualLastName,expectedLName,"last name does not match ");
        WebElement userName=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
        userName.sendKeys(userNames);
        WebElement city=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        city.sendKeys(cityName);
        WebElement state=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        state.sendKeys(expectedStateName);
        String actualStateName=state.getAttribute("value");
        Assert.assertEquals(actualStateName,expectedStateName,"state name does not match");
        WebElement zip=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zip.sendKeys(actualZipCode);
        String expectedZipCode=zip.getAttribute("value");
        Assert.assertEquals(actualZipCode,expectedZipCode,"zip code does not match");
        WebElement agree=driver.findElement(By.xpath("//input[@ id='invalidCheck']"));
        agree.click();
        Assert.assertTrue(agree.isSelected(),"agree checkbox must be selected");
        Assert.assertTrue(agree.isDisplayed(),"agree checkbox is not displayed");
        Assert.assertTrue(agree.isEnabled(),"agree checkbox must be enabled");
        WebElement submitButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitButton.click();
        Assert.assertTrue(submitButton.isEnabled(),"submit button must  be  enabled");
        Assert.assertTrue(submitButton.isDisplayed(),"submit button must be displayed ");
    }
}
