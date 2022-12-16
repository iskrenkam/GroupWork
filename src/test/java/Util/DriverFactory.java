package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void close() {
        driver.quit();
    }

    public void quitDriver() {

        driver.quit();
        driver = null;
    }

}
