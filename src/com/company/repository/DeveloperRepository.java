package com.company.repository;

import com.company.data.interfaces.IDB;
import com.company.enteties.Developer;
import com.company.repository.interfaces.IDeveloperRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository implements IDeveloperRepository {
    private final IDB db;

    public DeveloperRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addDeveloper(Developer developer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO developers(name, surname, salary, work_exp, programming_lang, middle, senior) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, developer.getName());
            st.setString(2, developer.getSurname());
            st.setInt(3, developer.getSalary());
            st.setInt(4, developer.getWork_exp());
            st.setString(5, developer.getProgramming_lang());
            st.setBoolean(6, developer.isMiddle());
            st.setBoolean(7, developer.isSenior());


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
    public Developer getDeveloper(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, surname, salary, work_exp, programming_lang, middle, senior FROM developers WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Developer developer = new Developer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("salary"),
                        rs.getInt("work_exp"),
                        rs.getString("programming_lang"),
                        rs.getBoolean("middle"),
                        rs.getBoolean("senior"));

                return developer;
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
    public List<Developer> getAllDevelopers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, surname, salary, work_exp, programming_lang, middle, senior from developers";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Developer> developers = new ArrayList<>();
            while (rs.next()) {
                Developer developer = new Developer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("salary"),
                        rs.getInt("work_exp"),
                        rs.getString("programming_lang"),
                        rs.getBoolean("middle"),
                        rs.getBoolean("senior"));

                developers.add(developer);
            }

            return developers;
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
