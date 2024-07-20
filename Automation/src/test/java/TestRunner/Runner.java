package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/Home.feature",
        glue = {"StepDefinitions","Utilities"},
        tags = "@Fail",
        plugin = {"pretty","html:target/cucumber-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {

}

