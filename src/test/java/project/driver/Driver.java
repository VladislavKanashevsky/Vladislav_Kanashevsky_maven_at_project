package project.driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver webDriver;

    public static Config config;

    public static void setConfig(Config config) {
        Driver.config = null == config ? Config.valueOf(System.getProperty("CONFIG")) : config;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
        }
        setTimeOuts(20, 20, 20);
        return webDriver;
    }

    private static void setTimeOuts(int scriptTimeout, int implicitlyWait, int pageLoadTimeout) {
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
