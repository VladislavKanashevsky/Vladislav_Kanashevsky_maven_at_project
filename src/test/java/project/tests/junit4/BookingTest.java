package project.tests.junit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project.driver.Driver;
import project.pages.page_booking.HomePage;
import project.pages.page_booking.HotelPage;
import project.pages.page_booking.ResultsPage;
import project.utils.ActionsUtil;
import project.utils.DateUtil;

public class BookingTest {

    HomePage bookingHomePage = new HomePage();

    ResultsPage bookingResultsPage = new ResultsPage();

    HotelPage bookingHotelPage = new HotelPage();

    DateUtil date = new DateUtil();

    ActionsUtil actions = new ActionsUtil();

    @Before
    public void beforeTests() {
        Driver.getWebDriver();
    }

    @After
    public void afterTests() {
        Driver.closeDriver();
    }


    @Test
    public void colorsTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSign();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickSubmit();
        // bookingResultsPage.scrollToElement(bookingResultsPage.findHotels(10));
        // bookingResultsPage.changeElementBackground(bookingResultsPage.findHotels(10));
        // bookingResultsPage.changeElementTextColor(bookingResultsPage.findHotelTitle(10));
        Assert.assertEquals("The text color isn't red", "color: red;", bookingResultsPage.findHotelTitle(10).getAttribute("style"));
    }

    @Test
    public void hotelAvailabilityTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSign();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickSubmit();
        Assert.assertTrue("There are no hotels", bookingResultsPage.findHotel().size() > 0);
    }

    @Test
    public void hotelRatingTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSign();
        bookingHomePage.selectingPlace("Париж");
        bookingHomePage.selectingDate(date.setDay(3));
        bookingHomePage.selectingDate(date.setDay(10));
        bookingHomePage.clickSubmit();
        bookingResultsPage.clickMaxRating();
        bookingResultsPage.waitSpinner();
        int rating = bookingResultsPage.getNumberRating();
        bookingResultsPage.openFirstHotelUrl();
        Assert.assertTrue("The hotel rating is less than 9",
                bookingHotelPage.getNumberHotelRating() >= rating
        );
    }

    @Test
    public void currencyTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSign();
        actions.hoverElement(bookingHomePage.findCurrency());
        String tooltip = bookingHomePage.getCurrency();
        Assert.assertEquals("There is an incorrect tooltip", "Выберите валюту", tooltip);
    }

    @Test
    public void languageTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSign();
        actions.hoverElement(bookingHomePage.findLanguage());
        String tooltip = bookingHomePage.getLanguage();
        Assert.assertEquals("There is an incorrect tooltip", "Выберите язык", tooltip);
    }
}