package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jack.forman on 23/10/2016.
 */
public class CreateNewAccountPage extends BasePage {

    public CreateNewAccountPage(WebDriver driver) {
        super(driver);
    }


    private static final By FIRST_NAME_INPUT_BOX = By.cssSelector("input[name=\"firstname\"]");

    private static final By LAST_NAME_INPUT_BOX = By.cssSelector("input[name=\"lastname\"]");
    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector("input[name=\"email\"]");

    private static final By PASSWORD_INPUT_BOX = By.cssSelector("input[name=\"password\"]");

    private static final By ALREADY_REGISTERED_ALERT = By.cssSelector("div .alert-danger");

    private static final By SAVE_NEW_ACCOUNT_BUTTON = By.cssSelector(".form-footer .btn-primary");


    public void enterFirstName(String input) {
        findAndType(FIRST_NAME_INPUT_BOX, input);
    }

    public void enterLastName(String input) {
        findAndType(LAST_NAME_INPUT_BOX, input);
    }

    public void enterEmailAddress(String input) {
        findAndType(EMAIL_ADDRESS_INPUT_BOX, input);
    }

    public void enterPassword(String input) {
        findAndType(PASSWORD_INPUT_BOX, input);
    }

    public void clickSaveAccount() {
        waitAndClick(SAVE_NEW_ACCOUNT_BUTTON);
    }

    public void alreadyRegisteredAlertPresent() {
        WebElement alertBox = driver.findElement(ALREADY_REGISTERED_ALERT);
        Assert.assertTrue(elementIsVisible(alertBox));
    }


}
