package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 08/11/2016.
 */
public class ShoppingCart {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ShoppingCartPage basketpage = new ShoppingCartPage(driver);

    @Before
    public void individualSetUp() {
        homepage.goTo();
    }

    /**
     * Remove item from shopping cart
     * Pre-Condition - Item must be in basket
     * Navigate to basket
     * Click Delete
     * Verify Item is removed from Basket
     * Extension - verify pricing and totals are updated to reflect accurately
     */
    @Test
    @Ignore
    public void removeItemFromShoppingBasket() {

    }

    /**
     * Increase quantity of product
     * Pre-Condition - Must have one item in basket
     * Navigate to basket
     * Increase quantity of product
     * Verify basket updated with correct quantity
     * Verify Product counter (Top right) is updated
     * Extension - verify pricing and totals are updated to reflect accurately
     */
    @Test
    @Ignore
    public void increaseQuantityOfProductInBasket() {

    }

    /**
     * Proceed to checkout - not signed in
     * Pre-Condition - Must have one item in basket && not be signed in
     * Navigate to basket
     * Click proceed to checkout
     * Verify sign in page displayed
     */
    @Test
    @Ignore
    public void proceedToCheckoutNotLoggedIn() {

    }

    /**
     * Proceed to checkout - signed in
     * Pre-Condition - Must have one item in basket && be signed in
     * Navigate to basket
     * Click proceed to checkout
     * Delivery Address Page is shown
     * Click proceed to checkout
     * Shipping page is shown
     * Agree to terms of service
     * Click proceed to checkout
     * Payment page is displayed
     * Click pay by bank wire
     * Confirm order
     * Order confirmation page is displayed
     */
    @Test
    @Ignore
    public void proceedToCheckoutAndBuyLoggedIn() {

    }

    @After
    public void individualTearDown() {
        driver.manage().deleteAllCookies();
    }

}
