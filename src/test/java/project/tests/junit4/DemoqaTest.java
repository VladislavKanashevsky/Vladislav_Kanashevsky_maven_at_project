package project.tests.junit4;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.driver.Driver;
import project.objects.SelectMenuItems;
import project.pages.page_demoqa.SelectMenuDemoqa;

public class DemoqaTest {

    SelectMenuDemoqa selectMenuDemoqa = new SelectMenuDemoqa();

    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoqaTest.class.getName());

    @Before
    public void beforeTests() {
        LOGGER.info("The demoqa junit Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The demoqa junit Before method is finished");
    }

    @After
    public void afterTests() {
        LOGGER.info("The demoqa junit After method is started");
        Driver.closeDriver();
        LOGGER.info("The demoqa junit After method is finished");
    }

    @Test
    public void selectTest() {
        selectMenuDemoqa.getUrlToSelectMenuDemoqa();
        selectMenuDemoqa.clickSelectValueDropdown();
        selectMenuItems.selectGroupOption();
        selectMenuDemoqa.clickSelectOneDropdown();
        selectMenuItems.selectDr();
        selectMenuItems.selectOfOldStyle();
        selectMenuDemoqa.clickMultiSelectDropdown();
        selectMenuItems.selectOfMulti();
        selectMenuItems.selectAudiOfStandardMulti();
        LOGGER.debug("Test 'selectTest' is executed");
    }
}