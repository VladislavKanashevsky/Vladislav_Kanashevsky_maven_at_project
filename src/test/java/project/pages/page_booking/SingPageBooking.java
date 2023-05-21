package project.pages.page_booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

import org.apache.log4j.Logger;

public class SingPageBooking {

    WebDriver driver = Driver.getWebDriver();

    public static final String USERNAME = "username";

    public static final String SUBMIT = "//button[@type='submit']";

    public static final String NEW_PASSWORD = "new_password";

    public static final String CONFIRMED_PASSWORD = "confirmed_password";

    public static final String CAPTCHA = "//div[@aria-label='Нажать и удерживать']";

    public static final Logger LOGGER = Logger.getLogger(SingPageBooking.class.getName());

    public void enterEmail(String myEmail) {
        driver.findElement(By.id(USERNAME)).sendKeys(myEmail);
        LOGGER.trace("Enter the '" + myEmail + "' to the eamil field");
        driver.findElement(By.xpath(SUBMIT)).click();
        LOGGER.trace("Click on the submit button");
    }

    public void clickSubmit() {
        driver.findElement(By.xpath(SUBMIT)).click();
        LOGGER.trace("Click on the submit button");
    }

    public void enterPassword(String password) {
        driver.findElement(By.id(NEW_PASSWORD)).sendKeys(password);
        LOGGER.trace("Enter the '" + password + "' to the new password field");
        driver.findElement(By.id(CONFIRMED_PASSWORD)).sendKeys(password);
        LOGGER.trace("Enter the '" + password + "' to the confirm password field");
        driver.findElement(By.xpath(SUBMIT)).click();
        LOGGER.trace("Click on the submit button");
    }

    public WebElement getCaptcha() {
        LOGGER.trace("Trying to get the captcha");
        return driver.findElement(By.xpath(CAPTCHA));
    }
}

