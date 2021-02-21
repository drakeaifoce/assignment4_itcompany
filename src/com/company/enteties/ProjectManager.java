package com.company.enteties;

public class ProjectManager extends Worker{
    public ProjectManager() {
    }

    public ProjectManager(String name, String surname) {
        super(name, surname);
    }

    public ProjectManager(String name, String surname, int salary, int work_exp) {
        super(name, surname, salary, work_exp);
    }

    public ProjectManager(int id, String name, String surname, int salary, int work_exp) {
        super(id, name, surname, salary, work_exp);
    }
}
