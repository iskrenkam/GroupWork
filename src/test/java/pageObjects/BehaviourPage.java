package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BehaviourPage extends BasePage{

    public BehaviourPage(WebDriver c) {super(c);}

    /**---------------------------------Trigger Statics---------------------------------------------------*/
    private static final By BEHAVIOUR_TYPE_DROPDOWN = By.cssSelector("[ng-model=\"form.trigger.selectedType\"]");
    private static final By XPATH_TEXT_BOX = By.cssSelector("input[name=\"xpath\"]");
    private static final By CARD_NUMBER_TEXT_BOX = By.cssSelector("input[name=\"number\"]");
    private static final By CARD_NAME_TEXT_BOX = By.cssSelector("input[name=\"name\"]");
    private static final By PENCE_AMOUNT_TEXT_BOX = By.cssSelector("input[name=\"pence\"]");
    private static final By TYPE_OF_REQUEST_DROPDOWN = By.cssSelector("[ng-model=\"argument.value\"]");

    private static final By TYPE_OF_REQUEST_LABEL = By.cssSelector("form[name=\"triggerForm\"] > p");


    /**---------Response Statics-------------------------------------------------------------------*/
    private static final By RESPONSE_TYPE_DROPDOWN = By.cssSelector("[ng-model=\"form.response.selectedType\"]");
    private static final By RESPONSE_DESCRIPTION_TEXTBOX = By.cssSelector("input[name=\"description\"]");
    private static final By RESPONSE_RESPONSE_TEXTBOX = By.cssSelector("input[name=\"response\"]");

    private static final By TYPE_OF_RESPONSE_LABEL = By.cssSelector("form[name=\"responseForm\"] > p");



    /**--------------Save/Cancel Statics ----------------------------*/
    private static final By SAVE_BUTTON = By.cssSelector("button#save-button");
    private static final By CANCEL_BUTTON = By.cssSelector("button#cancel-button");


    /**-------------------------------------------Trigger Methods -------------------------------------*/

    /**Select from 0-8 for the desired type of trigger
    0-Any
    1-XML|XPath
    2-Card Number
    3-Name on Card
    4-Pence
    5-
    Is an Auth request
    6-Verified Enroll Request
    7-
    Verify Sig Request
    8-Void Request*/
    public void selectFromTriggerType(String dropDownValue){
        selectValueFromDropDown(BEHAVIOUR_TYPE_DROPDOWN, dropDownValue);
    }

    /**depending on trigger chosen use one of the inputs below*/
    public void enterXPath(String input) {
        findAndType(XPATH_TEXT_BOX, input);
    }
    public void enterCardNumber(String input) {
        findAndType(CARD_NUMBER_TEXT_BOX, input);
    }
    public void enterCardName(String input) {
        findAndType(CARD_NAME_TEXT_BOX, input);
    }
    public void enterPenceAmount(String input) {
        findAndType(PENCE_AMOUNT_TEXT_BOX, input);
    }

    /** If using the card number, card name or pence triggers. You may additionally specify a type of request
    0-Any
    1-Auth
    2-3ds verify-enrolled
    3-3ds verify sig
    4-void*/
    public void selectFromRequestType(String dropDownValue){
        selectValueFromDropDown(TYPE_OF_REQUEST_DROPDOWN, dropDownValue);
    }

    public String getTriggerLabel(){
        return new String (driver.findElement(TYPE_OF_REQUEST_LABEL).getText());
    }


    /**---------------------- Response Methods ----------------------------------------------------------*/
    public void selectFromResponseType(String dropDownValue){
        selectValueFromDropDown(RESPONSE_TYPE_DROPDOWN, dropDownValue);
    }

    public void enterResponseDescription(String input) {
        findAndType(RESPONSE_DESCRIPTION_TEXTBOX, input);
    }
    public void enterTextResponse(String input) {
        findAndType(RESPONSE_RESPONSE_TEXTBOX, input);
    }

    public String getResponseLabel(){
        return new String (driver.findElement(TYPE_OF_RESPONSE_LABEL).getText());
    }



    /**------------Save/Cancel Button Methods--------------------------------*/
    public void clickSave(){
        waitAndClick(SAVE_BUTTON);
    }
    public void clickCancel(){
        waitAndClick(CANCEL_BUTTON);
    }

}
