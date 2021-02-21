package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repository.DataAnalystRepository;
import com.company.repository.interfaces.IDataAnalystRepository;
import com.company.repository.DeveloperRepository;
import com.company.repository.interfaces.IDeveloperRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IDeveloperRepository developerRepository = new DeveloperRepository(db);
        IDataAnalystRepository dataAnalystRepository = new DataAnalystRepository(db);

        FrontEnd app = new FrontEnd(developerRepository, dataAnalystRepository);
        app.start();
    }
}
