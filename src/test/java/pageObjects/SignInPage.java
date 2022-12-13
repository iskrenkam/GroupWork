package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector("input[name=\"email\"]");
    private static final By PASSWORD_INPUT_BOX = By.cssSelector("input[name=\"password\"]");
    private static final By FORGOT_YOUR_PASSWORD_BUTTON = By.cssSelector(".forgot-password");
    private static final By SIGN_IN = By.cssSelector(".form-footer button[type=\"submit\"]");
    private static final By CREATE_NEW_ACCOUNT_BUTTON = By.cssSelector(".no-account");
    private static final By AUTHENTICATION_FAILED_ALERT = By.cssSelector("div .alert-danger");


    public void enterEmailAddress(String emailAddress) {
        findAndType(EMAIL_ADDRESS_INPUT_BOX, emailAddress);
    }

    public void enterPassWord(String passWord) {
        findAndType(PASSWORD_INPUT_BOX, passWord);
    }

    public void clickForgotYourPassword() {
        waitAndClick(FORGOT_YOUR_PASSWORD_BUTTON);
    }

    public void clickSignIn() {
        waitAndClick(SIGN_IN);
    }

    public void clickCreateAnAccount() {
        waitAndClick(CREATE_NEW_ACCOUNT_BUTTON);
    }


    public void authenticationFailedAlertPageVisible() {
        WebElement alertBox = driver.findElement(AUTHENTICATION_FAILED_ALERT);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

    public void signInButtonVisible() {
        WebElement alertBox = driver.findElement(SIGN_IN);
        Assert.assertTrue(elementIsVisible(alertBox));
    }


}
