package env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
    public static long DEFAULT_WAIT = 20;

    protected static WebDriver driver;

    public static WebDriver getDefaultDriver() {
        if (driver != null) {
            return driver;
        }
        driver = new ChromeDriver();
        return driver;
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}

