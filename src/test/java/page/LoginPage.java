package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[normalize-space(text())='Register your account']")
    private WebElement registerLink;
    @FindBy(xpath = "//h3[contains(text(),'Customer registration')]")
    private WebElement registerTitle;

    public void clickRegisterLink(){
        wait.until(ExpectedConditions.visibilityOf(registerLink)).click();
    }
    public String getRegisterTitle(){
        return wait.until(ExpectedConditions.visibilityOf(registerTitle)).getText();
    }
}
