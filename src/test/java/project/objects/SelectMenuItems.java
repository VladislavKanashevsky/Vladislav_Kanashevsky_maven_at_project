package project.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import project.driver.Driver;

import java.util.logging.Logger;

public class SelectMenuItems {

    WebDriver driver = Driver.getWebDriver();

    public static final String REACT_SELECT_2_OPTION_0_0 = "react-select-2-option-0-0";

    public static final String REACT_SELECT_3_OPTION_0_0 = "react-select-3-option-0-0";

    public static final String OLD_SELECT_MENU = "oldSelectMenu";

    public static final String REACT_SELECT_4_OPTION_0_0 = "react-select-4-option-0";

    public static final String CARS = "cars";

    public static final Logger LOGGER = Logger.getLogger(SelectMenuItems.class.getName());

    public void selectGroupOption() {
        driver.findElement(By.id(REACT_SELECT_2_OPTION_0_0)).click();
        LOGGER.info("Click on the Group Option");
    }

    public void selectDr() {
        driver.findElement(By.id(REACT_SELECT_3_OPTION_0_0)).click();
        LOGGER.info("Click on the Dr");
    }

    public void selectColorOldSelectMenu() {
        new Select(driver.findElement(By.id(OLD_SELECT_MENU))).selectByValue("2");
        LOGGER.info("Click on the Green, value = '2'");
    }

    public void selectColorDropdown() {
        driver.findElement(By.id(REACT_SELECT_4_OPTION_0_0)).click();
        LOGGER.info("Click on the Green");
    }

    public void selectCars() {
        new Select(driver.findElement(By.id(CARS))).selectByValue("Volvo");
        LOGGER.info("Click on the Volvo");
    }
}
