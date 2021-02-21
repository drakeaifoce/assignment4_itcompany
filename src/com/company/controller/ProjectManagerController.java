package com.company.controller;

import com.company.enteties.DataAnalyst;
import com.company.enteties.ProjectManager;
import com.company.repository.interfaces.IDataAnalystRepository;
import com.company.repository.interfaces.IProjectManagerRepository;

import java.util.List;

public class ProjectManagerController {
    private final IProjectManagerRepository projectManagerRepository;

    public ProjectManagerController(IProjectManagerRepository projectManagerRepository){
        this.projectManagerRepository = projectManagerRepository;
    }

    public String addProjectManager(String name, String surname, int salary, int work_exp)
    {
        ProjectManager projectManager = new ProjectManager(name, surname, salary, work_exp);

        boolean created = projectManagerRepository.addProjectManager(projectManager);

        return (created ? "Project Manager adding was failed" : "Project Manager was added!");
    }

    public ProjectManager getManager(int id) {
        ProjectManager projectManager = projectManagerRepository.getManager(id);

        return projectManager;
    }

    public String getAllManagers() {
        List<ProjectManager> projectManagers = projectManagerRepository.getAllManagers();

        return projectManagers.toString();
    }
}
