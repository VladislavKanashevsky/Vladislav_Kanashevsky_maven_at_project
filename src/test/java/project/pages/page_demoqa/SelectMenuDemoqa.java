package project.pages.page_demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import org.apache.log4j.Logger;

public class SelectMenuDemoqa {

    WebDriver driver = Driver.getWebDriver();

    public static final String DEMOQA_URL = "https://demoqa.com/select-menu";

    public static final String WITH_OPT_GROUP = "withOptGroup";

    public static final String SELECT_ONE = "selectOne";

    public static final String MULTI_SELECT_DROP_DOWN = "//*[@id='react-select-4-input']/../../..";

    public static final Logger LOGGER = Logger.getLogger(SelectMenuDemoqa.class.getName());

    public void getUrlToSelectMenuDemoqa() {
        driver.get(DEMOQA_URL);
        LOGGER.trace("Open the https://demoqa.com/select-menu");
    }

    public void clickSelectValueDropdown() {
        driver.findElement(By.id(WITH_OPT_GROUP)).click();
        LOGGER.trace("Click on the SelectValue Dropdown");
    }

    public void clickSelectOneDropdown() {
        driver.findElement(By.id(SELECT_ONE)).click();
        LOGGER.trace("Click on the SelectOne Dropdown");
    }

    public void clickMultiSelectDropdown() {
        driver.findElement(By.xpath(MULTI_SELECT_DROP_DOWN)).click();
        LOGGER.trace("Click on the MultiSelect Dropdown");
    }
}
