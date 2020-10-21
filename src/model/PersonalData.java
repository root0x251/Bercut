package model;

public class PersonalData {

    private String firstName;
    private String secondName;
    private String patronymicName;

    public PersonalData(String firstName, String secondName, String patronymicName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }
}
