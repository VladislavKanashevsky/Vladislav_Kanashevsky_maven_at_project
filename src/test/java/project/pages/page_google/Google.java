package project.pages.page_google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Google {

    WebDriver driver = Driver.getWebDriver();

    public static final String GOOGLE_URL = "https://google.com";

    public static final String SEARCH = "[name='q']";

    public static final String RESULT = "//h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL') or contains(text(), TuToRiAl) or contains(text(), tUtOrIaL)]";

    public static final String TUTORIAL = "tutorial";

    public static final Logger LOGGER = Logger.getLogger(Google.class.getName());

    public void getGoogleUrl() {
        driver.get(GOOGLE_URL);
        LOGGER.trace("Open the https://google.com");
    }

    public WebElement findSearchField() {
        LOGGER.trace("Get the search field element");
        return driver.findElement(By.cssSelector(SEARCH));
    }

    public List<WebElement> displayedResultsCount() {
        List<WebElement> allResults = driver.findElements(By.xpath(RESULT));
        List<WebElement> displayedResults = new ArrayList<>();
        for (WebElement item : allResults) {
            if (item.isDisplayed()) {
                displayedResults.add(item);
            }
        }
        LOGGER.trace("Get results list");
        return displayedResults;
    }

    public int displayedResultsCountContainsTutorial() {
        int counter = 0;
        for (WebElement item : displayedResultsCount()) {
            if (item.getText().toLowerCase().contains(TUTORIAL)) {
                counter++;
            }
        }
        LOGGER.trace("Get the count of results");
        return counter;
    }
}




