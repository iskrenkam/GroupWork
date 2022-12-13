package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;

import java.util.Random;

import static Tests.TestSuite.driverFactory;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class BuyJourney {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ShoppingCartPage basketpage = new ShoppingCartPage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private ProductPage productPage = new ProductPage(driver);

    @Before
    public void individualSetUp() {
        homepage.goTo();
    }

    /**
     * Select Item from homepage, takes to product page
     * On homepage
     * Hover over a product's image
     * Click More Button
     * Verify product page is displayed
     */
    @Test
    public void selectItemFromHomepage() {
        Random rand = new Random();
        int a = rand.nextInt(6)+1;

        String selectedProduct = homepage.productName(a);
        homepage.clickProductThumbnail(a);

        productPage.correctItemSelected(selectedProduct);

    }

    /**
     * Add product to Cart from homepage
     * Hover over product from homepage
     * Click add to cart
     * Verify added to cart
     */
    @Test
    public void addProductToCartFromHomepage() {
        Random rand = new Random();
        int a = rand.nextInt(6)+1;


        homepage.clickProductThumbnail(a);

        String productSelected = productPage.productName().toLowerCase();
        productPage.addProductToCart();
        productPage.proceedToCheckout();

        basketpage.correctItemInCart(productSelected);

    }

    /**
     * Add product to cart from Product page
     * On product page
     * Select Quantity
     * Select Size
     * Select Colour (if available)
     * Click add to cart
     * Verify Added to Cart
     */
    @Test
    public void addProductToCartFromProductPage() {


        Random rand = new Random();
        int a = rand.nextInt(6)+1;
        int b = rand.nextInt(2);

        String[] sizes = {"S", "M", "L"};
        String size = sizes[b];

        String colorSelected;

        homepage.clickProductThumbnail(a);
        String productSelected = productPage.productName().toLowerCase();


        productPage.quantitySelected(Integer.toString(a));
        productPage.itemSizeSelected(Integer.toString(b+1));
        productPage.altColourSelected();

        if(productPage.itemAvailable().equalsIgnoreCase("\uE5CA In stock")){
            colorSelected = productPage.altColorChosen();
            productPage.addProductToCart();
        }  else {
            productPage.primaryColourSelected();
            colorSelected = productPage.primaryColorChosen();
            productPage.addProductToCart();
        }
        productPage.proceedToCheckout();

        basketpage.correctItemInCart(productSelected, Integer.toString(a), size, colorSelected );
    }

    @After
    public void individualTearDown() {
        driver.manage().deleteAllCookies();
    }

}
