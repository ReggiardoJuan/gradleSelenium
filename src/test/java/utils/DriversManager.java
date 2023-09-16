package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriversManager {
    public WebDriver getDriver() {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome": {
                return getChrome();
            }
            case "firefox": {
                return getFirefox();
            }
            default: return getChrome();
        }
    };

    private WebDriver getChrome()  {
        // Set capabilities example
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "window-size=1920,1080"
        );

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private WebDriver getFirefox()  {
        // Set capabilities
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
