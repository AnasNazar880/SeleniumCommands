package org.obs.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver;//all actions on Google driver
       /* driver = new ChromeDriver();//Launching  chrome driver upcasting

        driver.manage().window().maximize();//for maximizing browser webdriver commands
        driver.get("https://selenium.obsqurazone.com/index.php");//for loading url
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String actualCurrenturl = driver.getCurrentUrl();
        System.out.println(actualCurrenturl);//for getting url of
        String actualSourceCode = driver.getPageSource();//for
        System.out.println(actualSourceCode);//for printing source code
        driver.close();//for closing browser window*/
//actions on edge browser
       /* driver = new EdgeDriver(); //upcasting
        driver.manage().window().maximize();
        driver.get("https://selenium.obsqurazone.com/index.php");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String actualCurrentFile = driver.getCurrentUrl();
        System.out.println(actualCurrentFile);
        String actualSourceCode = driver.getPageSource();
        System.out.println(actualSourceCode);
        driver.close();*/
        //actions on firefox browser
        driver =new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium.obsqurazone.com/index.php");
       String actualTitle= driver.getCurrentUrl();
        System.out.println(actualTitle);
        String actualSourceCode=driver.getPageSource();
        System.out.println(actualSourceCode);
        driver.close();

    }
}
