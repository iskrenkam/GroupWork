package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigPage extends BasePage{

    public ConfigPage(WebDriver c) {super(c);}

    /**-------------Statics---------------------------*/
    private static final By SERVER_TYPE_DROPDOWN = By.cssSelector("[ng-model=\"serverTypeObj\"]");

    private static final By REALEX_SECRET_TEXT_INPUT = By.cssSelector("#realex.secret");

    private static final By CHANGE_SERVER_TYPE_BUTTON = By.cssSelector("#changeServerType");
    private static final By RESET_CONFIG_BUTTON = By.cssSelector("#reset-button");
    private static final By SAVE_BUTTON = By.cssSelector("button#save-button");
    private static final By CANCEL_BUTTON = By.cssSelector("button#cancel-button");

    /**---------------Methods-----------------------------*/


    /**two methods to choose from.
    0-Generic
    1-realex
     */
    public void chooseServerType(String dropDownValue){
        selectValueFromDropDown(SERVER_TYPE_DROPDOWN, dropDownValue);
    }

    public void enterRealexSecret(String input) {
        findAndType(REALEX_SECRET_TEXT_INPUT, input);
    }

    public String getRealexSecret(){
        return new String(driver.findElement(REALEX_SECRET_TEXT_INPUT).getText());
    }


    public void clickChangeServerType(){
        waitAndClick(CHANGE_SERVER_TYPE_BUTTON);
    }

    public void clickResetConfig(){
        waitAndClick(RESET_CONFIG_BUTTON);
    }

    public void clickSave(){
        waitAndClick(SAVE_BUTTON);
    }
    public void clickCancel(){
        waitAndClick(CANCEL_BUTTON);
    }

}
