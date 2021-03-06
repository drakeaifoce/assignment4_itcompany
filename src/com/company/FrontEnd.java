package com.company;

import com.company.controller.DataAnalystController;
import com.company.controller.DeveloperController;
import com.company.controller.ProjectManagerController;
import com.company.enteties.DataAnalyst;
import com.company.enteties.Developer;
import com.company.enteties.ProjectManager;
import com.company.repository.DataAnalystRepository;
import com.company.repository.interfaces.IDeveloperRepository;
import com.company.repository.interfaces.IDataAnalystRepository;
import com.company.Main;
import com.company.repository.interfaces.IProjectManagerRepository;


import java.util.Scanner;

public class FrontEnd {
    private final DeveloperController developerController;
    private final DataAnalystController dataAnalystController;
    private final ProjectManagerController projectManagerController;
    private final Scanner scanner;

    public FrontEnd(IDeveloperRepository developerRepository, IDataAnalystRepository dataAnalystRepository, IProjectManagerRepository projectManagerRepository) {
        developerController = new DeveloperController(developerRepository);
        dataAnalystController = new DataAnalystController(dataAnalystRepository);
        projectManagerController = new ProjectManagerController(projectManagerRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to the Darkhans' IT Company");
            System.out.println("Select option:");
            System.out.println("3. Get all developers");
            System.out.println("4. Get developer by id");
            System.out.println("5. Add developer to the database");
            System.out.println("6. Get all data analysts");
            System.out.println("7. Get data analyst by id");
            System.out.println("8. Add data analyst to the database");
            System.out.println("9. Get all project managers");
            System.out.println("10. Get project manager by id");
            System.out.println("11. Add project manager to the database");

            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (0-11): ");
                int option = scanner.nextInt();
                if (option == 3) {
                    getAllDevelopersMenu();
                } else if (option == 4) {
                    getDeveloperByIdMenu();
                } else if (option == 5) {
                    addDeveloperMenu();
                } else if (option == 6) {
                    getAllDataAnalystsMenu();
                } else if (option == 7) {
                    getDataAnalystByIdMenu();
                } else if (option == 8) {
                    addManagerMenu();
                }else if (option == 9) {
                    getAllManagersMenu();
                } else if (option == 10) {
                    getDataAnalystByIdMenu();
                } else if (option == 11) {
                    addManagerMenu();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println();
        }
    }

    public void getAllDevelopersMenu() {
        String response = developerController.getAllDevelopers();
        System.out.println(response);
    }

    public void getDeveloperByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Developer developer = developerController.getDeveloper(id);
        System.out.println((developer == null ? "Developer was not found!" : developer.toString()));
    }

    public void addDeveloperMenu() {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter salary");
        int salary = scanner.nextInt();
        System.out.println("Enter working experience");
        int work_exp = scanner.nextInt();
        System.out.println("Enter developers' main programming language");
        String programming_lang = scanner.next();
        System.out.println("Is he middle developer? ( Yes/No )");
        String mid = scanner.next();
        boolean middle = false;
        boolean senior = false;
        if (mid.equals("Yes")) {
            middle = true;
        } else {
            System.out.println("Is he senior developer? ( Yes/No )");
            String sen = scanner.next();
            if (sen.equals("Yes")) {
                senior = true;
            }
        }

        String response = developerController.addDeveloper(name, surname, salary, work_exp, programming_lang, middle, senior);
        System.out.println(response);
    }

    public void getAllDataAnalystsMenu() {
        String response = dataAnalystController.getAllDataAnalysts();
        System.out.println(response);
    }

    public void getDataAnalystByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        DataAnalyst dataAnalyst = dataAnalystController.getDataAnalyst(id);
        System.out.println((dataAnalyst == null ? "Data Analyst was not found!" : dataAnalyst.toString()));
    }

    public void addDataAnalystMenu() {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter salary");
        int salary = scanner.nextInt();
        System.out.println("Enter working experience");
        int work_exp = scanner.nextInt();
        System.out.println("Enter skill");
        String skill = scanner.next();

        String response = dataAnalystController.addDataAnalyst(name, surname, salary, work_exp, skill);
        System.out.println(response);
    }

    public void getAllManagersMenu() {
        String response = projectManagerController.getAllManagers();
        System.out.println(response);
    }

    public void getManagerByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        ProjectManager projectManager = projectManagerController.getManager(id);
        System.out.println((projectManager == null ? "Data Analyst was not found!" : projectManager.toString()));
    }

    public void addManagerMenu() {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter salary");
        int salary = scanner.nextInt();
        System.out.println("Enter working experience");
        int work_exp = scanner.nextInt();

        String response = projectManagerController.addProjectManager(name, surname, salary, work_exp);
        System.out.println(response);
    }
}
