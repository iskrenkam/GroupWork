package Tests;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
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

    @Given("I have navigated to the create an account page")
    public void IHaveNavigatedToTheCreateAnAccountPage() {
        homepage.goTo();
        homepage.navigateToSignInPage();
        SignInPage.clickCreateAnAccount();


    }

    @When("I enter valid details")
    public void iEnterValidDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String FirstName = data.get("First Name");
        driver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys(FirstName);
        String LastName = data.get("Last Name");
        driver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys(LastName);
        String Email = data.get("Email");
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(Email);
        String Password = data.get("Password");
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(Password);
        String Birthday = data.get("Birthdate");
        driver.findElement(By.cssSelector("input[name=\"birthday\"]")).sendKeys(Birthday);
    }


    @And("Hit Save")
    public void hitSave() {
        basePage.waitAndClick(By.cssSelector("button[type=\"submit\"]"));
    }

    @Then("An account is created and I am logged in")
    public void anAccountIsCreatedAndIAmLoggedIn() {

        driverFactory.close();
    }

    @Given("I have navigated to the login page")
    public void iHaveNavigatedToTheLoginPage() {
        homepage.goTo();
        homepage.navigateToSignInPage();
    }

    @When("I input valid details")
    public void iInputValidDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String Email = data.get("Email");
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(Email);
        String Password = data.get("Password");
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(Password);
    }

    @And("Hit Enter")
    public void hitEnter() {
        basePage.waitAndClick(By.cssSelector("button[type=\"submit\"]"));
    }

    @Then("I am logged in successfully")
    public void iAmLoggedInSuccessfully() {
        driverFactory.close();
    }
}

