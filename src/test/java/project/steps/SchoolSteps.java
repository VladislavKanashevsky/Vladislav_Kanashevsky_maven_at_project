package project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import project.driver.Driver;
import project.pages.page_google.Google;
import project.pages.page_school.School;
import project.utils.ActionsUtil;

public class SchoolSteps {

    School school = new School();

    ActionsUtil actions = new ActionsUtil();

    Google google = new Google();

    public static final Logger LOGGER = Logger.getLogger(SchoolSteps.class.getName());

    @Before(value = "@school")
    public void beforeTests() {
        LOGGER.info("The school cucumber Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The school cucumber Before method is finished");
    }

    @After(value = "@school")
    public void afterTests() {
        LOGGER.info("The school cucumber After method is started");
        Driver.closeDriver();
        LOGGER.info("The school cucumber After method is finished");
    }

    @Given("I open the \"school.com\"")
    public void openSchool() {
        school.getSchoolUrl();
        LOGGER.debug("Step 'I open the \"school.com\"' is executed");
    }

    @When("I copy \"Tutorial\" word")
    public void copyTutorial() {
        actions.selectingCopyElement(school.findTutorial());
        LOGGER.debug("Step 'I copy \"Tutorial\" word' is executed");
    }

    @When("I open the \"google.com\"")
    public void openGoogle() {
        google.getGoogleUrl();
        LOGGER.debug("Step 'I open the \"google.com\"' is executed");
    }

    @When("I paste \"Tutorial\" to the search field and click the Enter")
    public void pasteTutorial() {
        actions.selectingPasteElement(google.findSearchField());
        LOGGER.debug("Step 'I paste \"Tutorial\" to the search field and click the Enter' is executed");
    }

    @Then("I check that all result links contain the word \"Tutorial\"")
    public void checkResults() {
        Assert.assertEquals("Some links don't contain the 'Tutorial' word", google.displayedResultsCount().size(),
                google.displayedResultsCountContainsTutorial());
        LOGGER.debug("Step 'I check that all result links contain the word \"Tutorial\"' is executed");
    }
}
