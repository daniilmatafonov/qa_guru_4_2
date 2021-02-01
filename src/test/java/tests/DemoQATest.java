package tests;

import data.Student;
import data.StudentBuilder;
import org.openqa.selenium.By;
import page.StudentPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ConfigurationHelper.BASE_URL;

public class DemoQATest {

    private StudentPage studentPage = new StudentPage();

    @BeforeAll
    public static void setUp() {
        baseUrl = BASE_URL;
        startMaximized = true;
    }

    @Test
    public void register() {
        final Student student = createStudent("Daniil", "M", "test@mail.ru", "Male", "79000000000",
                "1/September/1993", "Computer Science", "Sports", "mrburns.png", "Happy street", "Haryana", "Karnal");
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

    private Student createStudent(String firstName, String lastName,
                                  String email, String gender, String mobileNumber,
                                  String date, String subject, String hobby,
                                  String fileName, String curAddress,
                                  String state, String city) {
        return new StudentBuilder(firstName, lastName, email, gender, mobileNumber, date, subject, hobby, fileName, curAddress, state, city).build();
    }

}
