package com.taskmanagement.main;

import java.util.Scanner;

import com.taskmanagement.model.Task;
import com.taskmanagement.service.Node;
import com.taskmanagement.service.TaskManager;

public class MainClass {
	public static void main(String[] args) {
		
	
	TaskManager tm = new TaskManager();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    Node head=null;

    while (!exit) {
        System.out.println("\nTask Management System");
        System.out.println("1. Add Task");
        System.out.println("2. Search Task");
        System.out.println("3. Traverse Tasks");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Task ID: ");
                String taskId = scanner.nextLine();
                System.out.print("Enter Task Name: ");
                String taskName = scanner.nextLine();
                System.out.print("Enter Status: ");
                String status = scanner.nextLine();
                Task newTask = new Task(taskId, taskName, status);
                
                head=tm.addTask(head,newTask);
                
                System.out.println("Task added successfully.");
                break;

            case 2:
                System.out.print("Enter Task ID to search: ");
                String searchTaskId = scanner.nextLine();
                Task searchTask = tm.searchTask(head,searchTaskId);
                if (searchTask != null) {
                    System.out.println("Task found: " + searchTask);
                } else {
                    System.out.println("Task not found.");
                }
                break;

            case 3:
                System.out.println("All Tasks:");
                tm.traverseTasks(head);
                break;

            case 4:
            	
                System.out.print("Enter Task ID to delete: ");
                String deleteTaskId = scanner.nextLine();
                head = tm.deleteTask(head,deleteTaskId);
                System.out.println("Task deleted successfully.");
                break;

            case 5:
                exit = true;
                System.out.println("Exiting the system.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    scanner.close();
}
}
