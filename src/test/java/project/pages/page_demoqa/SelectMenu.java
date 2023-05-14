package project.pages.page_demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;
import project.pages.page_booking.SingPage;

import java.util.logging.Logger;

public class SelectMenu {

    WebDriver driver = Driver.getWebDriver();

    public static final String DEMOQA_URL = "https://demoqa.com/select-menu";

    public static final String WITH_OPT_GROUP = "withOptGroup";

    public static final String SELECT_ONE = "selectOne";

    public static final String MULTI_SELECT = "//div[text()='Select...']/..";

    public static final Logger LOGGER = Logger.getLogger(SelectMenu.class.getName());

    public void getUrlDemoqa() {
        driver.get(DEMOQA_URL);
        LOGGER.info("Open the https://demoqa.com/select-menu");
    }

    public void clickSelectValue() {
        driver.findElement(By.id(WITH_OPT_GROUP)).click();
        LOGGER.info("Click on the Select Value");
    }

    public void clickSelectOne() {
        driver.findElement(By.id(SELECT_ONE)).click();
        LOGGER.info("Click on the Select One");
    }

    public void clickMultiSelect() {
        driver.findElement(By.xpath(MULTI_SELECT)).click();
        LOGGER.info("Click on the MultiSelect Dropdown");
    }
}
