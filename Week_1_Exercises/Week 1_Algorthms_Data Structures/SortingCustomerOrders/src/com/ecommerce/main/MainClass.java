package com.ecommerce.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.ecommerce.model.Order;
import com.ecommerce.service.SortingService;

public class MainClass {
	public static void main(String[] args) {
		
	
	ArrayList<Order> orders = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.print("Enter Order ID (or 'exit' to finish): ");
        String orderId = scanner.nextLine();
        if (orderId.equalsIgnoreCase("exit")) {
            break;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Total Price: ");
        double totalPrice = scanner.nextDouble();
        scanner.nextLine(); 

        orders.add(new Order(orderId, customerName, totalPrice));
    }

    System.out.print("Choose sorting method (1 for Bubble Sort, 2 for Quick Sort): ");
    int sortingChoice = scanner.nextInt();

    if (sortingChoice == 1) {
        SortingService.bubbleSort(orders);
        System.out.println("\nOrders sorted using Bubble Sort:");
    } else if (sortingChoice == 2) {
        SortingService.quickSort(orders, 0, orders.size() - 1);
        System.out.println("\nOrders sorted using Quick Sort:");
    } else {
        System.out.println("Invalid choice. Exiting.");
    }

    for (Order order : orders) {
        System.out.println(order);
    }

    scanner.close();
}

}
