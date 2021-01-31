package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StudentPage{

    public void fillFirstName(By by, String userName) {
        $(by).shouldBe(visible).sendKeys(userName);
    }

    public void fillLastName(By by, String lastName) {
        $(by).shouldBe(visible).sendKeys(lastName);
    }
}
