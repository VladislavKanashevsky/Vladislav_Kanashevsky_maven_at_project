package project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver getDriver(Config config) {

        return switch (config != null ? config : Config.CHROME) {
            case CHROME -> getChromeDriver();
            case FF -> getFirefoxDriver();
            case EDGE -> getEDGEDriver();
        };
    }

    public static WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver getFirefoxDriver() {
        return null;
    }

    private static WebDriver getEDGEDriver() {
        return null;
    }
}
