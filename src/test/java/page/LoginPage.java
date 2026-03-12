package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.EnvConfig;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[normalize-space(text())='Register your account']")
    private WebElement registerLink;
    @FindBy(xpath = "//h3[contains(text(),'Customer registration')]")
    private WebElement registerTitle;
    @FindBy(css = "[data-test='email']")
    private WebElement emailField;

    @FindBy(css = "[data-test='password']")
    private WebElement passwordField;

    @FindBy(css = "[data-test='login-submit']")
    private WebElement loginButton;

    @FindBy(css = ".help-block")
    private WebElement accountLockedMessage;

    @FindBy(xpath = "//h1[contains(text(), 'My account')]")
    private WebElement accountTitle;


    public void clickRegisterLink(){
        wait.until(ExpectedConditions.visibilityOf(registerLink)).click();
    }
    public String getRegisterTitle(){
        return wait.until(ExpectedConditions.visibilityOf(registerTitle)).getText();
    }


    public void enterCredentials() {
        emailField.sendKeys(EnvConfig.getLoginEmail());
        passwordField.sendKeys(EnvConfig.getLoginPassword());
    }

    public void clickLoginButton() {
        loginButton.click();
    }

//    public boolean isAccountLockedMessageDisplayed() {
//        wait.until(ExpectedConditions.visibilityOf(accountLockedMessage));
//        return accountLockedMessage.isDisplayed();
//    }

    public String isAccountTitleDisplayed(){
     return   wait.until(ExpectedConditions.visibilityOf(accountTitle)).getText();
    }


}
