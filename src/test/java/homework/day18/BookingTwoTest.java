package homework.day18;

import project.driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingTwoTest {

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
        driver.findElement(By.xpath("//span[@aria-label='21 май 2023']")).click();
        driver.findElement(By.xpath("//span[@aria-label='28 май 2023']")).click();
        driver.findElement(By.xpath("//span[text()='Найти']")).click();
        driver.findElement(By.xpath("//button[@data-testid=\"sorters-dropdown-trigger\"]")).click();
        driver.findElement(By.xpath("//span[text()='Оценка объекта (по убыванию)']")).click();

        WebElement element = driver.findElement(By.xpath("//h1[contains(text(), 'вариант')]"));
        String ratingNine = element.getText();
        String rating = ratingNine.replaceAll("[^0-9]", "");
        int i = Integer.parseInt(rating);
        Assert.assertNotEquals("Hotel have rating 9", 0, i);
    }

    @After
    public void Close() {
        driver.quit();
    }
}
