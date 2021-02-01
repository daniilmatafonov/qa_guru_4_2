package page;

import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StudentPage {

    public void fillFirstName(By by, String userName) {
        $(by).shouldBe(visible).sendKeys(userName);
    }

    public void fillLastName(By by, String lastName) {
        $(by).shouldBe(visible).sendKeys(lastName);
    }

    public void fillEmail(By by, String email) {
        $(by).shouldBe(visible).sendKeys(email);
    }

    public void chooseGender(String gender) {
        $(byText(gender)).shouldBe(visible).click();
    }

    public void fillMobile(By by, String number) {
        $(by).shouldBe(visible).sendKeys(number);
    }

    public void setDatePicker(String date, String yearSelector, String monthSelector, String daySelector) {
        String[] parsedDate = date.split("/");
        $("#dateOfBirthInput").click();
        $(yearSelector).click();
        $(yearSelector).$$("option").findBy(text(parsedDate[2])).click();
        $(monthSelector).click();
        $(monthSelector).$$("option").findBy(text(parsedDate[1])).click();
        $$(daySelector).findBy(text(parsedDate[0])).click();
    }

    public void fillSubject(By by, String firstTopicLetter, String subject) {
        $(by).shouldBe(visible).setValue(firstTopicLetter);
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
    }

    public void upload(By by, String fileName) {
        File file = new File("./src/test/resources/" + fileName);
        $(by).shouldBe(visible).uploadFile(file);
    }

    public void hobbies(String hobby) {
        $(Selectors.byXpath(hobby)).shouldBe(visible).click();
    }

    public void curAddress(String selector, String text) {
        $(By.cssSelector(selector)).shouldBe(visible).sendKeys(text);
    }

    public void location(String state, String city) {
        $("#state").shouldBe(visible).scrollIntoView(true).click();
        $(byText(state)).click();
        $("#city").shouldBe(visible).scrollIntoView(true).click();
        $(byText(city)).click();
    }

    public void sendForm(String selector) {
        $(selector).shouldBe(visible).scrollIntoView(true).click();
    }
}
