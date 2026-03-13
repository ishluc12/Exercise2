package stepDefinition;

import DriverFactory.DriverFactory;
import constants.EndPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterSteps {
    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;


    @Given("the customer is on the Toolshop homepage")
    public void the_customer_is_on_the_toolshop_homepage() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        homePage.load(EndPoint.HOME.path);

    }
    @When("the customer clicks on the {string} link")
    public void the_customer_clicks_on_the_link(String string) {
        homePage.clickSignInLink();
    }
    @And("the customer clicks on the {string} register link")
    public void the_customer_clicks_on_the_register_link(String string) {
        loginPage.clickRegisterLink();
    }
    @And("the customer fills in the registration form")
    public void the_customer_fills_in_the_registration_form() {
        registerPage.fillRegisterFormFromEnv();
    }
    @And("the customer clicks the {string} button")
    public void the_customer_clicks_the_button(String string) {
        registerPage.clickRegisterButton();
    }
    @Then("the customer should be redirected to the login page")
    public void the_customer_should_be_redirected_to_the_login_page() {
        String result=homePage.getLoginTitle();
        assertTrue(result.contains("Login"), "incorrect title");
    }
}
