package com.company.repository.interfaces;

import com.company.enteties.DataAnalyst;
import com.company.enteties.Developer;

import java.util.List;

public interface IDataAnalystRepository {
    boolean addDataAnalyst(DataAnalyst dataAnalyst);

    DataAnalyst getDataAnalyst(int id);

    List<DataAnalyst> getAllAnalysts();
}
