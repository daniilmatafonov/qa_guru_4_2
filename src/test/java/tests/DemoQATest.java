package tests;

import com.github.javafaker.Faker;
import data.Student;
import page.StudentPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest {

    private StudentPage studentPage = new StudentPage();
    private Faker faker = new Faker();
    private static final String CITY = "Karnal";
    private static final String STATE = "Haryana";
    private static final String IMAGE_NAME = "mrburns.png";
    private static final String HOBBY = "Sports";
    private static final String SUBJECT = "Computer Science";
    private static final String DATE = "1/September/1993";

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
                DATE, SUBJECT, HOBBY, IMAGE_NAME, streetName, STATE, CITY);
        open("/");
        studentPage.fillFirstName(student.getFirstName());
        studentPage.fillLastName(student.getLastName());
        studentPage.fillEmail(student.getEmail());
        studentPage.chooseGender(student.getGender());
        studentPage.fillMobile(student.getMobileNumber());
        studentPage.setDatePicker(student.getDate());
        studentPage.fillSubject(student.getSubject());
        studentPage.upload(student.getFileName());
        studentPage.hobbies(student.getHobby());
        studentPage.curAddress(student.getCurAddress());
        studentPage.location(student.getState(), student.getCity());
        studentPage.sendForm();
    }

}
