package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".product-add-to-cart .add-to-cart");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("div .cart-content-btn .btn-primary");
    private static final By PRODUCT_LABEL = By.cssSelector(".h1");

    private static final By PRODUCT_QUANTITY = By.cssSelector(".input-group #quantity_wanted");
    private static final By PRODUCT_SIZE = By.cssSelector(".form-control#group_1");

    private static final By SELECT_ALTERNATIVE_COLOR_CHOICE_BUTTON = By.cssSelector(".product-variants li:last-of-type");
    private static final By SELECT_ALTERNATIVE_COLOR_CHOICE = By.cssSelector(".product-variants li:last-of-type .sr-only");
    private static final By SELECT_Primary_COLOR_CHOICE_BUTTON = By.cssSelector(".product-variants li:first-of-type");
    private static final By SELECT_Primary_COLOR_CHOICE = By.cssSelector(".product-variants li:first-of-type .sr-only ");
    private static final By IS_PRODUCT_IN_STOCK = By.cssSelector("#product-availability");


    public void addProductToCart() {
        waitAndClick(ADD_TO_CART_BUTTON);
    }

    public void proceedToCheckout() {
        waitAndClick(PROCEED_TO_CHECKOUT_BUTTON);
    }


    public void itemSizeSelected(String a) {
        selectValueFromDropDown(PRODUCT_SIZE, a);
    }

    public void quantitySelected(String a) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(PRODUCT_QUANTITY).clear();
        findAndType(PRODUCT_QUANTITY, a);
    }

    public void altColourSelected() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SELECT_ALTERNATIVE_COLOR_CHOICE_BUTTON));
        waitAndClick(SELECT_ALTERNATIVE_COLOR_CHOICE_BUTTON);
    }

    public void primaryColourSelected() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SELECT_Primary_COLOR_CHOICE_BUTTON));
        waitAndClick(SELECT_Primary_COLOR_CHOICE_BUTTON);
    }

    public String productName() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PRODUCT_LABEL));
        return new String(driver.findElement(PRODUCT_LABEL).getText());
    }

    public String itemAvailable() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PRODUCT_LABEL));
        return new String(driver.findElement(IS_PRODUCT_IN_STOCK).getText());
    }

    public String altColorChosen() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PRODUCT_LABEL));
        return new String(driver.findElement(SELECT_ALTERNATIVE_COLOR_CHOICE).getText());
    }

    public String primaryColorChosen() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PRODUCT_LABEL));
        return new String(driver.findElement(SELECT_Primary_COLOR_CHOICE).getText());
    }


    public void correctItemSelected(String productSelected) {
        String itemDisplayed = driver.findElement(PRODUCT_LABEL).getText().toLowerCase();
        Assert.assertTrue(productSelected.toLowerCase().equals(itemDisplayed.toLowerCase()));
    }


}
