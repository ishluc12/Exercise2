package stepDefinition;

import DriverFactory.DriverFactory;
import constants.EndPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterSteps {
    protected WebDriver driver;
    private HomePage homePage;


    @Given("That as a customer is on homepage")
    public void that_as_a_customer_is_on_homepage() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.load(EndPoint.HOME.path);

    }
    @And("A customer click on sing in on navigation bar")
    public void a_customer_click_on_sing_in_on_navigation_bar() {
        homePage.clickSignInLink();
    }
    @Then("the login form is opened")
    public void the_login_form_is_opened() {
        String result=homePage.getLoginTitle();
        assertTrue(result.contains("Login"), "incorrect title");
    }



}
