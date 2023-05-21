package project.tests.junit4;

import org.apache.log4j.Logger;
import org.junit.*;
import project.driver.Driver;
import project.pages.page_booking.HomePageBooking;
import project.pages.page_booking.HotelPageBooking;
import project.pages.page_booking.ResultsPageBooking;
import project.utils.ActionsUtil;
import project.utils.DateUtil;

public class BookingTest {

    HomePageBooking bookingHomePageBooking = new HomePageBooking();

    ResultsPageBooking bookingResultsPageBooking = new ResultsPageBooking();

    HotelPageBooking bookingHotelPageBooking = new HotelPageBooking();

    DateUtil date = new DateUtil();

    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingTest.class.getName());

    @Before
    public void beforeTests() {
        LOGGER.info("The booking junit Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The booking junit Before method is finished");
    }

    @After
    public void afterTests() {
        LOGGER.info("The booking junit After method is started");
        Driver.closeDriver();
        LOGGER.info("The booking junit After method is finished");
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
        bookingResultsPageBooking.assertPriceNight();
        LOGGER.debug("Test 'pricePerNightTest' is executed");
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
        Assert.assertEquals("The text color isn't red", "color: red;", bookingResultsPageBooking.findHotelTitle(10).getAttribute("style"));
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
        Assert.assertTrue("There are no hotels", bookingResultsPageBooking.findHotels().size() > 0);
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
        Assert.assertTrue("The hotel rating is less than 9",
                bookingHotelPageBooking.getNumberOfHotelRating() >= rating
        );
        LOGGER.debug("Test 'hotelRatingTest' is executed");
    }

    @Test
    public void currencyTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        actions.hoverElement(bookingHomePageBooking.findCurrency());
        String tooltip = bookingHomePageBooking.getCurrencyTooltip();
        Assert.assertEquals("There is an incorrect tooltip", "Выберите валюту", tooltip);
        LOGGER.debug("Test 'currencyTest' is executed");
    }

    @Test
    public void languageTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        actions.hoverElement(bookingHomePageBooking.findLanguage());
        String tooltip = bookingHomePageBooking.getLanguageTooltip();
        Assert.assertEquals("There is an incorrect tooltip", "Выберите язык", tooltip);
        LOGGER.debug("Test 'languageTest' is executed");
    }
}