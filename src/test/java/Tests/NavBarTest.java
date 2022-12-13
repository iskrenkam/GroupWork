package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.BehaviourPage;
import pageObjects.NavigationBar;
import pageObjects.SSFHomePage;

public class NavBarTest {

    public static WebDriver driver;

    private SSFHomePage homepage = new SSFHomePage(driver);
    private BehaviourPage behaviourPage = new BehaviourPage(driver);
    private NavigationBar navBar = new NavigationBar(driver);

    @BeforeClass
    public static void globalBefore() {

        driver = WebDriverManager.chromedriver().create();

    }

    @Before
    public void testBefore() {
        driver.get("http://3.10.14.53:8080/#/");
    }

    @Test
    public void navigateToTheTestPeople() {
        navBar.clickTheTestPeople();
        String expectedURL = "https://ten10.com/";
        driver.get(expectedURL);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void navigateToMainPage() {
        homepage.clickNewBehaviour();
        navBar.clickTheServiceSimulationMainBanner();
        String expectedURL = "http://3.10.14.53:8080/#/";
        driver.get(expectedURL);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void navigateToConfigPage() {
        navBar.clickConfigButton();
        String expectedURL = "http://3.10.14.53:8080/#/config/";
        driver.get(expectedURL);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void navigateToReportsPage() {
        navBar.clickReportsButton();
        String expectedURL = "http://3.10.14.53:8080/#/reports/";
        driver.get(expectedURL);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void chooseAndGenerateACardNumber() {
        navBar.clickUtilitiesDropDown();
        navBar.clickCardGenerator();
        navBar.selectCardProvider("1");
        navBar.generateCardNumber();
        String expectedImg = "maestro.png";
        Assert.assertTrue(navBar.getProviderGenerated().contains(expectedImg));
    }


}
