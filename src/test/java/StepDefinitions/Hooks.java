package StepDefinitions;

import Util.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;


public class Hooks {

    public static DriverFactory driverFactory = new Util.DriverFactory();

    @Before
    public void before(){
        System.out.println("Starting Test");
        driverFactory.getDriver();
    }
    @After
    public void after(){
        driverFactory.quitDriver();
    }

}
