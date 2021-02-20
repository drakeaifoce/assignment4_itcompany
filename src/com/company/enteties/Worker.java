package com.company.enteties;

public abstract class Worker {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String degree;
    private String gender;
    private String email;
    private int work_exp;

    public Worker() {
    }

    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Worker(String name, String surname, int age, String degree, String gender, String email, int work_exp) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.degree = degree;
        this.gender = gender;
        this.email = email;
        this.work_exp = work_exp;
    }

    public Worker(int id, String name, String surname, int age, String degree, String gender, String email, int work_exp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.degree = degree;
        this.gender = gender;
        this.email = email;
        this.work_exp = work_exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getWork_exp() {
        return work_exp;
    }

    public void setWork_exp(int work_exp) {
        this.work_exp = work_exp;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", degree='" + degree + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
