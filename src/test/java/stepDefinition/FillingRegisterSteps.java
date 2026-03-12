package stepDefinition;

import DriverFactory.DriverFactory;
import constants.EndPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FillingRegisterSteps {
    private WebDriver driver;
    private RegisterPage registerPage;


    @And("A customer is on register page")
    public void a_customer_is_on_register_page() {
       driver=DriverFactory.getDriver();
       registerPage=new RegisterPage(driver);
       registerPage.load(EndPoint.REGISTER.path);
    }

    @When("A customer enter valid credential")
    public void a_customer_enter_valid_credential() {
        registerPage.fillRegisterFormFromEnv();
    }
    @Then("A successful message is displayed")
    public void a_successful_message_is_displayed() {
     String result=registerPage.getLoginTitle();
     assertTrue(result.contains("Login"), "incorrect tilte");
    }

}
