package project.pages.page_booking;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class ResultsPage {

    WebDriver driver = Driver.getWebDriver();

    public static final String MAX_PRICE_NIGHT_FLAG = "//*[@id='filter_group_pri_:Rcq:']/div/div[@data-filters-item='pri:pri=5']//descendant::%s";

    public static final String MAX_PRICE_NIGHT_SCROLL = "//*[@id='filter_group_price_:Rcq:']//descendant::div[@data-testid='filters-group-histogram']//following-sibling::div/div/%s";

    public static final String SPINNER = "[data-testid='overlay-spinner']";

    public static final String SORT_DROP_DOWN = "[data-testid='sorters-dropdown-trigger']";

    public static final String SORT_PRICE = "[data-id='price']";

    public static final String ASSERT_PRICE_NIGHT = "//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']";

    public static final String FIND_HOTEL = "//*[@data-testid='property-card']";

    public static final String MAX_RATING = "//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label/span[2]";

    public static final String GET_NUMBER_RATING = "//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label//div[@data-testid='filters-group-label-content']";

    public static final String FIRST_HOTEL_URL = "//*[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='title']/..";

    public static final Logger LOGGER = Logger.getLogger(ResultsPage.class.getName());

    public void waitSpinner() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(SPINNER))
        );
        LOGGER.info("Wait for spinner");
    }

    public void clickSortingDropDown() {
        driver.findElement(By.cssSelector(SORT_DROP_DOWN)).click();
        LOGGER.info("Click on the Sorting dropdown");
    }

    public void clickSortingPrice() {
        driver.findElement(By.cssSelector(SORT_PRICE)).click();
        LOGGER.info("Click on the price sorting");
    }

    public void assertPriceNight() {
        int hotelPriceNight = Integer.parseInt(driver.findElement(By.xpath(ASSERT_PRICE_NIGHT)).getText().replaceAll("[^0-9]", "")) / 7;
        int filterPriceNight;
        try {
            filterPriceNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_NIGHT_FLAG, "div[@data-testid='filters-group-label-content']"))).getText().replaceAll("[^0-9]", ""));
        } catch (NoSuchElementException e) {
            filterPriceNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_NIGHT_SCROLL, "input[1]"))).getAttribute("value"));
        }
        Assert.assertTrue("The price per night is more than filter price", hotelPriceNight >= filterPriceNight);
        LOGGER.info("Check the hotel price night and the filters price night");
    }

    public List<WebElement> findHotel() {
        LOGGER.info("Find the hotels");
        return driver.findElements(By.xpath(FIND_HOTEL));
    }

    public WebElement findHotels(int numberOfHotel) {
        LOGGER.info("Find " + numberOfHotel + "hotel");
        return driver.findElement(By.xpath("//*[@data-testid='property-card'][" + numberOfHotel + "]"));
    }

    public WebElement findHotelTitle(int numberOfHotel) {
        LOGGER.info("Find " + numberOfHotel + "hotel title");
        return driver.findElement(By.xpath("//*[@data-testid='property-card'][" + numberOfHotel + "]//descendant:: div[@data-testid='title']"));
    }

    public void clickMaxRating() {
        driver.findElement(By.xpath(MAX_RATING)).click();
        LOGGER.info("Click on the max rating in the filters");
    }

    public int getNumberRating() {
        LOGGER.info("Get value of the max rating in the filters");
        return Integer.parseInt(driver.findElement(By.xpath(GET_NUMBER_RATING)).getText().replaceAll("[^0-9]", ""));
    }

    public void openFirstHotelUrl() {
        driver.get(driver.findElement(By.xpath(FIRST_HOTEL_URL)).getAttribute("href"));
        LOGGER.info("Open the first hotel url");
    }

    public void clickMaxPriceNight() {
        try {
            driver.findElement(By.xpath(String.format(MAX_PRICE_NIGHT_FLAG, "span[2]"))).click();
            LOGGER.info("Click on the max price night in the filters");
        } catch (NoSuchElementException e) {
            Actions make = new Actions(driver);
            make
                    .clickAndHold(driver.findElement(By.xpath(String.format(MAX_PRICE_NIGHT_SCROLL, "div[1]"))))
                    .moveByOffset(200, -25)
                    .release()
                    .build()
                    .perform();
            LOGGER.info("Set the max price night in the filters");
        }
    }
}
