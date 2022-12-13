package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageObjects.BehaviourPage;
import pageObjects.SSFHomePage;

import java.time.Duration;


public class BehaviourTest {

    public static WebDriver driver;

    private SSFHomePage homepage = new SSFHomePage(driver);
    private BehaviourPage behaviourPage = new BehaviourPage(driver);


    @BeforeClass
    public static void globalBefore() {

           driver = WebDriverManager.chromedriver().create();

    }

    @Before
    public void testBefore() {
        driver.get("http://3.10.14.53:8080/#/");
    }



    @Test
    public void navigateToNewBehaviourPage() {
        homepage.clickNewBehaviour();
        String expectedURL = "http://3.10.14.53:8080/#/behaviour/new";
        driver.get(expectedURL);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void navigateToConfigureBehaviourPage() {
        homepage.clickFirstBehaviour();
        String id = homepage.getFirstBehaviourID();
        homepage.clickConfigureBehaviour();
        String expectedURL = "http://3.10.14.53:8080/#/behaviour/"+id;
        driver.get(expectedURL);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void createNewBehaviour(){

        homepage.clickNewBehaviour();

        behaviourPage.selectFromTriggerType("0");
        String triggerTxt = behaviourPage.getTriggerLabel();
        behaviourPage.selectFromResponseType("10");
        String responseTxt = behaviourPage.getResponseLabel();
        behaviourPage.clickSave();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Assert.assertTrue(triggerTxt.equalsIgnoreCase(homepage.getFirstBehaviourTriggerLabel().toLowerCase()));
        //Assert.assertTrue(responseTxt.equalsIgnoreCase(homepage.getResponseLabel().toLowerCase()));
    }

    @Test
    public void configureBehaviour(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String id = homepage.getFirstBehaviourID();
        String trigger = homepage.getFirstBehaviourTriggerLabel();
        homepage.clickFirstBehaviour();
        homepage.clickConfigureBehaviour();

        behaviourPage.selectFromTriggerType("5");
        //String triggerTxt = "Is an Auth request";
        behaviourPage.clickSave();

        homepage.clickFirstBehaviour();
        String newid = homepage.getFirstBehaviourID();
        String newTrigger = homepage.getFirstBehaviourTriggerLabel();

        Assert.assertTrue(id.equalsIgnoreCase(newid));
        //Assert.assertTrue(triggerTxt.equalsIgnoreCase(newTrigger));
        Assert.assertFalse(trigger.equalsIgnoreCase(newTrigger));
    }

    @Test
    public void deleteBehaviour(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String id = homepage.getFirstBehaviourID();
        homepage.clickFirstBehaviour();
        homepage.clickDeleteBehaviour();
        homepage.clickOKInDeleteConfirmation();
        homepage.clickFirstBehaviour();
        String newid = homepage.getFirstBehaviourID();
        Assert.assertFalse(id.equalsIgnoreCase(newid));
    }

    @Test
    public void increasePriorityUsingButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String idFirst = homepage.getFirstBehaviourID();
        String idSecond = homepage.getSecondBehaviourID();


        homepage.clickSecondBehaviour();
        homepage.clickIncreasePriorityBehaviour();
        homepage.clickFirstBehaviour();
        Assert.assertTrue(idSecond.equalsIgnoreCase(homepage.getFirstBehaviourID()));
        Assert.assertTrue(idFirst.equalsIgnoreCase(homepage.getSecondBehaviourID()));
    }

    @Test
    public void decreasePriorityUsingButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String idFirst = homepage.getFirstBehaviourID();
        String idSecond = homepage.getSecondBehaviourID();


        homepage.clickFirstBehaviour();
        homepage.clickDecreasePriorityBehaviour();
        homepage.clickFirstBehaviour();
        Assert.assertTrue(idSecond.equalsIgnoreCase(homepage.getFirstBehaviourID()));
        Assert.assertTrue(idFirst.equalsIgnoreCase(homepage.getSecondBehaviourID()));
    }
    @Test
    public void dragAndDropFirstToSecond(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String idFirst = homepage.getFirstBehaviourID();
        String idSecond = homepage.getSecondBehaviourID();


        homepage.clickFirstBehaviour();
        homepage.dragAnElementToAnotherElement();
        homepage.clickFirstBehaviour();
        Assert.assertTrue(idSecond.equalsIgnoreCase(homepage.getFirstBehaviourID()));
        Assert.assertTrue(idFirst.equalsIgnoreCase(homepage.getSecondBehaviourID()));
    }







}
