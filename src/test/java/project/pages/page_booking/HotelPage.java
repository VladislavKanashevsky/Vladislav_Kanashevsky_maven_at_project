package project.pages.page_booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import project.driver.Driver;

public class HotelPage {

    WebDriver driver = Driver.getWebDriver();

    public static final String NUMBER_HOTEL_RATING = "//*[@data-testid='review-score-right-component']/div[1]";

    public static final Logger LOGGER = Logger.getLogger(HotelPage.class.getName().getClass());

    public int getNumberOfHotelRating() {
        LOGGER.trace("Find the hotel rating value");
        return Integer.valueOf(driver.findElement(By.xpath(NUMBER_HOTEL_RATING)).getText().replaceAll("[^0-9]", ""));
    }
}
