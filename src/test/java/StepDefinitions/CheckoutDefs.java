package StepDefinitions;

import Util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
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
        SignInPage.Verify("//div/span[@class='label js-subtotal']","item");
    }

    @When("I click checkout")
    public void iClickCheckout() {
        homepage.waitAndClick(By.xpath("//div/a[@class='btn btn-primary']"));
    }


    @Then("I have navigated to the Checkout page")
    public void iHaveNavigatedToTheCheckoutPage() {
        SignInPage.Verify("//div/section[@class='checkout-step -current -reachable js-current-step']","Addresses");
    }
}
