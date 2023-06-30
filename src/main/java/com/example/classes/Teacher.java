package com.example.classes;


public class Teacher {
    private String username;
    private String password;
    private String name;
    private String birthdate;
    private String gender;
    private String salary;
    private String specialty;

    public Teacher(String username, String password, String name, String birthdate, String gender, String salary, String specialty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.salary = salary;
        this.specialty = specialty;
    }

    public Teacher(String username, String name, String gender, String specialty) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.specialty = specialty;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
