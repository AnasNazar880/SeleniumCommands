package org.obs.testngbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    WebDriver driver;

    public void initializeTest(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("invalid browser name receiver");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void setUp() {
        initializeTest("chrome");
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }
}
