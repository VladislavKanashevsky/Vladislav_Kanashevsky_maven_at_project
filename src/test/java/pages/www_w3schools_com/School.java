package pages.www_w3schools_com;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class School {
    WebDriver driver = Driver.getWebDriver();

    public void getSchoolUrl() {
        driver.get("https://www.w3schools.com/java/");
    }
}

