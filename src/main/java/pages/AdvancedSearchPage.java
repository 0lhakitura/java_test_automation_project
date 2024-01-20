package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchPage extends BasePage{

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h2[@class= 'sbx-h rct-hm rct-bg']" )
    private WebElement findItemsHeader;

    @FindBy(xpath = "//input[@id='_nkw']")
    private WebElement keywordsAndItemNumberInputField;

    @FindBy(xpath = "//select[@id='_in_kw']" )
    private WebElement keywordOptions;

    @FindBy(xpath = "//input[@id='_ex_kw']]" )
    private WebElement excludeWordsInputField;

    @FindBy(xpath = "//select[@id='e1-1']")
    private WebElement inThisCategorySelect;

    @FindBy(xpath = "//div[@class='adv-s mb space-top']/button[@class='btn btn-prim']" )
    private WebElement firstSearchButton;



    @FindBy(xpath = "//fieldset[@class='checkbox-set']/legend[text()='Search including']" )
    private WebElement searchIncludingCheckboxSet;

    @FindBy(xpath = "//input[@id='LH_TitleDesc']")
    private WebElement titleAndDescriptionCheckbox;



    @FindBy(xpath = "//fieldset/legend[text() ='Price']" )
    private WebElement priceSet;

    @FindBy(xpath = "//input[@id='_mPrRngCbx']")
    private WebElement priceCheckbox;

    @FindBy(xpath = "//input[@name='_udlo']" )
    private WebElement minimumPriceRange;

    @FindBy(xpath = "//input[@name='_udhi']")
    private WebElement maximumPriceRange;




    @FindBy(xpath = "//fieldset[@class='checkbox-set']/legend[text() ='Buying formats']" )
    private WebElement buyingFormatsCheckboxSet;

    @FindBy(xpath = "//input[@id='LH_BIN']" )
    private WebElement buyItNowCheckbox;



    @FindBy(xpath = "//fieldset[@class='checkbox-set']/legend[text() ='Condition']" )
    private WebElement conditionCheckboxSet;

    @FindBy(xpath = "//input[@id='LH_ItemConditionNew']" )
    private WebElement newConditionCheckbox;


    @FindBy(xpath = "//fieldset[@class='checkbox-set']/legend[text() ='Show results']" )
    private WebElement showResultsCheckboxSet;
    @FindBy(xpath = "//input[@id='LH_SaleItems']" )
    private WebElement saleItemsCheckbox;


    @FindBy(xpath = "//fieldset[@class='checkbox-set nested']/legend[text() ='Shipping options']" )
    private WebElement shippingOptionsCheckboxSet;
    @FindBy(xpath = "//input[@id='LH_FS']" )
    private WebElement freeInternationalShippingOption;


    @FindBy(xpath = "//fieldset[@class='checkbox-set location-set']/legend[text() ='Location']" )
    private WebElement locationCheckboxSet;

    @FindBy(xpath = "//input[@id='LH_PrefLocRadio']" )
    private WebElement preferredLocationRadioButton;




    @FindBy(xpath = "//fieldset[@class='checkbox-set']/legend[text() ='Sellers']")
    private WebElement sellersCheckboxSet;
    @FindBy(xpath = "//input[@id='_fss'] ")
    private WebElement selectSellersCheckbox;
    @FindBy(xpath = "//input[@id='LH_SellerWithStore_id']")
    private WebElement selectSellerWithEbayStoresRadio;





    @FindBy(xpath = "//label[@for = 'LH_VIEW_RESULTS_AS']" )
    private WebElement viewResultsLabel;

    @FindBy(xpath = "//select[@id='LH_VIEW_RESULTS_AS']" )
    private WebElement viewResultSelect;

    @FindBy(xpath = "//label[@for = 'LH_SORT_BY']" )
    private WebElement sortByLabel;

    @FindBy(xpath = "//select[@id='LH_SORT_BY']" )
    private WebElement sortBySelect;

    @FindBy(xpath = "//label[@for = 'LH_IPP']" )
    private WebElement resultsPerPageLabel;

    @FindBy(xpath = "//select[@id='LH_IPP']" )
    private WebElement resultsPerPageSelect;

    @FindBy(xpath = "//button[@id='searchBtnLowerLnk']" )
    private WebElement secondSearchButton;

    @FindBy(xpath = "//a[@href='https://www.ebay.com/sch/ebayadvsearch?_sofindtype=0'and contains(text(), 'Clear')]" )
    private WebElement clearOptionsLink;

    @FindBy(xpath = "//a[text() = 'By item number']")
    private WebElement searchByItemNumber;


    @FindBy(xpath = "//input[@id='e1-2']")
    private WebElement searchFieldByItemNumber;

    @FindBy(xpath = "//button[@id ='searchBtnLnk']")
    private WebElement searchByItemNumberButton;


    public WebElement getFindItemsHeader(){ return findItemsHeader;}

    public void fillKeywordsAndItemNumberInputField(String keyword){ keywordsAndItemNumberInputField.sendKeys(keyword);}

    public void clickTitleAndDescriptionCheckbox(){titleAndDescriptionCheckbox.click();}

    public void clickPriceCheckbox(){ priceCheckbox.click();}
    public void enterMinimumPriceRange(String keyword){ minimumPriceRange.sendKeys(keyword);}
    public void enterMaximumPriceRange(String keyword){ maximumPriceRange.sendKeys(keyword);}

    public void clickBuyItNowCheckbox(){ buyItNowCheckbox.click();}

    public void clickNewConditionCheckbox(){ newConditionCheckbox.click();}

    public void clickSaleItemsCheckbox(){ saleItemsCheckbox.click();}

    public void clickFreeInternationalShippingOption(){ freeInternationalShippingOption.click();}

    public void clickPreferredLocationRadioButton(){ preferredLocationRadioButton.click();}

    public void clickSellersCheckbox(){  selectSellersCheckbox.click();}

    public void clickSellerWithEbayStoresRadio(){  selectSellerWithEbayStoresRadio.click();}

    public void clickSecondSearchButton(){  secondSearchButton.click();}

    public void clickClearOptions(){ clearOptionsLink.click();}

    public String getSearchKeywords(){ return keywordsAndItemNumberInputField.getAttribute("value");}

    public void clickSearchByItemNumber(){ searchByItemNumber.click();}

    public void fillSearchFieldByItemNumber(String itemNumber){ searchFieldByItemNumber.sendKeys(itemNumber);}

    public void clickSearchByTtemNumberButton(){ searchByItemNumberButton.click();}










}
