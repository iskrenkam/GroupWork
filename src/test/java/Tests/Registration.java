package Tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageObjects.CreateNewAccountPage;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;

import java.util.Random;

import static Tests.TestSuite.driverFactory;


/**
 * Created by jack.forman on 09/10/2016.
 */


public class Registration {

    public static WebDriver driver = driverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ShoppingCartPage basketpage = new ShoppingCartPage(driver);
    private SignInPage signInPage = new SignInPage(driver);
    private CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);

    private Random rand = new Random();


    /**
     * This should make sure we are on the correct page, i.e. set up each test case so we can be sure that they run
     */
    @Before
    public void individualSetUp() {
        homepage.goTo();
    }





    /**
     * Cannot register if user Already Registered
     * Pre-Conditions - Must have Email address of user already registered
     * Navigate to Sign In Screen
     * Enter E mail Address
     * Click Create Account
     * Verify error message displayed
     */
    @Test
    public void registerAlreadyRegistered() {

        homepage.navigateToSignInPage();

        signInPage.clickCreateAnAccount();

        createNewAccountPage.enterFirstName("Matthew");
        createNewAccountPage.enterLastName("John-Hall");
        createNewAccountPage.enterEmailAddress("test@test.com");
        createNewAccountPage.enterPassword("123PassWord");
        createNewAccountPage.clickSaveAccount();
        createNewAccountPage.alreadyRegisteredAlertPresent();
    }


    /**
     * New user is able to register (New = not registered before)
     * Navigate to signIn Page
     * Enter E-Mail Address
     * Click Create New Account
     * Fill in All Details on registration form
     * Click Register
     * Check My Account Page is Displayed
     */
    @Test
    public void registerAsNewUser() {
        homepage.navigateToSignInPage();

        signInPage.clickCreateAnAccount();
        int a = rand.nextInt();
        String email = Integer.toString(a);

        createNewAccountPage.enterFirstName("Matthew");
        createNewAccountPage.enterLastName("John-Hall");
        createNewAccountPage.enterEmailAddress(a + "@test.com");
        createNewAccountPage.enterPassword("123PassWord");
        createNewAccountPage.clickSaveAccount();

        homepage.accountPageVisible();
    }


    @After
    public void individualTearDown() {
    driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void mainTearDown() {
        // Uncomment this when just running individual tests in this file.
        //driver.quit();
    }


}
