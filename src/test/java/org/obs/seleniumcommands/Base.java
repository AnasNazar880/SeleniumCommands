package org.obs.seleniumcommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Base {
    public WebDriver driver;

    public void initializeTest(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("invalid browser name received");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void setUp(){
        initializeTest("chrome");
    }
    @AfterMethod
    public void tearDown(){
  driver.close();;
    }

}
