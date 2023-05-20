package project.tests.testNg;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.driver.Driver;
import project.pages.page_google.Google;
import project.pages.page_school.School;
import project.utils.ActionsUtil;


public class SchoolNgTest {

    School school = new School();

    ActionsUtil actions = new ActionsUtil();

    Google google = new Google();

    public static final Logger LOGGER = Logger.getLogger(SchoolNgTest.class.getName());

    @BeforeMethod
    public void beforeTests() {
        LOGGER.info("The w3schools testNG Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The w3schools testNG Before method is finished");
    }

    @AfterMethod
    public void afterTests() {
        LOGGER.info("The w3schools testNG After method is started");
        Driver.closeDriver();
        LOGGER.info("The w3schools testNG After method is finished");
    }

    @Test
    public void tutorialTest() {
        school.getSchoolUrl();
        actions.selectingCopyElement(school.findTutorial());
        google.getGoogleUrl();
        actions.selectingPasteElement(google.findSearchField());
        Assert.assertEquals(google.displayedResultsCountContainsTutorial(), google.displayedResultsCount().size(), "Some links don't contain the 'Tutorial' word");
        LOGGER.debug("Test 'tutorialTest' is executed");
    }
}
