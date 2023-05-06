package homework.day18;

import driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SchoolsTest {

    WebDriver driver = Driver.getWebDriver();

    Actions actions = new Actions(driver);

    @Before
    public void Data() {
        driver.get("https://www.w3schools.com/java/");
    }

    @Test
    public void Test() {
        WebElement tutorial = driver.findElement(By.xpath("//span[text()='Tutorial']"));
        actions.doubleClick(tutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        driver.navigate().to("https://www.google.com/");
        WebElement googleSearch = driver.findElement(By.xpath("//textarea[@role='combobox']"));
        actions.click(googleSearch)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        List<WebElement> webElements = driver.findElements(By.xpath("//h3[contains(text(), 'tutorial') or contains(text(), 'Tutorial') or contains(text(), 'TUTORIAL') or contains(text(), TuToRiAl) or contains(text(), tUtOrIaL)]"));
        Assert.assertEquals("Result isn't 'tutorial'", 14, webElements.size());
    }

    @After
    public void Close() {
        driver.quit();
    }
}