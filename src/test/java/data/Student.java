package data;

public class Student {

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

    public Student(String firstName, String lastName, String email, String gender, String mobileNumber, String date, String subject, String hobby, String fileName, String curAddress, String state, String city) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCurAddress() {
        return curAddress;
    }

    public void setCurAddress(String curAddress) {
        this.curAddress = curAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
