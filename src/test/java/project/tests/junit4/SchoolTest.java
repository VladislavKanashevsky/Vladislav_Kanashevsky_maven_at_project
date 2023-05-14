package project.tests.junit4;

import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import project.driver.Driver;
import project.pages.page_google.Google;
import project.pages.page_school.School;
import project.utils.ActionsUtil;

public class SchoolTest {

    School school = new School();

    ActionsUtil actionsUtil = new ActionsUtil();

    Google google = new Google();

    @BeforeTest
    public void beforeTests() {
        Driver.getWebDriver();
    }

    @Test
    public void tutorialTest() {
        school.getUrlSchool();
        actionsUtil.selectingCopyElement(school.findTutorial());
        google.getGoogleUrl();
        actionsUtil.selectingPasteElement(google.findSearch());
        google.displayResult();
    }

    @AfterTest
    public void afterTests() {
        Driver.closeDriver();
    }
}
