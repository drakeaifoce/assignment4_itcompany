package com.company.enteties;

public class Developer extends Worker {
    private String programming_lang;
    private boolean middle;
    private boolean senior;

    public Developer() {
    }

    public Developer(String name, String surname) {
        super(name, surname);
    }

    public Developer(String name, String surname, int age, String degree, String gender, String email, int work_exp, String programming_lang, boolean middle, boolean senior) {
        super(name, surname, age, degree, gender, email, work_exp);
        this.programming_lang = programming_lang;
        this.middle = middle;
        this.senior = senior;
    }

    public Developer(int id, String name, String surname, int age, String degree, String gender, String email, int work_exp, String programming_lang, boolean middle, boolean senior) {
        super(id, name, surname, age, degree, gender, email, work_exp);
        this.programming_lang = programming_lang;
        this.middle = middle;
        this.senior = senior;
    }



    public String getProgramming_lang() {
        return programming_lang;
    }

    public void setProgramming_lang(String programming_lang) {
        this.programming_lang = programming_lang;
    }


    public boolean isMiddle() {
        return middle;
    }

    public void setMiddle(boolean middle) {
        this.middle = middle;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", degree='" + getDegree() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", email='" + getEmail() + '\'' +
                "programming_lang='" + programming_lang + '\'' +
                ", middle=" + middle +
                ", senior=" + senior +
                '}';
    }
}
