package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotYourPassword extends BasePage {

    public ForgotYourPassword(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_ADDRESS_INPUT_BOX = By.cssSelector("input[name=\"email\"]");
    private static final By SEND_RESET_LINK_BUTTON = By.cssSelector(".form-group button[type=\"submit\"]");

    private static final By CONFIRMATION_MESSAGE = By.cssSelector(".ps-alert-error");

    public void enterEmail(String input) {
        findAndType(EMAIL_ADDRESS_INPUT_BOX, input);
    }

    public void clickSendResetLink() {
        waitAndClick(SEND_RESET_LINK_BUTTON);
    }

    public void confirmationMessageDisplayed() {
        WebElement alertBox = driver.findElement(CONFIRMATION_MESSAGE);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

}
