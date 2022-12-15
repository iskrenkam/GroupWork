package StepDefinitions;

import Util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import java.util.Random;

public class NewsletterDefs {
    DriverFactory driverFactory = new DriverFactory();
    public WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private BasePage basePage = new BasePage(driver);
    private pageObjects.SignInPage SignInPage = new SignInPage(driver);

    Random rand = new Random();
    String emailend = "@ten10.com";

    @Given("I have navigated to the HomePage")
    public void IHaveNavigatedToTheHomePage() {
        homepage.goTo();

    }

    @When("I input email into newsletter")
    public void iInputEmailIntoNewsletter() {
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(rand + emailend);
    }

    @And("Hit Subscribe")
    public void hitSubscribe() {
        SignInPage.waitAndClick(By.xpath("//div/input[@class='btn btn-primary float-xs-right hidden-xs-down']"));
    }

    @Then("I am successfully subscribed to the newsletter")
    public void iAmSuccessfullySubscribedToTheNewsletter() {
        SignInPage.Verify("//div/p[@class='alert alert-success']", "You have successfully subscribed to this newsletter");

    }

    @Then("An error message is displayed")
    public void anErrorMessageIsDisplayed() {
        SignInPage.Verify("//div/p[@class='alert alert-danger']", "This email address is already registered");
    }
}
