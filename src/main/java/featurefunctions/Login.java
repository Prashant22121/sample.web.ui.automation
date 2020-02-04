/**
 * This is login class having feature functions related to login
 *
 *
 * @author  Prashant Agrawal
 * @version 1.0
 * @since  04/02/2020
 */


package featurefunctions;

import commonfunctions.Base;
import commonfunctions.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login{

    public WebElement usernameElement;
    public WebElement passwordElement;
    public WebDriver driver;
    public WebElement signInElement;
    public WebElement passwordContinueElement;
    public WebElement myEbayElement;

    public void logintoEbay(String username,String password)
    {
        try {
            driver=Base.getCurrentDriver();
            signInElement=Helper.getWebElement(driver,3,"sign_in_link","linktext");
            Helper.clickOnButton(signInElement);

            usernameElement= Helper.getWebElement(driver,3,"username_textfield","id");
            Helper.sendInputToTextField(usernameElement,username);
            signInElement=Helper.getWebElement(driver,3,"sign_in_continue_button","linktext");
            Helper.clickOnButton(signInElement);

            passwordElement= Helper.getWebElement(driver,3,"password_textfield","id");
            Helper.sendInputToTextField(passwordElement,password);
            passwordContinueElement= Helper.getWebElement(driver,3,"sign_in_button","id");
            Helper.clickOnButton(signInElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyWelcomePage()
    {
        try {
            myEbayElement=Helper.getWebElement(driver,3,"sign_in_continue_button","linktext");
            Assert.assertNotNull(myEbayElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
