package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.EnvConfig;
import java.util.regex.Pattern;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) { super(driver); }

    @FindBy(id="first_name") private WebElement firstNameField;
    @FindBy(id="last_name") private WebElement lastNameField;
    @FindBy(id="dob") private WebElement dateOfBirthField;
    @FindBy(id="street") private WebElement streetField;
    @FindBy(id="postal_code") private WebElement postalCodeField;
    @FindBy(id="city") private WebElement cityField;
    @FindBy(id="state") private WebElement stateField;
    @FindBy(id="country") private WebElement countryField;
    @FindBy(id="phone") private WebElement phoneField;
    @FindBy(id="email") private WebElement emailField;
    @FindBy(id="password") private WebElement passwordField;
    @FindBy(css = "button[type='submit']") private WebElement submitButton;
    @FindBy(xpath = "//h3[contains(text(), 'Login')]") private WebElement loginTitle;

    private static final Pattern PASS_VALID = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");

    public RegisterPage fillRegisterFormFromEnv() {

        String pass = EnvConfig.getPassword();
        if (!PASS_VALID.matcher(pass).matches()) throw new IllegalArgumentException("Invalid Password Format");
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(EnvConfig.getFirstName());
        lastNameField.sendKeys(EnvConfig.getLastName());
        dateOfBirthField.sendKeys(EnvConfig.getDob());
        streetField.sendKeys(EnvConfig.getStreet());
        postalCodeField.sendKeys(EnvConfig.getPostalCode());
        cityField.sendKeys(EnvConfig.getCity());
        stateField.sendKeys(EnvConfig.getState());
        new Select(wait.until(ExpectedConditions.visibilityOf(countryField)))
                .selectByVisibleText(EnvConfig.getCountry());
        phoneField.sendKeys(EnvConfig.getPhone());
        emailField.sendKeys(EnvConfig.getEmail());
        passwordField.sendKeys(pass);
        return this;
    }

    public void clickRegisterButton(){
        submitButton.click();
    }
    public String getLoginTitle() {
        return wait.until(ExpectedConditions.visibilityOf(loginTitle)).getText();
    }
}