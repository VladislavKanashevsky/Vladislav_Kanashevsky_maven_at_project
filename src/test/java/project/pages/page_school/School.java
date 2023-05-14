package project.pages.page_school;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

import java.util.logging.Logger;

public class School {

    WebDriver driver = Driver.getWebDriver();

    public static final String SCHOOL_URL = "https://www.w3schools.com/java/";

    public static final String TUTORIAL = "//span[text()='Tutorial']";

    public static final Logger LOGGER = Logger.getLogger(School.class.getName());

    public void getUrlSchool() {
        driver.get(SCHOOL_URL);
        LOGGER.info("Open https://www.w3schools.com/java/");

    }

    public WebElement findTutorial() {
        LOGGER.info("Find the 'Tutorial' word");
        return driver.findElement(By.xpath(TUTORIAL));
    }
}
