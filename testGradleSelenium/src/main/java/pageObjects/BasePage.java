package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By byElement) {
        return this.driver.findElement(byElement);
    }
    public void clickElement(By byElement) {
        this.getElement(byElement).click();
    }
    public void waitForElementToBeDisplayed(By byElement) {
        this.waitForElementToBeDisplayed(byElement, 5);
    }
    public void waitForElementToBeDisplayed(By byElement, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }
}
