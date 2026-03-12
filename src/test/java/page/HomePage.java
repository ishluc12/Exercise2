package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space(text())='Sign in']")
    private WebElement signInLink;
    @FindBy(xpath = "//h3[contains(text(), 'Login')]")
    private WebElement loginTitle;


    public void clickSignInLink(){
        wait.until(ExpectedConditions.visibilityOf(signInLink)).click();
    }
    public String getLoginTitle(){
        return wait.until(ExpectedConditions.visibilityOf(loginTitle)).getText();
    }
}
