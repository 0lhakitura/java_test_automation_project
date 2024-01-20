package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openProductPage(String url) {
        driver.get(url);
    }

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='vi-atl-lnk']")
    private WebElement addToWatchlist;

    @FindBy(xpath ="//div[@class='vi-flex-cta']")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//div[@id = 'streamLineBinOly']")
    private WebElement buyItNowPopup;

    @FindBy(xpath = "//button[@id='sbin-gxo-btn']")
    private WebElement checkoutAsGuest;

    public void clickAddToCartButton(){ addToCartButton.click();}
    public void clickAddToWatchlist(){ addToWatchlist.click();}
    public void clickBuyItNowButton(){ buyItNowButton.click();}
    public WebElement getBuyItNowPopup(){ return buyItNowPopup;}
    public void clickCheckoutAsGuest(){ checkoutAsGuest.click();}

}
