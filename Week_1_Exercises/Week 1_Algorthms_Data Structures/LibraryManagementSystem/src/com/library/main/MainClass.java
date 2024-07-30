package com.library.main;

import com.library.model.Book;
import com.library.service.LibraryManagementSystem;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem lms = new LibraryManagementSystem();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Traverse Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookId, title, author);
                    if (lms.addBook(newBook)) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Failed to add book.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitleLinear = scanner.nextLine();
                    Book foundBookLinear = lms.linearSearchByTitle(searchTitleLinear);
                    if (foundBookLinear != null) {
                        System.out.println("Book found: " + foundBookLinear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitleBinary = scanner.nextLine();
                    Book foundBookBinary = lms.binarySearchByTitle(searchTitleBinary);
                    if (foundBookBinary != null) {
                        System.out.println("Book found: " + foundBookBinary);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("All Books:");
                    lms.traverseBooks();
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
