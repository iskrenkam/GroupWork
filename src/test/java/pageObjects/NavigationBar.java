package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationBar extends BasePage{

    public NavigationBar(WebDriver c) {super(c);}



    /**--------------HTML Link Statics--------------------------*/
    private static final By THE_TEST_PEOPLE_BRAND_BUTTON = By.cssSelector("a[href=\"http://thetestpeople.com/\"]");
    private static final By SERVICE_SIMULATION_MAIN_BANNER = By.cssSelector("a[href=\"#/\"]");
    private static final By CONFIG_BUTTON = By.cssSelector("a[href=\"#/config\"]");
    private static final By REPORTS_BUTTON = By.cssSelector("a[href=\"#/reports\"]");


    /**--------------UTILITY Statics--------------------------*/

    private static final By UTILS_DROPDOWN_TOGGLE = By.cssSelector("a.dropdown-toggle");
    private static final By CARD_GENERATOR_BUTTON = By.cssSelector("a#utils-link");
    private static final By CARD_GENERATOR_CARD_PROVIDER_DROPDOWN = By.cssSelector("select[name=\"cardProviderSelect\"]");
    private static final By CARD_GENERATOR_GENERATE_BUTTON = By.cssSelector("button#generate-button");
    private static final By CARD_GENERATOR_GENERATED_NUMBER = By.cssSelector("div.row > div.col-sm-9");
    private static final By CARD_GENERATOR_GENERATED_IMAGE = By.cssSelector("div.row > div.col-sm-9 > img");
    private static final By CARD_GENERATOR_COPY_TO_CLIPBOARD_BUTTON = By.cssSelector("button[clip-copy=\"cardNumber\"]");


    /**--------------HTML Link Methods-------------------------------------------------*/

    public void clickTheTestPeople(){
        waitAndClick(THE_TEST_PEOPLE_BRAND_BUTTON);
    }

    public void clickTheServiceSimulationMainBanner(){
        waitAndClick(SERVICE_SIMULATION_MAIN_BANNER);
    }

    public void clickConfigButton(){
        waitAndClick(CONFIG_BUTTON);
    }

    public void clickReportsButton(){
        waitAndClick(REPORTS_BUTTON);
    }

    /**--------------Utility Methods-----------------------------------------------------*/
    public void clickUtilitiesDropDown(){
        waitAndClick(UTILS_DROPDOWN_TOGGLE);
    }

    public void clickCardGenerator(){
        waitAndClick(CARD_GENERATOR_BUTTON);
    }

    public void selectCardProvider(String dropDownValue){
        selectValueFromDropDown(CARD_GENERATOR_CARD_PROVIDER_DROPDOWN, dropDownValue);
    }

    public void generateCardNumber(){
        waitAndClick(CARD_GENERATOR_GENERATE_BUTTON);
    }

    public String getGeneratedNumber(){
        return new String(driver.findElement(CARD_GENERATOR_GENERATED_NUMBER).getText());
    }

    public String getProviderGenerated(){
        return new String(driver.findElement(CARD_GENERATOR_GENERATED_IMAGE).getAttribute("src"));
    }

    public void clickCopyToClipBoard(){
        waitAndClick(CARD_GENERATOR_COPY_TO_CLIPBOARD_BUTTON);
    }


}
