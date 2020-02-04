package commonfunctions;


/**
 * This is Helper class for handling common functions like click, sendkeys
 * on webpage
 *
 *
 * @author  Prashant Agrawal
 * @version 1.0
 * @since  04/02/2020
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public static WebElement element;
    public static String basePath=System.getProperty("user.dir");
    public static String pathOfUiElements=basePath+"\\src\\test\\resources\\uielements\\Login.properties";

    public static WebElement getWebElement(WebDriver driver, long time, String locator,String locatorType)
    {
        try {
           String locatorValue=Utility.readPropertyFile(pathOfUiElements,locator);
           WebDriverWait wait=new WebDriverWait(driver,time);
            switch (locatorType.toLowerCase())
            {
                case "id":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
                    element=driver.findElement(By.id(locatorValue));
                    break;
                case "linktext":
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorValue)));
                    element=driver.findElement(By.linkText(locatorValue));
                    break;
                default:
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
                    element=driver.findElement(By.className(locatorValue));
            }
        } catch (Exception e) {
            System.out.println("Unable to find element using "+ locator);
        }
        return element;
    }

    public static void clickOnButton(WebElement element)
    {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on :"+ element);
        }

    }

    public static void sendInputToTextField(WebElement element,String keysToSend)
    {
        try {
            element.sendKeys(keysToSend);
        } catch (Exception e) {
            System.out.println("Unable to send input to the :"+ element);
        }
    }

}
