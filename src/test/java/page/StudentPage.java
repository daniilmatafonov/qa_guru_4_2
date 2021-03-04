package page;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

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

    public void setDatePicker(String day, String month, String year) {
        String daySelector = ".react-datepicker__day";
        String monthSelector = ".react-datepicker__month-select";
        String yearSelector = ".react-datepicker__year-select";
        $("#dateOfBirthInput").click();
        $(yearSelector).click();
        $(yearSelector).$$("option").findBy(text(year)).click();
        $(monthSelector).click();
        $(monthSelector).$$("option").findBy(text(month)).click();
        $$(daySelector).findBy(text(day)).click();
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

    public void validateForm(String name, String gender, String email, String number,
                             String month, String year, String day, String location, String address, String subject,
                             String hobby, String image) {
        $(byClassName("table-responsive")).shouldHave(text(name), text(location), text(email));

        $x("//td[text()='Student Name']").parent().shouldHave(text(name));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(number));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Picture']").parent().shouldHave(text(image));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Address']").parent().shouldHave(text(address));
        $x("//td[text()='State and City']").parent().shouldHave(text(location));
    }
}
