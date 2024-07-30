package com.ecommerce.main;

import com.ecommerce.model.Product;
import com.ecommerce.search.SearchAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SearchApp {

    
    public static Product[] getProductsFromUser() {
        Scanner scanner = new Scanner(System.in);

        
        Product[] products = new Product[10];
        int index = 0;

        // Adding products
        System.out.println("Enter number of products to add (up to 10):");
        int numProducts = scanner.nextInt();
        scanner.nextLine();

        while (index < products.length && numProducts > 0) {
            System.out.println("Enter details for product " + (index + 1) + ":");
            System.out.print("Enter product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter product category: ");
            String category = scanner.nextLine();

            products[index++] = new Product(productId, productName, category);
            numProducts--;
        }

        
        return Arrays.copyOf(products, index);
    }

    
    public static String getSearchTermFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search term (product ID or product name): ");
        return scanner.nextLine();
    }

    
    public static void main(String[] args) {
        Product[] products = getProductsFromUser();

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        String searchTerm = getSearchTermFromUser();

        // Linear Search
        Product foundProductLinear = SearchAlgorithms.linearSearch(products, searchTerm);
        System.out.println("Linear Search Result: " + (foundProductLinear != null ? foundProductLinear : "Not Found"));

        // Binary Search
        Product foundProductBinary = SearchAlgorithms.binarySearch(products, searchTerm);
        System.out.println("Binary Search Result: " + (foundProductBinary != null ? foundProductBinary : "Not Found"));
        
    }
}
