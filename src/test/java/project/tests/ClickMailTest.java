package project.tests;

import project.driver.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickMailTest {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void data() {
        driver.get("https://e.mail.ru/inbox/");
    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kanash.98");
        driver.findElement(By.xpath("//span[text()='Ввести пароль']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ONSOMESHIT420");
        driver.findElement(By.xpath("//button[@data-test-id='submit-button']")).click();
        driver.findElement(By.xpath("//span[@title='TrashMail.com <holly.damore@trashmail.fr>']")).click();
    }
}