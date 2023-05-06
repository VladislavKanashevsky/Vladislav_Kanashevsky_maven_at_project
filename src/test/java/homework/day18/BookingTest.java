package homework.day18;

import driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingTest {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void data() {

        driver.get("https://www.booking.com/");
    }

    @Test
    public void Test() {
        driver.findElement(By.xpath("//button[@aria-label=\"Скрыть меню входа в аккаунт.\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Куда вы хотите поехать?']")).sendKeys("Париж");
        driver.findElement(By.xpath("//div[@data-testid=\"searchbox-dates-container\"]")).click();
        driver.findElement(By.xpath("//span[@data-date=\"2023-05-21\"]")).click();
        driver.findElement(By.xpath("//span[@data-date=\"2023-05-28\"]")).click();
        driver.findElement(By.xpath("//button[@data-testid=\"occupancy-config\"]")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='no_rooms']/following-sibling::div/button[2]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Готово')]")).click();
        driver.findElement(By.xpath("//span[text()='Найти']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='overlay-spinner']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[@data-id='price']")).click();
        WebElement priceHotelElement = driver.findElement(By.xpath("//span[@data-testid='price-and-discounted-price'][1]"));
        String priceHotel = priceHotelElement.getText();
        String priceHotelNumberOnly = priceHotel.replaceAll("[^0-9]", "");
        WebElement priceNightElement = driver.findElement(By.xpath("//div[@data-testid='filters-sidebar']/div[2]//div[@data-filters-item='pri:pri=5']"));
        String priceNight = priceNightElement.getText();
        String priceNightNumberOnly = priceNight.replaceAll("[^0-9]", "");
        double hotelPrice = Double.parseDouble(priceHotelNumberOnly);
        double nightPrice = Double.parseDouble(priceNightNumberOnly);
        Assert.assertTrue("the cost of a night in a hotel is less than the minimum", hotelPrice / 7 >= nightPrice);
    }

    @After
    public void Close() {
        //driver.quit();
    }
}

