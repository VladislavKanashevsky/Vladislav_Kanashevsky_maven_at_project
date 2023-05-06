package tests;

import driver.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewAccountInBookingTest {
    WebDriver driver= Driver.getWebDriver();
    @Before
    public void data(){
        driver.get("https://www.booking.com/");
    }
    @Test
    public void test(){
            driver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();
            driver.findElement(By.xpath("//a[@data-testid='header-sign-up-button']")).click();
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("holly.damore@trashmail.fr");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("Af0123456789");
            driver.findElement(By.xpath("//input[@id='confirmed_password']")).sendKeys("Af0123456789");
            driver.findElement(By.xpath("//span[text()='Создать аккаунт']")).click();


    }
}
