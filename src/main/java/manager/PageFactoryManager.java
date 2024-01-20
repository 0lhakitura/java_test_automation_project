package manager;

import org.openqa.selenium.WebDriver;
import pages.*;



public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver){this.driver = driver;}

    public HomePage getHomePage(){ return new HomePage(driver);}

    public AdvancedSearchPage getAdvancedSearchPage(){ return new AdvancedSearchPage(driver);}

    public CartPage getCartPage(){ return new CartPage(driver);}

    public SearchResultPage getSearchResultPage(){ return new SearchResultPage(driver);}

    public SignInPage getSignInPage(){ return new SignInPage(driver);}

    public ProductPage getProductPage(){ return new ProductPage(driver);}

    public CheckoutPage getCheckoutPage(){ return new CheckoutPage(driver);}


}
