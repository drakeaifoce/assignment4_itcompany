package com.company.controller;

import com.company.enteties.Developer;
import com.company.repository.interfaces.IDeveloperRepository;

import java.util.List;

public class DeveloperController
{
    private final IDeveloperRepository developerRepository;

    public DeveloperController(IDeveloperRepository developerRepository){
        this.developerRepository = developerRepository;
    }

    public String addDeveloper(String name, String surname, int salary, int work_exp, String programming_lang,  boolean middle, boolean senior)
    {
        Developer developer = new Developer(name, surname, salary, work_exp, programming_lang , middle, senior);

        boolean created = developerRepository.addDeveloper(developer);

        return (created ? "Developer was added!" : "Developer adding was failed");
    }

    public Developer getDeveloper(int id) {
        Developer developer = developerRepository.getDeveloper(id);

        return developer;
    }

    public String getAllDevelopers() {
        List<Developer> developers = developerRepository.getAllDevelopers();

        return developers.toString();
    }
}
