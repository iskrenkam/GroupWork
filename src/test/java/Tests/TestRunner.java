package Tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions"},
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/Cucumber-reports/cucumber-test-results.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner {
}
