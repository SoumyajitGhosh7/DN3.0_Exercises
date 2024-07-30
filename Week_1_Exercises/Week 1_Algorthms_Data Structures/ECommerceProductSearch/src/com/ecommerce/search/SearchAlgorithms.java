package com.ecommerce.search;

//import java.util.Arrays;

import com.ecommerce.model.Product;

public class SearchAlgorithms {

    // Linear Search
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductId().equals(searchTerm) || 
                product.getProductName().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search (requires sorted array)
    public static Product binarySearch(Product[] products, String searchTerm) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];
            
            if (midProduct.getProductId().equals(searchTerm) || 
                midProduct.getProductName().equalsIgnoreCase(searchTerm)) {
                return midProduct;
            } else if (searchTerm.compareTo(midProduct.getProductId()) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null; // Not found
    }
}
