package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[@class='rsHdr']")
    private WebElement searchResultHeader;

    @FindBy(xpath = "//input[@class=\"gh-tb ui-autocomplete-input\"]")
    private WebElement searchKeyword;

    @FindBy(xpath = "//div[@class= 'wnd-b']/p[@class='dContent toolTip']")
    private WebElement toolTipPopup;

    @FindBy(xpath = "//a[@class= 'wnd-c']")
    private WebElement tooltipPopupCloseButton;

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']/span[2]")
    private WebElement itemNumberInSearchResult;

    @FindBy(xpath = "//div[@class='s-message__content']")
    private WebElement messageContent;

    @FindBy(xpath = "//button[@class='faux-link follow-ebay__trigger']")
    private WebElement saveThisSearchButton;

    public boolean isToolTipPopupVisible() { return toolTipPopup.isDisplayed();}

    public void clickTooltipPopupCloseButton() { tooltipPopupCloseButton.click();}

    public WebElement getSearchResultHeader(){ return searchResultHeader;}
    public String getSearchKeyword(){ return searchKeyword.getAttribute("value");}
    public String getSearchItemNumber(){ return itemNumberInSearchResult.getText();}
    public boolean isMessageContentVisible(){ return messageContent.isDisplayed();}
    public void clickSaveThisSearchButton(){ saveThisSearchButton.click();}
}
