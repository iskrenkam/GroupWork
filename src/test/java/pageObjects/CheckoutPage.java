package pageObjects;

import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private static String URL = "http://3.11.77.136/index.php?controller=cart&action=show";

    public void navigateToCheckout (){
        driver.get(URL);
    }
}
