package com.example.oop3;

public class People {
    private String iD;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gmail;
    private String address;

    public People() {
    }

    public People(String iD, String firstName, String lastName, String birthday, String gmail, String address) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gmail = gmail;
        this.address = address;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
