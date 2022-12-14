package StepDefinitions;

import Util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SignInPage;

import java.util.concurrent.TimeUnit;

import static StepDefinitions.Hooks.driverFactory;

public class AddToCartDefs {


    public WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private SignInPage SignInPage = new SignInPage(driver);

    @Given("I have navigated to an item Page")
    public void IHaveNavigatedToAnItemPage() {
        homepage.goTo();
        homepage.clickProductThumbnail(2);

    }

    @When("I click add to cart")
    public void iClickAddToCart() {
        productPage.addProductToCart();

    }

    @Then("Item is added to cart")
    public void itemIsAddedToCart() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SignInPage.Verify("//div/h4[@class='modal-title h6 text-sm-center']", "Product successfully added to your shopping cart");

    }
}
