package project.tests.testNg;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import project.driver.Driver;
import project.pages.page_booking.HomePageBooking;
import project.pages.page_booking.HotelPageBooking;
import project.pages.page_booking.ResultsPageBooking;
import project.utils.ActionsUtil;
import project.utils.DateUtil;

public class BookingNgTest {

    HomePageBooking bookingHomePageBooking = new HomePageBooking();

    ResultsPageBooking bookingResultsPageBooking = new ResultsPageBooking();

    HotelPageBooking bookingHotelPageBooking = new HotelPageBooking();

    DateUtil date = new DateUtil();

    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingNgTest.class.getName());

    @BeforeMethod
    public void beforeTests() {
        LOGGER.info("The booking testNg Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The booking testNg Before method is finished");
    }

    @AfterMethod
    public void afterTests() {
        LOGGER.info("The booking testNg After method is started");
        Driver.closeDriver();
        LOGGER.info("The booking testNg After method is finished");
    }

    @Test
    public void pricePerNightTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        bookingHomePageBooking.selectPlace("Париж");
        bookingHomePageBooking.selectDate(date.setDay(3));
        bookingHomePageBooking.selectDate(date.setDay(10));
        bookingHomePageBooking.clickOnOccupancyDropdown();
        bookingHomePageBooking.clickOnTheAdults();
        bookingHomePageBooking.clickOnTheAdults();
        bookingHomePageBooking.clickOnTheApartments();
        bookingHomePageBooking.clickOnTheSubmit();
        bookingResultsPageBooking.clickOnTheMaxPriceNight();
        bookingResultsPageBooking.waitForSpinner();
        bookingResultsPageBooking.clickOnTheSortDropdown();
        bookingResultsPageBooking.clickOnThePriceSort();
        bookingResultsPageBooking.assertPriceNightTestNG();
        LOGGER.debug("Test 'priceNightTest' is executed");
    }

    @Test
    public void colorsTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        bookingHomePageBooking.selectPlace("Париж");
        bookingHomePageBooking.selectDate(date.setDay(3));
        bookingHomePageBooking.selectDate(date.setDay(10));
        bookingHomePageBooking.clickOnTheSubmit();
        actions.scrollToElement(bookingResultsPageBooking.findHotel(10));
        actions.changeElementBackground(bookingResultsPageBooking.findHotel(10));
        actions.changeElementTextColor(bookingResultsPageBooking.findHotelTitle(10));
        Assert.assertEquals(bookingResultsPageBooking.findHotelTitle(10).getAttribute("style"), "color: red;", "The text color isn't red");
        LOGGER.debug("Test 'colorsTest' is executed");
    }

    @Test
    public void hotelAvailabilityTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        bookingHomePageBooking.selectPlace("Париж");
        bookingHomePageBooking.selectDate(date.setDay(3));
        bookingHomePageBooking.selectDate(date.setDay(10));
        bookingHomePageBooking.clickOnTheSubmit();
        Assert.assertTrue(bookingResultsPageBooking.findHotels().size() > 0, "There are no hotels");
        LOGGER.debug("Test 'hotelAvailabilityTest' is executed");
    }

    @Test
    public void hotelRatingTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        bookingHomePageBooking.selectPlace("Париж");
        bookingHomePageBooking.selectDate(date.setDay(3));
        bookingHomePageBooking.selectDate(date.setDay(10));
        bookingHomePageBooking.clickOnTheSubmit();
        bookingResultsPageBooking.clickOnTheMaxRating();
        bookingResultsPageBooking.waitForSpinner();
        int rating = bookingResultsPageBooking.getNumberOfMaxRating();
        bookingResultsPageBooking.openFirstHotelUrl();
        Assert.assertTrue(bookingHotelPageBooking.getNumberOfHotelRating() >= rating, "The hotel rating is less than 9");
        LOGGER.debug("Test 'hotelRatingTest' is executed");
    }

    @Test
    public void currencyTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        actions.hoverElement(bookingHomePageBooking.findCurrency());
        String tooltip = bookingHomePageBooking.getCurrencyTooltip();
        Assert.assertEquals(tooltip, "Выберите валюту", "There is an incorrect tooltip");
        LOGGER.debug("Test 'currencyTest' is executed");
    }

    @Test
    public void languageTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        actions.hoverElement(bookingHomePageBooking.findLanguage());
        String tooltip = bookingHomePageBooking.getLanguageTooltip();
        Assert.assertEquals(tooltip, "Выберите язык", "There is an incorrect tooltip");
        LOGGER.debug("Test 'languageTest' is executed");
    }
}

