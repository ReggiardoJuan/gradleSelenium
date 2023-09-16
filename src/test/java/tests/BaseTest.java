package tests;

import utils.DriversManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static utils.Screenshot.takeScreenshot;

public class BaseTest {
    public WebDriver driver;

    public BaseTest() {
        DriversManager manager = new DriversManager();
        driver = manager.getDriver();
    }

    @BeforeClass
    public void setupDriver() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void saveScreenshotOnFailure(ITestResult testResult) throws IOException {
        if(!testResult.isSuccess()) {
            takeScreenshot(driver, testResult.getName());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        try{
            driver.quit();
        }catch (Exception e){
            System.out.println("Nothing to do with it");
        }
    }
}
