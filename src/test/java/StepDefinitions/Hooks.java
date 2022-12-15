package StepDefinitions;

import Util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    public static DriverFactory driverFactory = new Util.DriverFactory();

    @Before
    public void before(){
        System.out.println("Starting Test");
    }
   @After
    public void after(){
        driverFactory.close();
    }
}
