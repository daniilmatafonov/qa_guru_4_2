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

    public StudentBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder email(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public StudentBuilder mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public StudentBuilder date(String date) {
        this.date = date;
        return this;
    }

    public StudentBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    public StudentBuilder hobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public StudentBuilder fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public StudentBuilder curAddress(String curAddress) {
        this.curAddress = curAddress;
        return this;
    }

    public StudentBuilder state(String state) {
        this.state = state;
        return this;
    }

    public StudentBuilder city(String city) {
        this.city = city;
        return this;
    }

    public Student build() {
        return new Student(firstName, lastName, email, gender, mobileNumber, date, subject, hobby, fileName, curAddress, state, city);
    }
}
