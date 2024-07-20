package StepDefinitions;

import PageObjectModel.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.v85.runtime.model.StackTraceId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    LoginPage loginPage=new LoginPage();

    @Given("The user Launch the url {string}")
    public void theUserLaunchTheUrl(String url) {
        System.out.println("Launch the url");
        loginPage.LaunchUrl(url);
    }
    @Then("I Verify The Expected title is {string}")
    public void iVerifyTheExpectedTitleIs(String extitle) {
       String actualTitle = loginPage.getTitle();
       Assert.assertNotEquals(actualTitle,extitle);
    }

    @Then("I Verify The Expected title is not {string}")
    public void iVerifyTheExpectedTitleIsNot(String extitle) {
        String actualTitle = loginPage.getTitle();
        Assert.assertNotEquals(actualTitle,extitle);
    }

    @When("User Click on open position")
    public void userClickOnOpenPosition() {
        loginPage.ClickonOpenPosition();
    }

    @Then("I Verify The button is Clicked")
    public void iVerifyTheButtonIsClicked() {
        Assert.assertTrue(loginPage.IsWhatsyourPassionVisible());
    }

    @Then("I Verify The catogories or present {string}")
    public void iVerifyTheCatogoriesOrPresent(String catogory) {
        String[] catogories=catogory.split(",");
        for(String catogoryname:catogories){
        Assert.assertTrue(loginPage.IscatogoryPresent(catogoryname));
    }
}

    @And("I click on the {string} Catagory")
    public void iiClickOnTheCatagory(String name ) {
        loginPage.ClickCatogory(name);
    }

    @Then("I Verify user moved to new tab with the title of {string}")
    public void iVerifyUserMovedToNewTabWithTheTitleOf(String title) {
        loginPage.SwitchtoWindow(title);
        Assert.assertEquals(loginPage.getTitle(),title);
    }

    @When("I Click on {string}")
    public void iClickOn(String btnname) {
        loginPage.Clickopenings(btnname);
    }

    @And("I Click on Remote Jobs")
    public void iClickOnRemoteJobs() {
        loginPage.ClickRemoteJobs();
    }

    @And("I Click on apply now button")
    public void iClickOnApplyNowButton() {
        loginPage.ClickApplyNow();
    }

    @When("I fill the form")
    public void iFillTheForm() {

    }

    @When("I click on submit button")
    public void iClickOnSubmitButton() {
        loginPage.ClickSubmitNow();
    }

    @Then("I verify the Error message for {string}")
    public void iVerifyTheErrorMessageFor(String listFields) {
        String[] fields=listFields.split(",");
        for(String field:fields){
            Assert.assertTrue(loginPage.IsErrorPresent(field));
        }

    }

    @Then("I verify {string} error")
    public void iVerifyError(String error) {
        loginPage.Is404ErrorPresent(error);
    }
}
