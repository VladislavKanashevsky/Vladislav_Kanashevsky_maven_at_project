package homework.day18;

import project.driver.Driver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BookingFourTest {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void data() {
        driver.get("https://www.booking.com/");
    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Куда вы хотите поехать?']")).sendKeys("Милан");
        driver.findElement(By.xpath("//div[text()='Милан']")).click();
        driver.findElement(By.xpath("//span[text()='Найти']")).click();
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//span[text()='Оценка объекта (по убыванию)']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='title']")).click();

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        String oldTab = driver.getWindowHandle();
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

        WebElement elementRating = driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']/div[contains(@aria-label, 'Оценка')]"));
        double rating = Double.parseDouble(elementRating.getText());
        Assert.assertTrue("hotel rating less than 9", 9.0 <= rating);
    }
}

