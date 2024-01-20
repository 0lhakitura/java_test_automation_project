package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement checkoutMainHeader;

    public boolean isCheckoutMainHeaderVisible(){ return checkoutMainHeader.isDisplayed();}
    public WebElement getCheckoutMainHeader(){ return checkoutMainHeader;}

    public String getCheckoutMainHeaderText(){ return checkoutMainHeader.getText();}

}
