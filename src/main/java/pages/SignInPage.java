package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id= 'signin-reg-msg']")
    private WebElement signInHeader;

    public boolean isSignInHeaderIsDisplayed(){ return signInHeader.isDisplayed();}

    public WebElement getSignInHeader(){ return signInHeader;}
}
