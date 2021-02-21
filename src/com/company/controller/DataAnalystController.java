package com.company.controller;

import com.company.enteties.DataAnalyst;
import com.company.repository.interfaces.IDataAnalystRepository;


import java.util.List;

public class DataAnalystController {
    private final IDataAnalystRepository dataAnalystRepository;

    public DataAnalystController(IDataAnalystRepository dataAnalystRepository){
        this.dataAnalystRepository = dataAnalystRepository;
    }

    public String addDataAnalyst(String name, String surname, int salary, int work_exp, String skill)
    {
        DataAnalyst dataAnalyst = new DataAnalyst(name, surname, salary, work_exp, skill);

        boolean created = dataAnalystRepository.addDataAnalyst(dataAnalyst);

        return (created ? "Data Analyst adding was failed" : "Data analyst was added!");
    }

    public DataAnalyst getDataAnalyst(int id) {
        DataAnalyst dataAnalyst = dataAnalystRepository.getDataAnalyst(id);

        return dataAnalyst;
    }

    public String getAllDataAnalysts() {
        List<DataAnalyst> dataAnalysts = dataAnalystRepository.getAllAnalysts();

        return dataAnalysts.toString();
    }
}
