package testrunner;


/**
 * This is login runner class to execute test
 *
 *
 * @author  Prashant Agrawal
 * @version 1.0
 * @since  04/02/2020
 */


import commonfunctions.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}
                ,glue={"stepdefinitions"}
)
public class LoginTestRunner {

}
