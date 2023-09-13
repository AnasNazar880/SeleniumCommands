package org.obs.testngbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

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
    @Parameters({"browser","baseurl"})
    public void setUp(String browserName,String url) {
        //initializeTest("chrome");
        //driver.get("https://demowebshop.tricentis.com/");
        initializeTest(browserName);
        driver.get(url);
    }


    @AfterMethod
    public void tearDown() {
       // driver.close();
    }

    @BeforeSuite
    public void connectDB() {
        System.out.println("connected to database");
    }

    @AfterSuite
    public void closeDB() {
        System.out.println("close database");
    }

    @BeforeTest
    public void runLoginAPI() {
        System.out.println("run in login API");
    }

    @AfterTest
    public void runLogOutAPI() {
        System.out.println(" logout API");
    }
    @BeforeClass
    public void createTestTable(){
        System.out.println("create test table");
    }
    @AfterClass
    public void dropTestTable(){
        System.out.println("drop test table");
    }


}
