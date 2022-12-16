package StepDefinitions;

import Util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import static StepDefinitions.Hooks.driverFactory;

public class CheckoutDefs {

    public WebDriver driver = driverFactory.getDriver();

    private HomePage homepage = new HomePage(driver);

    private ProductPage productPage = new ProductPage(driver);

    private SignInPage SignInPage = new SignInPage(driver);

    private CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("I have navigated to the checkout page")
    public void IHaveNavigatedToTheCheckoutPage() {
        checkoutPage.navigateToCheckout();
    }

    @And("I have one item in the cart")
    public void iHaveOneItemInTheCart() {
    }

    @When("I click checkout")
    public void iClickCheckout() {
    }

    @Then("I am successfully checked out")
    public void iAmSuccessfullyCheckedOut() {
    }
}
