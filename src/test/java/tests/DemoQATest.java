package tests;

import com.codeborne.selenide.Configuration;
import data.Student;
import data.StudentBuilder;
import org.openqa.selenium.By;
import page.StudentPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.ConfigurationHelper.BASE_URL;
import static helpers.ConfigurationHelper.timeout;

public class DemoQATest {

    private StudentPage studentPage = new StudentPage();

    @BeforeAll
    public static void setUp() {
        baseUrl = BASE_URL;
        startMaximized = true;
    }

    @Test
    public void register() {
        final Student student = createStudent("Daniil", "M", "", "", "",
                "", "", "", "", "", "", "");
        open("/");
        studentPage.fillFirstName(By.cssSelector("#firstName"), student.getFirstName());
        studentPage.fillLastName(By.cssSelector("#lastName"), student.getLastName());
    }

    private Student createStudent(String firstName, String lastName,
                                  String email, String gender, String mobileNumber,
                                  String date, String subject, String hobby,
                                  String fileName, String curAddress,
                                  String state, String city) {
        return new StudentBuilder(firstName, lastName, email, gender, mobileNumber, date, subject, hobby, fileName, curAddress, state, city).build();
    }

}
