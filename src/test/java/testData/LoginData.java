package testData;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "ValidLogin")
    public Object[][] validValues(){
        return new Object[][] {
                {"First-Value"}, {"Second-Value"}
        };
    }
}
