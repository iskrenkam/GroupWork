package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }


    private static final By ACCOUNT_PAGE_AVAILABLE = By.cssSelector(".account .hidden-sm-down");

    private static final By SIGN_OUT_BUTTON = By.cssSelector(".user-info .logout");

    public void accountPageVisible() {
        WebElement alertBox = driver.findElement(ACCOUNT_PAGE_AVAILABLE);
        Assert.assertTrue(elementIsVisible(alertBox));
    }

    public void signOutFromCurrentAccount() {
        waitAndClick(SIGN_OUT_BUTTON);
    }


}
