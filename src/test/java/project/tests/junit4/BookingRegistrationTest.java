package project.tests.junit4;

import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import project.pages.page_booking.HomePage;
import project.pages.page_booking.SingPage;
import project.utils.ActionsUtil;

public class BookingRegistrationTest {

    HomePage bookingHomePage = new HomePage();

    SingPage singPage = new SingPage();
    ActionsUtil actions = new ActionsUtil();

    @BeforeTest
    public void beforeTest() {
    }

    @Test
    public void registrationTest() {
        bookingHomePage.getUrl();
        bookingHomePage.skipSign();
        bookingHomePage.clickRegistration();
        singPage.enterEmail("leffler.baby@trashmail.fr");
        singPage.clickSubmit();
        singPage.enterPassword("Af0123456789");
        actions.clickAndHold(singPage.getCaptcha());
    }

    @AfterTest
    public void afterTest() {
    }
}
