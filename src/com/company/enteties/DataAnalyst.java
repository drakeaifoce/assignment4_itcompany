package com.company.enteties;

public class DataAnalyst extends Worker{
    String skill;

    public DataAnalyst() {
    }

    public DataAnalyst(String name, String surname, String skill) {
        super(name, surname);
        this.skill = skill;
    }

    public DataAnalyst(String name, String surname, int salary, int work_exp, String skill) {
        super(name, surname, salary, work_exp);
        this.skill = skill;
    }

    public DataAnalyst(int id, String name, String surname, int salary, int work_exp, String skill) {
        super(id, name, surname, salary, work_exp);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "DataAnalyst{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", salary=" + getSalary() + '\'' +
                ", work_exp=" + getWork_exp() + '\'' +
                "skill='" + skill + '\'' +
                '}';
    }
}
