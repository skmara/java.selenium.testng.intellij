package Utilities;


import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class hooks {
    private WebDriver driver;
    private String scenarioName;
    private static ThreadLocal<String> currentStepName=new ThreadLocal<>();
@Before
public void setUP(Scenario scenario){
    driver=Utlity.getWebdriver();
    //Step step = null;
   // String b=step.getText().toString();
    scenarioName=scenario.getName().replaceAll(" ","_");
//    String a=scenario.toString();
//    currentStepName.set(scenario.getId().toString());

}
@BeforeStep
public void beforeStep(Scenario scenario){
    currentStepName.set(scenario.getSourceTagNames().toString());
}

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        //String stepname= currentStepName.get();
        Utlity.takeScreenshot(driver,scenarioName);
    }
   // @After
    //public void tearDown(){
    //Utlity.CleanUP();
    //}

}
