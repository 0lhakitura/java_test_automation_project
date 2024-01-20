package stepdefinitions;

import java.lang.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 150;

    WebDriver driver;
    HomePage homePage;
    AdvancedSearchPage advancedSearchPage;
    SearchResultPage searchResultPage;
    SignInPage signInPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }
    @And("User checks 'Advanced search' link visibility")
    public void checkAdvancedSearchLinkVisibility(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getAdvancedSearchLink());
        homePage.isAdvancedSearchLinkVisible();
    }

    @And("User opens advanced search page")
    public void openAdvancedSearchPage(){
        homePage.clickAdvancedSearchLink();
        advancedSearchPage = pageFactoryManager.getAdvancedSearchPage();
        advancedSearchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        advancedSearchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, advancedSearchPage.getFindItemsHeader());
    }

    @When("User makes advanced search by keyword {string}")
    public void enterKeywordToSearchField(String keyword){ advancedSearchPage.fillKeywordsAndItemNumberInputField(keyword);}

    @And("User selects search including title and description")
    public void selectTitleAndDescriptionCheckbox(){ advancedSearchPage.clickTitleAndDescriptionCheckbox();}

    @And("User selects 'Price' checkbox")
    public void selectPriceCheckbox(){ advancedSearchPage.clickPriceCheckbox();}

    @And("User enters {string} minimum price")
    public void enterMinimumPriceRange(String minimumPriceRange){ advancedSearchPage.enterMinimumPriceRange(minimumPriceRange);}

    @And("User enters {string} maximum price")
    public void enterMaximumPriceRange(String maximumPriceRange){ advancedSearchPage.enterMaximumPriceRange(maximumPriceRange);}

    @And("User selects 'Buy it now' buying format")
    public void selectBuyItNowCheckbox(){ advancedSearchPage.clickBuyItNowCheckbox();}

    @And("User selects 'New' condition")
    public void selectNexConditionCheckbox(){ advancedSearchPage.clickNewConditionCheckbox();}

    @And("User selects 'Sale items' to show in results")
    public void selectSaleItemsCheckbox(){ advancedSearchPage.clickSaleItemsCheckbox();}

    @And("User selects 'Free international shipping' option")
    public void selectFreeInternationalShippingOption(){ advancedSearchPage.clickFreeInternationalShippingOption();}

    @And("User selects 'From preferred location' option")
    public void selectPreferredLocationOption(){ advancedSearchPage.clickPreferredLocationRadioButton();}

    @And ("User selects 'Only show items from:' checkbox")
    public void selectSellersCheckbox(){ advancedSearchPage.clickSellersCheckbox();}

    @And ("User selects 'Sellers with eBay stores' option")
    public void selectSellerWithEbayStoresRadio(){ advancedSearchPage.clickSellerWithEbayStoresRadio();}

    @And ("User clicks 'Search' button")
    public void clickSearchButton(){ advancedSearchPage.clickSecondSearchButton();}



    @Then ("User checks search query in search result {string}")
    public void checkAmountOfProductsInSearchResult(String searchKeyword) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getSearchResultHeader());
        String actualResult = searchResultPage.getSearchKeyword();
        String expectedResult = searchKeyword;
        boolean result = actualResult.contains(expectedResult);
        assertTrue(result);
    }

    @And("User clicks 'Clear options' button")
    public void clickClearOptionsButton(){ advancedSearchPage.clickClearOptions(); }

    @Then("User checks if search input field is empty")
    public void checkSearchInputFieldIsEmpty(){
        advancedSearchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        advancedSearchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, advancedSearchPage.getFindItemsHeader());
        assertTrue( advancedSearchPage.getSearchKeywords().isEmpty());

    }

    @And ("User opens search by item number")
    public void openSearchByItemNumber() {
        advancedSearchPage.clickSearchByItemNumber();
        advancedSearchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        advancedSearchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, advancedSearchPage.getFindItemsHeader());

    }


    @When("User makes search by item number {string}")
    public void userMakesSearchByItemNumberItemNumber(String itemNumber) {
        advancedSearchPage.fillSearchFieldByItemNumber(itemNumber);
        advancedSearchPage.clickSearchByTtemNumberButton();
    }

    @Then("User checks search item number in search result {string}")
    public void userChecksSearchItemNumberInSearchResultExpectedResult(String searchItemNumber) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        String actualResult = searchResultPage.getSearchItemNumber();
        String expectedResult = searchItemNumber;
        boolean result = actualResult.contains(expectedResult);
        assertTrue(result);

    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSearchField());
        homePage.isSearchFieldVisible();
    }


    @And("User changes search category to {string}")
    public void userChangesSearchCategoryToAntiques(String category){
        homePage.setCategoryFromDropDownList(category);

    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeyword(String keyword) {
        homePage.fillSearchField(keyword);
        homePage.clickSearchButton();
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks message of found amount of items in the selected category")
    public void userChecksMessageOfFoundAmountOfItemsInTheSelectedCategory() {
        assertTrue(searchResultPage.isMessageContentVisible());
    }

    @And("User tries to save search")
    public void userTriesToSaveSearch() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickSaveThisSearchButton();
    }


    @Then("User checks if Sign In page is open")
    public void userChecksIfSignInPageIsOpen() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getSignInHeader());
        assertTrue(signInPage.isSignInHeaderIsDisplayed());

    }

    @Given("User opens {string} product page")
    public void userOpensProductPage(String url) {
        productPage = pageFactoryManager.getProductPage();
        productPage.openProductPage(url);
    }

    @When("User adds product to cart")
    public void userAddsProductToCart() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @Then("User checks if Cart Page is open")
    public void userChecksIfCartPageIsOpen() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(cartPage.isShoppingCartMainHeaderVisible());
        assertTrue(cartPage.getShoppingCartHeaderText().contains("Shopping cart"));
    }

    @And("List summary is visible")
    public void itemAmountIsVisibleInRightUpperCornerMiniCart() {
        assertTrue(cartPage.isListSummaryVisible());
    }


    @When("User removes product item from cart")
    public void userRemovesProductItemFromCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickRemoveProductItemButton();
    }

    @Then("Message alert is shown")
    public void messageAlertIsShown(){
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getMessageNotificationItemRemoved());
        assertTrue(cartPage.isMessageAlertItemRemovedVisible());
    }

    @When("User saves product item for later")
    public void userSavesProductItemForLater() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickSaveForLaterButton();
    }
    @When("User adds product to watchlist")
    public void userAddsProductToWatchlist() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToWatchlist();
    }

    @When("User clicks Buy it Now button")
    public void userClicksBuyItNowButton() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickBuyItNowButton();
    }

    @And("User selects Checkout as a guest")
    public void userSelectsCheckoutAsAGuest() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getBuyItNowPopup());
        productPage.clickCheckoutAsGuest();
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, checkoutPage.getCheckoutMainHeader());

    }

    @Then("User checks if Checkout page is open")
    public void userChecksIfCheckoutPageIsOpen() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(checkoutPage.isCheckoutMainHeaderVisible());
        assertTrue(checkoutPage.getCheckoutMainHeaderText().contains("Checkout"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }



}