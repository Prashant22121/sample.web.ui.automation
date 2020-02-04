package commonfunctions;

/**
 * This is Base class for driver initialization
 *
 *
 * @author  Prashant Agrawal
 * @version 1.0
 * @since  04/02/2020
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.util.HashMap;

public class Base {

    private WebDriver driver;
    private static String basePath=System.getProperty("user.dir");
    private static String pathofEnvironmentFile=basePath+"\\src\\test\\resources\\testconfig\\Environment.properties";
    private static String chromedriverPath=basePath+"\\src\\test\\resources\\chromedriver\\chromedriver.exe";
    private static HashMap<Thread, WebDriver> drivers=new HashMap<Thread, WebDriver>();


    public WebDriver initialize() throws Exception
    {
        String browserName=Utility.readPropertyFile(pathofEnvironmentFile,"browser");
        switch (browserName.toLowerCase()){
           case "chrome":
               String path = System.getProperty("user.dir");
               System.setProperty("webdriver.chrome.driver",chromedriverPath);
               driver=new ChromeDriver();
               driver.manage().window().maximize();
               break;
           case "ie":
               //initialize ie driver
           case "firefox":
               //initialize firefox driver
           default:
               driver=new ChromeDriver();
       }
       drivers.put(Thread.currentThread(),driver);
       return driver;
    }

    public static WebDriver getCurrentDriver(){

        return (WebDriver)drivers.get(Thread.currentThread());
    }

    public void launchWebSite() throws Exception
    {
       String urlToLaunch= Utility.readPropertyFile(pathofEnvironmentFile,"ebay_url");
       driver.get(urlToLaunch);
    }

}
