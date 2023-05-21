package project.tests.junit4;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.pages.page_booking.HomePageBooking;
import project.pages.page_booking.SingPageBooking;
import project.utils.ActionsUtil;

public class BookingRegistrationTest {

    HomePageBooking bookingHomePageBooking = new HomePageBooking();

    SingPageBooking singPageBooking = new SingPageBooking();

    ActionsUtil actions = new ActionsUtil();

    public static final Logger LOGGER = Logger.getLogger(BookingRegistrationTest.class.getName());

    @Before
    public void beforeTest() {
    }

    @After
    public void afterTest() {
    }

    @Test
    public void registerTest() {
        bookingHomePageBooking.getBookingUrl();
        bookingHomePageBooking.skipSignInOffer();
        bookingHomePageBooking.clickRegister();
        singPageBooking.enterEmail("leffler.baby@trashmail.fr");
        singPageBooking.clickSubmit();
        singPageBooking.enterPassword("Af0123456789");
        actions.clickAndHold(singPageBooking.getCaptcha());
    }
}


