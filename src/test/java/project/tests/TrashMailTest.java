package project.tests;

import project.driver.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrashMailTest {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void data() {
        driver.get("https://trashmail.com/");
    }

    @Test
    public void test() {
        driver.findElement(By.xpath("//input[@id='fe-forward']")).sendKeys("kanash.98@mail.ru");
        driver.findElement(By.xpath("//div[@class='input-group input-group-sm input-group-btn']//div[@class='input-group-btn']")).click();
        driver.findElement(By.xpath("//div[@class='input-group input-group-sm input-group-btn']//div[@class='input-group-btn']//li[@role='presentation'][2]")).click();
        driver.findElement(By.xpath("//button[@id='fe-submit']")).click();
    }


    @After
    public void close() {
        //driver.quit();
    }
}
