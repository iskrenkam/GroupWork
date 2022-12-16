package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created by jack.forman on 16/10/2016.
 */
public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitAndClick(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    public boolean elementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    void findAndType(By elementSelector, String inputString) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        element = driver.findElement(elementSelector);
        element.click();
        element.sendKeys(inputString);
    }

    public void selectValueFromDropDown(By selector, String dropDownValue) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select dropDown = new Select(driver.findElement(selector));
        dropDown.selectByValue(dropDownValue);
    }


}
