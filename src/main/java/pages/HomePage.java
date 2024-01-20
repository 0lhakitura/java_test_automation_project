package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Advanced Search']" )
    private WebElement advancedSearchLink;

    @FindBy(xpath = "//input[@id='gh-ac']" )
    private WebElement searchField;


    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement selectCategoryDropDownList;

    @FindBy(xpath =  "//input[@id='gh-btn']")
    private WebElement searchButton;

    public void openHomePage(String url) {
        driver.get(url);
    }



    public void clickAdvancedSearchLink(){ advancedSearchLink.click();}

    public void isAdvancedSearchLinkVisible(){advancedSearchLink.isDisplayed();}

    public void isSearchFieldVisible(){ searchField.isDisplayed();}

    public WebElement getSearchField() { return searchField; }

    public WebElement getAdvancedSearchLink(){ return advancedSearchLink;}

    public void fillSearchField(String keyword){ searchField.sendKeys(keyword);}

    public void setCategoryFromDropDownList(String category){
        Select categoryDropDownList = new Select(selectCategoryDropDownList);
        categoryDropDownList.selectByVisibleText(category);
    }

    public void clickSearchButton(){ searchButton.click();}


}
