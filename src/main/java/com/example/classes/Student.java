package com.example.classes;



public class Student {

    private String username;
    private String password;
    private String name;
    private String universityId;
    private String birthdate;
    private String gender;

    public Student(String username, String password, String name, String universityId, String birthdate, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.universityId = universityId;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Student(String username, String gender, String name, String universityId) {
        this.username = username;
        this.gender = gender;
        this.name = name;
        this.universityId = universityId;
    }

    public Student() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
