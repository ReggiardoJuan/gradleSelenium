package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public By signInButton = By.className("HeaderMenu-link--sign-in");
    public By formHeader = By.className("auth-form-header");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLogin() {
        this.clickElement(this.signInButton);
        this.waitForElementToBeDisplayed(this.formHeader);
    }
}
