package project.pages.page_google;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

import java.util.List;

import org.apache.log4j.Logger;

public class Google {

    WebDriver driver = Driver.getWebDriver();

    public static final String GOOGLE_URL = "https://google.com";

    public static final String SEARCH = "[name='q']";

    public static final String RESULT = "//h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL') or contains(text(), TuToRiAl) or contains(text(), tUtOrIaL)]";

    public static final Logger LOGGER = Logger.getLogger(Google.class.getName());

    public void getGoogleUrl() {
        driver.get(GOOGLE_URL);
        LOGGER.trace("Open the https://google.com");
    }

    public WebElement findSearchField() {
        LOGGER.trace("Get the search field element");
        return driver.findElement(By.cssSelector(SEARCH));
    }

    public List<WebElement> displayedResults() {
        List<WebElement> webElements = driver.findElements(By.xpath(RESULT));
        Assert.assertEquals("Result isn't 'tutorial'", 14, webElements.size());
        return webElements;
    }
}




