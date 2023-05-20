package project.tests.testNg;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import project.driver.Driver;
import project.pages.page_booking.HomePage;
import project.pages.page_booking.HotelPage;
import project.pages.page_booking.ResultsPage;
import project.utils.ActionsUtil;
import project.utils.DateUtil;

public class BookingNgTest {

    HomePage bookingHomePage = new HomePage();

    ResultsPage bookingResultsPage = new ResultsPage();

    HotelPage bookingHotelPage = new HotelPage();

    DateUtil date = new DateUtil();

    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingNgTest.class.getName());

    @BeforeMethod
    public void beforeTests() {
        LOGGER.info("The booking testNG Before method is started");
        Driver.getWebDriver();
        LOGGER.info("The booking testNG Before method is finished");
    }

    @AfterMethod
    public void afterTests() {
        LOGGER.info("The booking testNG After method is started");
        Driver.closeDriver();
        LOGGER.info("The booking testNG After method is finished");
    }

    @Test
    public void pricePerNightTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnOccupancyDropdown();
        bookingHomePage.clickOnTheAdults();
        bookingHomePage.clickOnTheAdults();
        bookingHomePage.clickOnTheApartments();
        bookingHomePage.clickOnTheSubmit();
        bookingResultsPage.clickOnTheMaxPricePerNight();
        bookingResultsPage.waitForSpinner();
        bookingResultsPage.clickOnTheSortDropdown();
        bookingResultsPage.clickOnThePriceSorting();
        bookingResultsPage.assertPricePerNightTestNG();
        LOGGER.debug("Test 'pricePerNightTest' is executed");
    }

    @Test
    public void colorsTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnTheSubmit();
        actions.scrollToElement(bookingResultsPage.findHotel(10));
        actions.changeElementBackground(bookingResultsPage.findHotel(10));
        actions.changeElementTextColor(bookingResultsPage.findHotelTitle(10));
        Assert.assertEquals(bookingResultsPage.findHotelTitle(10).getAttribute("style"), "color: red;", "The text color isn't red");
        LOGGER.debug("Test 'colorsTest' is executed");
    }

    @Test
    public void hotelAvailabilityTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnTheSubmit();
        Assert.assertTrue(bookingResultsPage.findHotels().size() > 0, "There are no hotels");
        LOGGER.debug("Test 'hotelAvailabilityTest' is executed");
    }

    @Test
    public void hotelRatingTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickOnTheSubmit();
        bookingResultsPage.clickOnTheMaxRating();
        bookingResultsPage.waitForSpinner();
        int rating = bookingResultsPage.getNumberOfMaxRating();
        bookingResultsPage.openFirstHotelUrl();
        Assert.assertTrue(bookingHotelPage.getNumberOfHotelRating() >= rating, "The hotel rating is less than 9");
        LOGGER.debug("Test 'hotelRatingTest' is executed");
    }

    @Test
    public void currencyTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        actions.hoverElement(bookingHomePage.findCurrency());
        String tooltip = bookingHomePage.getCurrencyTooltip();
        Assert.assertEquals(tooltip, "Выберите валюту", "There is an incorrect tooltip");
        LOGGER.debug("Test 'currencyTest' is executed");
    }

    @Test
    public void languageTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        actions.hoverElement(bookingHomePage.findLanguage());
        String tooltip = bookingHomePage.getLanguageTooltip();
        Assert.assertEquals(tooltip, "Выберите язык", "There is an incorrect tooltip");
        LOGGER.debug("Test 'languageTest' is executed");
    }
}

