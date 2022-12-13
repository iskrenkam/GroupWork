package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SSFHomePage extends BasePage{

    public SSFHomePage(WebDriver c) {super(c);}



    /**--------------Behaviours Table Statics----------------------------------*/
    private static final By FIRST_BEHAVIOUR_IN_TABLE_DRAG_HANDLE = By.cssSelector("#behaviours tr:first-child [name=\"drag-row-handle\"]");
    private static final By FIRST_BEHAVIOUR_IN_TABLE_TRIGGER_LABEL = By.cssSelector("tr:first-child .trigger_cell");
    private static final By FIRST_BEHAVIOUR_IN_TABLE_RESPONSE_LABEL = By.cssSelector("tr:first-child .response_cell");
    private static final By FIRST_BEHAVIOUR_IN_TABLE = By.cssSelector("tbody#behaviours tr:first-child");
    private static final By SECOND_BEHAVIOUR_IN_TABLE = By.cssSelector("tbody#behaviours tr:nth-child(2)");
    private static final By SECOND_BEHAVIOUR_IN_TABLE_DRAG_HANDLE = By.cssSelector("#behaviours tr:nth-child(2) [name=\"drag-row-handle\"]");


    /**------------------------Behaviour Button Statics-------------------------------------*/
    private static final By NEW_BEHAVIOUR_BUTTON = By.cssSelector("#new-behaviour-button");
    private static final By DELETE_BEHAVIOUR_BUTTON = By.cssSelector("#delete-behaviour-button");
    private static final By CONFIGURE_BEHAVIOUR_BUTTON = By.cssSelector("#configure-behaviour-button");
    private static final By INCREASE_PRIORITY_BEHAVIOUR_BUTTON = By.cssSelector("#increase-priority-button");
    private static final By DECREASE_PRIORITY_BEHAVIOUR_BUTTON = By.cssSelector("#decrease-priority-button");

    /**------------------------Other Statics-------------------------------------*/
    private static final By DELETE_BEHAVIOUR_CONFIRMATION_OK = By.cssSelector("[data-bb-handler=\"confirm\"]");
    private static final By DELETE_BEHAVIOUR_CONFIRMATION_CANCEL = By.cssSelector("[data-bb-handler=\"cancel\"]");

    /**----------------------- VOID Methods------------------------------------------------------*/
    public void clickNewBehaviour(){
        waitAndClick(NEW_BEHAVIOUR_BUTTON);
    }
    public void clickDeleteBehaviour(){
        waitAndClick(DELETE_BEHAVIOUR_BUTTON);
    }

    public void clickConfigureBehaviour(){
        waitAndClick(CONFIGURE_BEHAVIOUR_BUTTON);
    }

    public void clickIncreasePriorityBehaviour(){
        waitAndClick(INCREASE_PRIORITY_BEHAVIOUR_BUTTON);
    }

    public void clickDecreasePriorityBehaviour(){
        waitAndClick(DECREASE_PRIORITY_BEHAVIOUR_BUTTON);
    }
    public void clickFirstBehaviour(){waitAndClick(FIRST_BEHAVIOUR_IN_TABLE);}
    public void clickSecondBehaviour(){waitAndClick(SECOND_BEHAVIOUR_IN_TABLE);}
    public void clickOKInDeleteConfirmation(){waitAndClick(DELETE_BEHAVIOUR_CONFIRMATION_OK);}
    public void clickCancelInDeleteConfirmation(){waitAndClick(DELETE_BEHAVIOUR_CONFIRMATION_CANCEL);}

    /**----------------------- Return Methods------------------------------------------------------*/
    public String getFirstBehaviourTriggerLabel(){
        return new String (driver.findElement(FIRST_BEHAVIOUR_IN_TABLE_TRIGGER_LABEL).getText());
    }
    public String getFirstBehaviourResponseLabel(){
        return new String (driver.findElement(FIRST_BEHAVIOUR_IN_TABLE_RESPONSE_LABEL).getText());
    }
    public String getFirstBehaviourID(){
        return new String (driver.findElement(FIRST_BEHAVIOUR_IN_TABLE).getAttribute("id"));
    }

    public String getSecondBehaviourID(){
        return new String (driver.findElement(SECOND_BEHAVIOUR_IN_TABLE).getAttribute("id"));
    }

    /** Drag and Drop method*/
    public void dragAnElementToAnotherElement(){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FIRST_BEHAVIOUR_IN_TABLE_DRAG_HANDLE));

        WebElement fromElement = driver.findElement(SECOND_BEHAVIOUR_IN_TABLE_DRAG_HANDLE);
        WebElement toElement = driver.findElement(NEW_BEHAVIOUR_BUTTON);
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(fromElement).moveToElement(toElement).pause(Duration.ofSeconds(1)).release(toElement).build();
        dragAndDrop.perform();
    }
}
