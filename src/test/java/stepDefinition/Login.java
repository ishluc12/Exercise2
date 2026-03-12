package stepDefinition;

import DriverFactory.DriverFactory;
import constants.EndPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login {
    private WebDriver driver;
    private LoginPage loginPage;

    @When("A customer click on Register link on login form")
    public void a_customer_click_on_register_link_on_login_form() {
        driver= DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.load(EndPoint.LOGIN.path);
        loginPage.clickRegisterLink();

    }

    @Then("A form of registering customer is opened")
    public void a_form_of_registering_customer_is_opened() {
        String result=loginPage.getRegisterTitle();
        assertTrue(result.contains("Customer registration"), "incorrect Title");
    }
}
