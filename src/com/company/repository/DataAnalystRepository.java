package com.company.repository;

import com.company.data.interfaces.IDB;
import com.company.repository.interfaces.IDataAnalystRepository;
import com.company.enteties.DataAnalyst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAnalystRepository implements IDataAnalystRepository {
    private final IDB db;

    public DataAnalystRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addDataAnalyst(DataAnalyst dataAnalyst) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO dataanalyst(name, surname, salary, work_exp, skill) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, dataAnalyst.getName());
            st.setString(2, dataAnalyst.getSurname());
            st.setInt(3, dataAnalyst.getSalary());
            st.setInt(4, dataAnalyst.getWork_exp());
            st.setString(5, dataAnalyst.getSkill());

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
    public DataAnalyst getDataAnalyst(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, surname, salary, work_exp, skill FROM dataanalyst WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                DataAnalyst dataAnalyst = new DataAnalyst(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("salary"),
                        rs.getInt("work_exp"),
                        rs.getString("skill"));

                return dataAnalyst;
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
    public List<DataAnalyst> getAllAnalysts() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, surname, salary, work_exp, skill from dataanalyst";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<DataAnalyst> dataAnalysts = new ArrayList<>();
            while (rs.next()) {
                DataAnalyst dataAnalyst = new DataAnalyst(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("salary"),
                        rs.getInt("work_exp"),
                        rs.getString("skill"));
                dataAnalysts.add(dataAnalyst);
            }

            return dataAnalysts;
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
