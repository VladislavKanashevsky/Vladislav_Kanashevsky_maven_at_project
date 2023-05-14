package project.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.driver.Driver;

public class ActionsUtil {

    WebDriver driver = Driver.getWebDriver();

    Actions actions = new Actions(driver);

    public void selectingCopyElement(WebElement webElement) {

        actions
                .doubleClick(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void selectingPasteElement(WebElement webElement) {
        actions
                .click(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .build()
                .perform();
    }

    public void selectingPaste() {
        actions
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void hoverElement(WebElement webElement) {
        actions.moveToElement(webElement);
        actions.perform();
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

    public void clickAndHold(WebElement webElement) {
        actions
                .moveByOffset(674, -525)
                .clickAndHold(webElement)
                .build()
                .perform();
    }
}