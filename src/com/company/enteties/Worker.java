package com.company.enteties;

public abstract class Worker {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private int work_exp;

    public Worker() {
    }

    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Worker(String name, String surname, int salary, int work_exp) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.work_exp = work_exp;
    }

    public Worker(int id, String name, String surname, int salary, int work_exp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
                ", age=" + salary +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
