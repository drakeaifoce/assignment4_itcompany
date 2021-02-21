package com.company.repository.interfaces;

import com.company.enteties.ProjectManager;

import java.util.List;

public interface IProjectManagerRepository {
    boolean addProjectManager(ProjectManager projectManager);

    ProjectManager getManager(int id);

    List<ProjectManager> getAllManagers();
}
