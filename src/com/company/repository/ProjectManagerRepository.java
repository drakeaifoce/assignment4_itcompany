package com.company.repository;

import com.company.data.interfaces.IDB;
import com.company.enteties.ProjectManager;
import com.company.repository.interfaces.IProjectManagerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerRepository implements IProjectManagerRepository {
    private final IDB db;

    public ProjectManagerRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addProjectManager(ProjectManager projectManager) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO projectmanager(name, surname, salary, work_exp) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, projectManager.getName());
            st.setString(2, projectManager.getSurname());
            st.setInt(3, projectManager.getSalary());
            st.setInt(4, projectManager.getWork_exp());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ProjectManager getManager(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, surname, salary, work_exp FROM projectmanager WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProjectManager projectManager = new ProjectManager(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("salary"),
                        rs.getInt("work_exp"));

                return projectManager;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<ProjectManager> getAllManagers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, surname, salary, work_exp, skill from projectmanager";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<ProjectManager> projectManagers = new ArrayList<>();
            while (rs.next()) {
                ProjectManager projectManager = new ProjectManager(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("salary"),
                        rs.getInt("work_exp"));
                projectManagers.add(projectManager);
            }

            return projectManagers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
