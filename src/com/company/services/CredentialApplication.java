package com.company.services;

import com.company.model.Employee;

import java.util.Scanner;

public class CredentialApplication {
    private static String firstName;
    private static String lastName;
    private static int depChoice;
    private static String department;

    private static void selectDepartment(int depChoice) {
        switch (depChoice) {
            case 1:
                department = "tech";
                break;
            case 2:
                department = "admin";
                break;
            case 3:
                department = "hr";
                break;
            case 4:
                department = "legal";
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Getting employee's details
        System.out.println("Enter the employee's first name");
        firstName = scanner.next();
        System.out.println("Enter the employee's last name");
        lastName = scanner.next();
        Employee employee = new Employee(firstName, lastName);

        //Choose department
        System.out.println("Please enter the department from the following");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        depChoice = scanner.nextInt();
        selectDepartment(depChoice);
        scanner.close();

        //Generate email, password and show the same
        System.out.println();//
        CredentialService service = new CredentialService(employee.getFirstName(), employee.getLastName(), department);
        service.generateEmailAddress();
        service.generatePassword();
        service.showCredential();
    }
}
