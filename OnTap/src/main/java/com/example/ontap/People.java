package com.example.ontap;

public class People {
    private String id;
    private String nameUser;
    private String age;
    private String gmail;
    private String address;

    public People() {
    }

    public People(String id, String nameUser, String age, String gmail, String address) {
        this.id = id;
        this.nameUser = nameUser;
        this.age = age;
        this.gmail = gmail;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", age='" + age + '\'' +
                ", gmail='" + gmail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
