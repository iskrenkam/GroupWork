package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.ProductPage;


import static StepDefinitions.Hooks.driverFactory;

public class ChangeQuantityDefs {

    public WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ProductPage productPage = new ProductPage(driver);

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage.goTo();

    }
    @When("I click on the product I want")
    public void iClickOnTheProductIWant() {
        homepage.clickProductThumbnail(2);

    }

    @And("I will change the quantity of the product")
    public void iWillChangeTheQuantityOfTheProduct() {
        productPage.quantitySelected("3");
    }

    @Then("I will add product to cart")
    public void iWillAddProductToCart() {
        productPage.addProductToCart();
    }
}
