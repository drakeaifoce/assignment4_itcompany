package com.company.repository.interfaces;

import com.company.enteties.Developer;

import java.util.List;

public interface IDeveloperRepository {
    boolean addDeveloper(Developer developer);

    Developer getDeveloper(int id);

    List<Developer> getAllDevelopers();
}
