package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static helpers.ConfigurationHelper.BASE_URL;

public class DemoQATest {

    private static final String FIRST_NAME = "Daniil";
    private static final String LAST_NAME = "M";

    private static final By firstName = By.cssSelector("#firstName");
    private static final By lastName = By.cssSelector("#lastName");

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = BASE_URL;
    }


    @Test
    public void register() {
        open("/");
        $(firstName).sendKeys(FIRST_NAME);
        $(lastName).sendKeys(LAST_NAME);
    }
}
