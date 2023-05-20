package project.tests.testNg;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import project.driver.Driver;
import project.objects.SelectMenuItems;
import project.pages.page_demoqa.SelectMenu;

public class DemoqaNgTest {

    SelectMenu selectMenu = new SelectMenu();
    SelectMenuItems selectMenuItems = new SelectMenuItems();

    public static final Logger LOGGER = Logger.getLogger(DemoqaNgTest.class.getName());

    @BeforeMethod
    public void beforeTests() {
        LOGGER.info("The demoQA testNG Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The demoQA testNG Before method is finished");
    }

    @AfterMethod
    public void afterTests() {
        LOGGER.info("The demoQA testNG After method is started");
        Driver.closeDriver();
        LOGGER.info("The demoQA testNG After method is finished");
    }

    @Test
    public void selectTest() {
        selectMenu.getUrlToSelectMenu();
        selectMenu.clickSelectValueDropdown();
        selectMenuItems.selectGroup1Option1OfSelectValue();
        selectMenu.clickSelectOneDropdown();
        selectMenuItems.selectDrOfSelectOne();
        selectMenuItems.selectBlueOfOldStyleSelectMenu();
        selectMenu.clickMultiSelectDropdown();
        selectMenuItems.selectGreenOfMultiSelectDropdown();
        selectMenuItems.selectAudiOfStandardMultiSelect();
        LOGGER.debug("Test 'selectTest' is executed");
    }
}
