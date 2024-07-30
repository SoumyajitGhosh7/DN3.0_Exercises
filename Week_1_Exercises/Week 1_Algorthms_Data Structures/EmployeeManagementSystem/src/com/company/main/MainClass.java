package com.company.main;

import com.company.model.Employee;
import com.company.service.EmployeeManagementSystem;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter thne number of employee you want to add");
        int n=scanner.nextInt();
        EmployeeManagementSystem ems = new EmployeeManagementSystem(n);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String employeeId = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Employee newEmployee = new Employee(employeeId, name, position, salary);
                    if (ems.addEmployee(newEmployee)) {
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Failed to add employee. Array might be full.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchEmployeeId = scanner.nextLine();
                    Employee searchedEmployee = ems.searchEmployee(searchEmployeeId);
                    if (searchedEmployee != null) {
                        System.out.println("Employee found: " + searchedEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("All Employees:");
                    ems.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteEmployeeId = scanner.nextLine();
                    if (ems.deleteEmployee(deleteEmployeeId)) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Failed to delete employee. Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

