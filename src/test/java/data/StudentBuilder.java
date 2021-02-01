package data;

public class StudentBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    private String date;
    private String subject;
    private String hobby;
    private String fileName;
    private String curAddress;
    private String state;
    private String city;

    public StudentBuilder(String firstName, String lastName, String email, String gender, String mobileNumber, String date, String subject, String hobby, String fileName, String curAddress, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.date = date;
        this.subject = subject;
        this.hobby = hobby;
        this.fileName = fileName;
        this.curAddress = curAddress;
        this.state = state;
        this.city = city;
    }

    public Student build() {
        return new Student(firstName, lastName, email, gender, mobileNumber, date, subject, hobby, fileName, curAddress, state, city);
    }
}
