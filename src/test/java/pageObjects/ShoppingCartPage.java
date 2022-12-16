package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jack.forman on 22/10/2016.
 */
public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private static final By PRODUCT_LABEL = By.cssSelector("li:nth-child(1) .product-line-grid-body div:nth-of-type(1) .label");
    private static final By SIZE_LABEL = By.cssSelector("li:nth-child(1) .product-line-grid-body div:nth-of-type(3) .value");
    private static final By COLOR_LABEL = By.cssSelector("li:nth-child(1) .product-line-grid-body div:nth-of-type(4) .value");
    private static final By QUANTITY_CHOSEN_OF_FIRST_ITEM = By.cssSelector("li:first-child .js-cart-line-product-quantity");

    public String productInCart(){
        return new String(driver.findElement(PRODUCT_LABEL).getText());
    }

    public void correctItemInCart(String productSelected) {
        String itemInCart = driver.findElement(PRODUCT_LABEL).getText().toLowerCase();
        Assert.assertTrue(productSelected.toLowerCase().equals(itemInCart.toLowerCase()));
    }

    public void correctItemInCart(String productSelected, String quantitySelected, String size, String color){
        String itemInCart = driver.findElement(PRODUCT_LABEL).getText().toLowerCase();
        String numberInCart = driver.findElement(QUANTITY_CHOSEN_OF_FIRST_ITEM).getAttribute("Value");


        String sizeInCart = driver.findElement(SIZE_LABEL).getText().toLowerCase();

        String colorInCart = driver.findElement(COLOR_LABEL).getText().toLowerCase();



        Assert.assertTrue(productSelected.toLowerCase().equals(itemInCart.toLowerCase()));
        Assert.assertTrue(quantitySelected.toLowerCase().equals(numberInCart.toLowerCase()));
        Assert.assertTrue(size.toLowerCase().equals(sizeInCart.toLowerCase()));
        Assert.assertTrue(color.toLowerCase().equals(colorInCart.toLowerCase()));


    }

    public void quantitySelected(String a) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(QUANTITY_CHOSEN_OF_FIRST_ITEM).clear();
        findAndType(QUANTITY_CHOSEN_OF_FIRST_ITEM, a);
    }

}
