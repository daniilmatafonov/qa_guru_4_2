package tests;

import com.github.javafaker.Faker;
import data.Student;
import org.openqa.selenium.By;
import page.StudentPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest {

    private StudentPage studentPage = new StudentPage();
    private Faker faker = new Faker();

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    public void register() {
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String emailAddress = faker.internet().emailAddress();
        String streetName = faker.address().streetName();
        String cellPhone = faker.phoneNumber().cellPhone();
        String gender = faker.demographic().sex();
        final Student student = new Student(firstName, lastName, emailAddress, gender, cellPhone,
                "1/September/1993", "Computer Science", "Sports", "mrburns.png", streetName, "Haryana", "Karnal");
        open("/");
        studentPage.fillFirstName(By.cssSelector("#firstName"), student.getFirstName());
        studentPage.fillLastName(By.cssSelector("#lastName"), student.getLastName());
        studentPage.fillEmail(By.cssSelector("#userEmail"), student.getEmail());
        studentPage.chooseGender(student.getGender());
        studentPage.fillMobile(By.cssSelector("#userNumber"), student.getMobileNumber());
        studentPage.setDatePicker(student.getDate(), ".react-datepicker__year-select", ".react-datepicker__month-select", ".react-datepicker__day");
        studentPage.fillSubject(By.cssSelector("#subjectsInput"), "C", student.getSubject());
        studentPage.upload(By.cssSelector("#uploadPicture"), student.getFileName());
        studentPage.hobbies("//label[contains(text(),'" + student.getHobby() + "')]");
        studentPage.curAddress("#currentAddress", student.getCurAddress());
        studentPage.location(student.getState(), student.getCity());
        studentPage.sendForm("#submit");
    }

}
