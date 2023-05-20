package project.pages.page_school;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

import org.apache.log4j.Logger;

public class School {

    WebDriver driver = Driver.getWebDriver();

    public static final String SCHOOL_URL = "https://www.w3schools.com/java/";

    public static final String TUTORIAL = "//span[text()='Tutorial']";

    public static final Logger LOGGER = Logger.getLogger(School.class.getName());

    public void getSchoolUrl() {
        driver.get(SCHOOL_URL);
        LOGGER.trace("Open the https://www.w3schools.com/java/");
    }

    public WebElement findTutorial() {
        LOGGER.trace("Find the 'Tutorial' word");
        return driver.findElement(By.xpath(TUTORIAL));
    }
}
