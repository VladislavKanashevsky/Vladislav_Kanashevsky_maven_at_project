package homework.day18;

import project.driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookingThreeTest {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void Data() {
        driver.get("https://booking.com");
    }

    @Test
    public void Test() {
        driver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Куда вы хотите поехать?']")).sendKeys("Париж");
        driver.findElement(By.xpath("//div[text()='Париж']")).click();
        driver.findElement(By.xpath("//span[text()='Найти']")).click();
        driver.findElement(By.xpath("//span[@aria-label='7 май 2023']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue("There are no hotels", driver.findElements(By.cssSelector("[data-testid='property-card']")).size() > 0);
    }

    @After
    public void Close() {
        driver.quit();
    }
}

