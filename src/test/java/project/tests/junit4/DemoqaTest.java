package project.tests.junit4;

import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import project.driver.Driver;
import project.objects.SelectMenuItems;
import project.pages.page_demoqa.SelectMenu;

public class DemoqaTest {

    SelectMenuItems selectMenuItems = new SelectMenuItems();

    SelectMenu selectMenu = new SelectMenu();

    @BeforeTest
    public void beforeTests() {
        Driver.getWebDriver();
    }

    @Test
    public void selectTest() {
        selectMenu.getUrlDemoqa();
        selectMenu.clickSelectValue();
        selectMenuItems.selectGroupOption();
        selectMenu.clickSelectOne();
        selectMenuItems.selectDr();
        selectMenuItems.selectColorOldSelectMenu();
        selectMenu.clickMultiSelect();
        selectMenuItems.selectColorDropdown();
        selectMenuItems.selectCars();
    }

    @AfterTest
    public void afterTests() {
        Driver.closeDriver();
    }
}
