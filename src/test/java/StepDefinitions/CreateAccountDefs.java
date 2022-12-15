package StepDefinitions;

import Tests.DriverFactory;
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

public class CreateAccountDefs {

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

    @When("I enter details")
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
        basePage.waitAndClick(By.xpath("//footer/button[@class='btn btn-primary form-control-submit float-xs-right']"));
    }

    @Then("An account is created and I am logged in")
    public void anAccountIsCreatedAndIAmLoggedIn() {
        SignInPage.Verify("//div/a[@class='logout hidden-sm-down']", "Sign out");
        driverFactory.close();

    }

    @Then("An account is not created")
    public void anAccountIsNotCreated() {
        SignInPage.Verify("//header/h1", "Create an account");
        driverFactory.close();
    }


}

