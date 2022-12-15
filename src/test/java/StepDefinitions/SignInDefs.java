package StepDefinitions;

import Util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import java.util.Map;

public class SignInDefs {
    DriverFactory driverFactory = new DriverFactory();
    public WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private BasePage basePage = new BasePage(driver);
    private SignInPage SignInPage = new SignInPage(driver);


    @Given("I have navigated to the login page")
    public void iHaveNavigatedToTheLoginPage() {
        homepage.goTo();
        homepage.navigateToSignInPage();
    }

    @When("I input details")
    public void iInputValidDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String Email = data.get("Email");
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(Email);
        String Password = data.get("Password");
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(Password);
    }

    @And("Hit Enter")
    public void hitEnter() {
        basePage.waitAndClick(By.cssSelector("button[class=\"btn btn-primary\"]"));
    }

    @Then("I am logged in successfully")
    public void iAmLoggedInSuccessfully() {
        SignInPage.Verify("//header/h1", "Your account");
        driverFactory.close();
    }


    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        SignInPage.Verify("//header/h1", "Log in to your account");
        driverFactory.close();
    }

    @Then("An error message appears")
    public void anErrorMessageAppears() {
        SignInPage.Verify("//header/h1", "Log in to your account");
        driverFactory.close();
    }
}

