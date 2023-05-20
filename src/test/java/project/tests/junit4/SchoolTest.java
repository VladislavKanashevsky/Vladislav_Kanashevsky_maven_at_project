package project.tests.junit4;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project.driver.Driver;
import project.pages.page_google.Google;
import project.pages.page_school.School;
import project.utils.ActionsUtil;

public class SchoolTest {

    School school = new School();

    ActionsUtil actions = new ActionsUtil();

    Google google = new Google();

    public static final Logger LOGGER = Logger.getLogger(SchoolTest.class.getName());

    @Before
    public void beforeTests() {
        LOGGER.info("The School junit Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The School junit Before method is finished");
    }

    @After
    public void afterTests() {
        LOGGER.info("The School junit After method is started");
        Driver.closeDriver();
        LOGGER.info("The School junit After method is finished");
    }

    @Test
    public void tutorialTest() {
        school.getSchoolUrl();
        actions.selectingCopyElement(school.findTutorial());
        google.getGoogleUrl();
        actions.selectingPasteElement(google.findSearchField());
        Assert.assertEquals("Some links don't contain the 'Tutorial' word", google.displayedResultsCount().size(),
                google.displayedResultsCountContainsTutorial());
        LOGGER.debug("Test 'tutorialTest' is executed");
    }
}