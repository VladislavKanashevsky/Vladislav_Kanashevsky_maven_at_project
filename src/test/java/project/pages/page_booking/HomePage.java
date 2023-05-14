package project.pages.page_booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;
import project.driver.Driver;

public class HomePage {

    WebDriver driver = Driver.getWebDriver();

    public final static String BOOKING = "https://booking.com";

    public final static String SKIP_MENU = "//button[@aria-label='Скрыть меню входа в аккаунт.']";

    public final static String PLACE_NAME = "[name='ss']";

    public final static String PLACE_NAME_CLICK = "//*[@data-testid='autocomplete-results']/li[1]/descendant:: div[contains(text(),'";

    public final static String OCCUPANCY = "[data-testid='occupancy-config']";

    public final static String ADULTS = "//input[@id='group_adults']/following-sibling::div/button[2]";

    public final static String APARTMENT = "//input[@id='no_rooms']/following-sibling::div/button[2]";

    public final static String CLICK_SUBMIT = "//button[@type='submit']";

    public final static String FIND_CURRENCY = "[data-testid='header-currency-picker-trigger']";

    public final static String FIND_LANGUAGE = "[data-testid='header-language-picker-trigger']";

    public final static String FIND_CURRENCY_POPUP = "//*[@id=':R2cl:']/div";

    public final static String FIND_LANGUAGE_POPUP = "//*[@id=':R2kl:']/div";

    public final static String REGISTRATION = "//*[@data-testid='header-sign-up-button']";

    public static final Logger LOGGER = Logger.getLogger(HomePage.class.getName().getClass());

    public void getUrl() {
        driver.get(BOOKING);
        LOGGER.info("Open https://booking.com");
    }

    public void skipSign() {
        driver.findElement(By.xpath(SKIP_MENU)).click();
        LOGGER.info("Skip 'Скрыть меня входа в аккаунт'");
    }

    public void selectingPlace(String placeName) {
        driver.findElement(By.cssSelector(PLACE_NAME)).sendKeys(placeName);
        LOGGER.info("Enter the city name");
        driver.findElement(By.xpath(PLACE_NAME_CLICK + placeName + "')]")).click();
        LOGGER.info("Click on the city name");
    }

    public void selectingDate(String date) {
        driver.findElement(By.cssSelector("[data-date='" + date + "']")).click();
        LOGGER.info("Select date");
    }

    public void clickDropdown() {
        driver.findElement((By.cssSelector(OCCUPANCY))).click();
        LOGGER.info("Click on the Occupancy");
    }

    public void clickAdults() {
        driver.findElement(By.xpath(ADULTS)).click();
        LOGGER.info("Click on the Adults");
    }

    public void clickApartments() {
        driver.findElement(By.xpath(APARTMENT)).click();
        LOGGER.info("Click on the Apartments");
    }

    public void clickSubmit() {
        driver.findElement(By.xpath(CLICK_SUBMIT)).click();
        LOGGER.info("Click on the submit");
    }

    public WebElement findCurrency() {
        LOGGER.info("Find the currency element");
        return driver.findElement(By.cssSelector(FIND_CURRENCY));

    }

    public WebElement findLanguage() {
        LOGGER.info("Find the language element");
        return driver.findElement(By.cssSelector(FIND_LANGUAGE));
    }

    public String getCurrency() {
        LOGGER.info("Find currency popup");
        return driver.findElement(By.xpath(FIND_CURRENCY_POPUP)).getText();
    }

    public String getLanguage() {
        LOGGER.info("Find language popup");
        return driver.findElement(By.xpath(FIND_LANGUAGE_POPUP)).getText();
    }

    public void clickRegistration() {
        driver.findElement(By.xpath(REGISTRATION)).click();
        LOGGER.info("Click on the registration");
    }
}