package org.obs.homeWork;
import com.beust.ah.A;
import org.obs.utility.RandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FormSubmit extends Base{
    @Test
    public void verifyFormSubmit(){
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        String expectedFName= RandomData.getFirstName();
        String expectedLName=RandomData.getLastName();
        String cityName=RandomData.getCity();
        String expectedStateName=RandomData.getState();
        String userNames=expectedFName+"."+expectedLName;
        String actualZipCode=RandomData.getPinCode();
        WebElement firstName=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys(expectedFName);
        WebElement lastName=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys(expectedLName);
        WebElement userName=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
        userName.sendKeys(userNames);
        WebElement city=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        city.sendKeys(cityName);
        WebElement state=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        state.sendKeys(expectedStateName);
        WebElement zip=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zip.sendKeys(actualZipCode);
        WebElement agree=driver.findElement(By.xpath("//input[@ id='invalidCheck']"));
        agree.click();
        WebElement submitButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitButton.click();
        String expectedMessage="Form has been submitted successfully!";
        WebElement actual=driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualMessage=actual.getText();
        Assert.assertEquals(actualMessage,expectedMessage,"form submission failed");

    }
}
