package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testData.LoginData;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@Epic("Some epic")
@Feature("Login")
public class GradleSeleniumTest extends BaseTest {
    LoginPage loginPage;

    @BeforeTest
    public void initPages() {
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "ValidLogin", dataProviderClass = LoginData.class, description = "Verify github page title and navigate to login form")
    @Severity(SeverityLevel.NORMAL)
    public void verifyGitHubTitle(String data) {
        System.out.println(data);
        driver.get("https://www.github.com");
        assertThat(driver.getTitle())
                .as("Expected title was not present")
                .contains("GitHub");

        loginPage.goToLogin();
        assertThat(driver.getTitle()).contains("Sign in");
        assertSoftly(softly -> {
            softly.assertThat(1).isNotNull();
            softly.assertThat(1).isEqualTo(1);
        });
    }
}