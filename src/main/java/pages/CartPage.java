package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@data-test-id='main-title']")
    private WebElement shoppingCartMainHeader;

    @FindBy(xpath = "//div[@data-test-id='list-summary']")
    private WebElement listSummary;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeProductItemButton;

    @FindBy(xpath = "//div[@id='page-alerts']")
    private WebElement messageAlertItemRemoved;

    @FindBy(xpath = "//div[@class='font-title-3']//span[contains(text(), 'any items in your cart.')]")
    private WebElement messageNotificationItemRemoved;

    @FindBy(xpath = "//button[@data-test-id='cart-to-sfl']")
    private WebElement saveForLaterButton;



    public boolean isShoppingCartMainHeaderVisible(){
        return shoppingCartMainHeader.isDisplayed();
    }

    public boolean isMessageAlertItemRemovedVisible(){
        return messageAlertItemRemoved.isDisplayed();
    }

    public WebElement getMessageNotificationItemRemoved(){ return  messageNotificationItemRemoved;}

    public boolean isListSummaryVisible(){ return listSummary.isDisplayed();}

    public String getShoppingCartHeaderText(){ return shoppingCartMainHeader.getText();}

    public void clickRemoveProductItemButton(){ removeProductItemButton.click();}

    public void clickSaveForLaterButton(){ saveForLaterButton.click();}

}
