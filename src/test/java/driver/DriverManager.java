package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    public static WebDriver getDriver(Config config) {

        return switch (config != null ? config : Config.CHROME) {
            case CHROME -> getChromeDriver();
            case FF -> getFirefoxDriver();
            case EDGE -> getEDGEDriver();
        };
    }

    public static WebDriver getChromeDriver() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        return null;
    }

    private static WebDriver getEDGEDriver() {
        return null;
    }
}
