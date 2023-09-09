package org.obs.testngbasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base{
    @Test
    public void verifyHomePageTitle() {
        String actTitle = driver.getTitle();
        String expTitle = "Demo Web Shop";
        Assert.assertEquals(actTitle, expTitle, "home page title mismatch");
    }
    @Test
    public void verifySubscriberMessage(){
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
