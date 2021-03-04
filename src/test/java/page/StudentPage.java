package page;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StudentPage {

    public void fillFirstName(String userName) {
        $("#firstName").setValue(userName);
    }

    public void fillLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void fillEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void chooseGender(String gender) {
        $(byText(gender)).shouldBe(visible).click();
    }

    public void fillMobile(String number) {
        $("#userNumber").setValue(number);
    }

    public void setDatePicker(String date) {
        String daySelector = ".react-datepicker__day";
        String monthSelector = ".react-datepicker__month-select";
        String yearSelector = ".react-datepicker__year-select";
        String[] parsedDate = date.split("/");
        $("#dateOfBirthInput").click();
        $(yearSelector).click();
        $(yearSelector).$$("option").findBy(text(parsedDate[2])).click();
        $(monthSelector).click();
        $(monthSelector).$$("option").findBy(text(parsedDate[1])).click();
        $$(daySelector).findBy(text(parsedDate[0])).click();
    }

    public void fillSubject(String subject) {
        $("#subjectsInput").shouldBe(visible).setValue("Computer Science");
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
    }

    public void upload(String fileName) {
        File file = new File("./src/test/resources/" + fileName);
        $("#uploadPicture").shouldBe(visible).uploadFile(file);
    }

    public void hobbies(String hobby) {
        $(byXpath("//label[contains(text(),'" + hobby + "')]")).shouldBe(visible).click();
    }

    public void curAddress(String text) {
        $("#currentAddress").shouldBe(visible).setValue(text);
    }

    public void location(String state, String city) {
        $("#state").shouldBe(visible).scrollIntoView(true).click();
        $(byText(state)).click();
        $("#city").shouldBe(visible).scrollIntoView(true).click();
        $(byText(city)).click();
    }

    public void sendForm() {
        $("#submit").shouldBe(visible).scrollIntoView(true).click();
    }
}
