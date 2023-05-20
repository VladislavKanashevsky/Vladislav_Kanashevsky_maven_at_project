package project.tests.junit4;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.pages.page_booking.HomePage;
import project.pages.page_booking.SingPage;
import project.utils.ActionsUtil;

public class BookingRegistrationTest {

    HomePage bookingHomePage = new HomePage();

    SingPage singPage = new SingPage();

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
        bookingHomePage.getUrl();
        bookingHomePage.skipSignInOffer();
        bookingHomePage.clickRegister();
        singPage.enterEmail("leffler.baby@trashmail.fr");
        singPage.clickSubmit();
        singPage.enterPassword("Af0123456789");
        actions.clickAndHold(singPage.getCaptcha());
    }
}


