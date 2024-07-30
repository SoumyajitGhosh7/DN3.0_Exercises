package com.inventorymanagement.driver;

import java.util.Scanner;

import com.inventorymanagement.service.InventoryManagement;
import com.inventoymanagement.model.Product;

public class MainClass {
	public static void main(String[] args) {
		InventoryManagement inventoryManagement = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to Inventory Management System\n");
        while (!exit) {
            
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    Product newProduct = new Product(productId, productName, quantity, price);
                    inventoryManagement.addProduct(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    String updateProductId = scanner.nextLine();
                    System.out.print("Enter Updated Product Name: ");
                    String updateProductName = scanner.nextLine();
                    System.out.print("Enter Updated Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter Updated Price: ");
                    double updatePrice = scanner.nextDouble();
                    Product updatedProduct = new Product(updateProductId, updateProductName, updateQuantity, updatePrice);
                    if(inventoryManagement.updateProduct(updateProductId, updatedProduct))
                    System.out.println("Product updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteProductId = scanner.nextLine();
                    if(inventoryManagement.deleteProduct(deleteProductId))
                    System.out.println("Product deleted successfully.");
                    break;

                case 4:
                    System.out.println("All Products:");
                    inventoryManagement.displayAllProducts();
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
