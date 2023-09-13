package org.obs.testngbasics;

import org.obs.failedtestretry.RetrayAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base{
    @Test(priority = 1,invocationCount = 2,groups = {"Sanity","Regression"})
    public void verifyHomePageTitle() {
        String actTitle = driver.getTitle();
        String expTitle = "Demo Web Shop";
        Assert.assertEquals(actTitle, expTitle, "home page title mismatch");
    }
    @Test(priority = 3,groups = {"Sanity","Regression"},retryAnalyzer = RetrayAnalyzer.class)
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
    @Test(priority = 2,enabled = true,groups = {"Smoke"})
    public void verifyButton(){
        Assert.assertTrue(true);
    }
    @Test(priority = 4,groups = {"Sanity","Regression"})
    public void verifyPanel(){
        Assert.assertTrue(true);
    }
}
