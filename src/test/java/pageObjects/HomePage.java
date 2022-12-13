package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class HomePage extends BasePage {

    /**--------------------Constructor------------------------------*/
    public HomePage(WebDriver driver) {
        super(driver);
    }


    /**---------------------Statics------------------------------*/
    private static String URL = "http://3.11.77.136/";
    private static final By SIGN_IN_BUTTON = By.cssSelector("[title=\"Log in to your customer account\"]");
    private static final By SIGN_OUT_BUTTON = By.cssSelector(".user-info .logout");
    private static final By ACCOUNT_PAGE_AVAILABLE = By.cssSelector(".account .hidden-sm-down");



    public void goTo() {
        driver.get(URL);
    }

    public void navigateToSignInPage() {
        waitAndClick(SIGN_IN_BUTTON);
    }
    public void signOutFromCurrentAccount() {
        waitAndClick(SIGN_OUT_BUTTON);
    }


    public String productName(int a){
        return new String(driver.findElement(By.cssSelector("[data-id-product=\""+a+"\"] .product-title")).getText());
    }

    public void clickProductThumbnail(int a) {
        By PRODUCT_DISPLAY_Thumbnail = By.cssSelector("[data-id-product=\""+a+"\"] .product-thumbnail");
        waitAndClick(PRODUCT_DISPLAY_Thumbnail);
    }

    public void accountPageVisible() {
        WebElement alertBox = driver.findElement(ACCOUNT_PAGE_AVAILABLE);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

}
