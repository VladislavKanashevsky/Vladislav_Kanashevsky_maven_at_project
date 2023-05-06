package homework.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverWeatherTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("погода минск");
        driver.findElement(By.className("sbct")).submit();
        driver.findElement(By.id("dimg_3")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='wob_t wob_gs_l18'][1]")).getText());
    }
}