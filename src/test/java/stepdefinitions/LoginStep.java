package stepdefinitions;


/**
 * This is step definition for Login feature
 *
 *
 * @author  Prashant Agrawal
 * @version 1.0
 * @since  04/02/2020
 */


import commonfunctions.Base;
import commonfunctions.Utility;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import featurefunctions.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStep {

    private Base baseObj;
    private Utility utilityObj;
    private Login loginObj;
    private WebDriver driver;

    public LoginStep(){
        baseObj=new Base();
        loginObj=new Login();
    }

    @Given("^I am ebay user$")
    public void iAmEbayUser() throws Exception {
        baseObj.initialize();
    }

    @Given("^I enter \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_enter(String username, String password) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        loginObj.logintoEbay(username,password);
    }

    @When("^I launch ebay website$")
    public void i_launch_ebay_website() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        baseObj.launchWebSite();
    }

    @And("^I login with \"([^\"]*)\", \"([^\"]*)\"$")
    public void iLoginWith(String username, String password) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        loginObj.logintoEbay(username,password);
    }

    @When("^I login to ebay website$")
    public void i_login_to_ebay_website() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Hello");
    }

    @Then("^I see welcome page$")
    public void i_see_welcome_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginObj.verifyWelcomePage();
    }
}
