package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File screenshotSource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotSource, new File(screenshotName + "-" + System.currentTimeMillis() + ".png"));
    }
}
