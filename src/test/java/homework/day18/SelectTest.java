package homework.day18;

import driver.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void Data() {
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void Test() {
        driver.findElement(By.xpath("//div[@id='withOptGroup']")).click();
        driver.findElement(By.xpath("//div[text()='Group 1, option 1']")).click();
        driver.findElement(By.xpath("//div[@id='selectOne']")).click();
        driver.findElement(By.xpath("//div[text()='Dr.']")).click();
        Select selectColor = new Select(driver.findElement(By.id("oldSelectMenu")));
        selectColor.selectByValue("1");
        driver.findElement(By.xpath("//div[text()='Select...']/..")).click();
        driver.findElement(By.xpath("//div[text()='Green']")).click();
        Select selectCars = new Select(driver.findElement(By.id("cars")));
        selectCars.selectByIndex(1);
    }

    @After
    public void Close() {
        driver.quit();
    }
}
