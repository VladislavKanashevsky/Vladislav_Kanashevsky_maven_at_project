package project.tests.testNg;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import project.driver.Driver;
import project.objects.SelectMenuItems;
import project.pages.page_demoqa.SelectMenuDemoqa;

public class DemoqaNgTest {

    SelectMenuDemoqa selectMenuDemoqa = new SelectMenuDemoqa();
    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoqaNgTest.class.getName());

    @BeforeMethod
    public void beforeTests() {
        LOGGER.info("The demoqa testNg Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The demoqa testNg Before method is finished");
    }

    @AfterMethod
    public void afterTests() {
        LOGGER.info("The demoqa testNg After method is started");
        Driver.closeDriver();
        LOGGER.info("The demoqa testNg After method is finished");
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
