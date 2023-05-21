package project.pages.page_booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import project.driver.Driver;

import java.time.Duration;

public class HomePageBooking {

    WebDriver driver = Driver.getWebDriver();

    public final static String BOOKING = "https://booking.com";

    public final static String SKIP_MENU = "//button[@aria-label='Скрыть меню входа в аккаунт.']";

    public final static String PLACE_NAME = "[name='ss']";

    public final static String PLACE_NAME_CLICK = "//*[@data-testid='autocomplete-results']/li[1]/descendant:: div[contains(text(),'";

    public final static String DATA = "[data-date='";

    public final static String OCCUPANCY = "[data-testid='occupancy-config']";

    public final static String ADULTS = "//input[@id='group_adults']/following-sibling::div/button[2]";

    public final static String APARTMENT = "//input[@id='no_rooms']/following-sibling::div/button[2]";

    public final static String SUBMIT = "//button[@type='submit']";

    public final static String FIND_CURRENCY = "[data-testid='header-currency-picker-trigger']";

    public final static String FIND_LANGUAGE = "[data-testid='header-language-picker-trigger']";

    public final static String FIND_CURRENCY_POPUP = "//*[@id=':R2cl:']/div";

    public final static String FIND_LANGUAGE_POPUP = "//*[@id=':R2kl:']/div";

    public final static String REGISTRATION = "//*[@data-testid='header-sign-up-button']";

    public static final Logger LOGGER = Logger.getLogger(HomePageBooking.class.getName().getClass());

    public void getBookingUrl() {
        driver.get(BOOKING);
        LOGGER.trace("Open the https://booking.com");
    }

    public void skipSignInOffer() {
        driver.findElement(By.xpath(SKIP_MENU)).click();
        LOGGER.trace("Skip the SignIn offer popup");
    }

    public void selectPlace(String placeName) {
        driver.findElement(By.cssSelector(PLACE_NAME)).sendKeys(placeName);
        LOGGER.trace("Enter the city name");
        driver.findElement(By.xpath(PLACE_NAME_CLICK + placeName + "')]")).click();
        LOGGER.trace("Click on the city");
    }

    public void selectDate(String date) {
        driver.findElement(By.cssSelector(DATA + date + "']")).click();
        LOGGER.trace("Select date");
    }

    public void clickOnOccupancyDropdown() {
        driver.findElement((By.cssSelector(OCCUPANCY))).click();
        LOGGER.trace("Click on the Occupancy Dropdown");
    }

    public void clickOnTheAdults() {
        driver.findElement(By.xpath(ADULTS)).click();
        LOGGER.trace("Click on the Adults");
    }

    public void clickOnTheApartments() {
        driver.findElement(By.xpath(APARTMENT)).click();
        LOGGER.trace("Click on the Apartments");
    }

    public void clickOnTheSubmit() {
        driver.findElement(By.xpath(SUBMIT)).click();
        LOGGER.trace("Click on the submit button");
    }

    public WebElement findCurrency() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FIND_CURRENCY))
        );
        LOGGER.trace("Find the currency element");
        return driver.findElement(By.cssSelector(FIND_CURRENCY));
    }

    public WebElement findLanguage() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FIND_LANGUAGE))
        );
        LOGGER.trace("Find the language element");
        return driver.findElement(By.cssSelector(FIND_LANGUAGE));
    }

    public String getCurrencyTooltip() {
        LOGGER.trace("Find the tooltip value of the currency element");
        return driver.findElement(By.xpath(FIND_CURRENCY_POPUP)).getText();
    }

    public String getLanguageTooltip() {
        LOGGER.trace("Find the tooltip value of the language element");
        return driver.findElement(By.xpath(FIND_LANGUAGE_POPUP)).getText();
    }

    public void clickRegister() {
        driver.findElement(By.xpath(REGISTRATION)).click();
        LOGGER.trace("Click on the Register button");
    }
}