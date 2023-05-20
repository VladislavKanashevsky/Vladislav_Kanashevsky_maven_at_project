package project.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import project.driver.Driver;

import org.apache.log4j.Logger;

public class SelectMenuItems {

    WebDriver driver = Driver.getWebDriver();

    public static final String REACT_SELECT_2_OPTION_0_0 = "react-select-2-option-0-0";

    public static final String REACT_SELECT_3_OPTION_0_0 = "react-select-3-option-0-0";

    public static final String OLD_SELECT_MENU = "oldSelectMenu";

    public static final String REACT_SELECT_4_OPTION_0_0 = "react-select-4-option-0";

    public static final String CARS = "cars";

    public static final Logger LOGGER = Logger.getLogger(SelectMenuItems.class.getName());

    public void selectGroup1Option1OfSelectValue() {
        driver.findElement(By.id(REACT_SELECT_2_OPTION_0_0)).click();
        LOGGER.trace("Click on the Group1Option1O");
    }

    public void selectDrOfSelectOne() {
        driver.findElement(By.id(REACT_SELECT_3_OPTION_0_0)).click();
        LOGGER.trace("Click on the Dr");
    }

    public void selectBlueOfOldStyleSelectMenu() {
        new Select(driver.findElement(By.id(OLD_SELECT_MENU))).selectByValue("1");
        LOGGER.trace("Click on the Blue");
    }

    public void selectGreenOfMultiSelectDropdown() {
        driver.findElement(By.id(REACT_SELECT_4_OPTION_0_0)).click();
        LOGGER.trace("Click on the Green");
    }

    public void selectAudiOfStandardMultiSelect() {
        new Select(driver.findElement(By.id(CARS))).selectByValue("audi");
        LOGGER.trace("Click on the Audi");
    }
}
