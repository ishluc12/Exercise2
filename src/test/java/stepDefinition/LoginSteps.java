package stepDefinition;

import DriverFactory.DriverFactory;
import constants.EndPoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the customer is on the login page")
    public void the_customer_is_on_the_login_page() {
        driver= DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.load(EndPoint.LOGIN.path);
    }
    @When("the customer enters valid credentials")
    public void the_customer_enters_valid_credentials() {
        loginPage.enterCredentials();
    }
    @When("the customer clicks the login button")
    public void the_customer_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the customer is directed to the my account page")
    public void the_customer_is_directed_to_the_my_account_page() {
        String result=loginPage.isAccountTitleDisplayed();
        assertTrue(result.contains("My account"),
                "Incorrect Title is displayed"
        );
    }




}
