package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {
    private static final String BASE_URL = "http://restful-booker.herokuapp.com";
    //https://restful-booker.herokuapp.com/booking

    @BeforeTest
    public void setup() {

        Configuration.baseUrl = BASE_URL;
    }

    @AfterTest (alwaysRun = true)
    public void cleanUp() {
        closeWebDriver();
    }
}

