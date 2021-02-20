package com.company;

import com.company.controller.DeveloperController;
import com.company.enteties.Developer;
import com.company.repository.interfaces.IDeveloperRepository;

import java.util.Scanner;

public class FrontEnd {
    private final DeveloperController controller;
    private final Scanner scanner;

    public FrontEnd(IDeveloperRepository developerRepository) {
        controller = new DeveloperController(developerRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to the Darkhans' IT Company");
            System.out.println("Select option:");
            System.out.println("1. Get all developers");
            System.out.println("2. Get developer by id");
            System.out.println("3. Add developer to the database");

            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllDevelopersMenu();
                } else if (option == 2) {
                    getDeveloperByIdMenu();
                } else if (option == 3) {
                    addDeveloperMenu();
                } else {
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
        String response = controller.getAllDevelopers();
        System.out.println(response);
    }

    public void getDeveloperByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Developer developer = controller.getDeveloper(id);
        System.out.println((developer == null ? "Developer was not found!" : developer.toString()));
    }

    public void addDeveloperMenu() {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter age");
        int age = scanner.nextInt();
        System.out.println("Enter degree");
        String degree = scanner.next();
        System.out.println("Enter gender");
        String gender = scanner.next();
        System.out.println("Enter email");
        String email = scanner.next();
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

        String response = controller.addDeveloper(name, surname, age, degree, gender, email, work_exp, programming_lang, middle, senior);
        System.out.println(response);
    }
}
