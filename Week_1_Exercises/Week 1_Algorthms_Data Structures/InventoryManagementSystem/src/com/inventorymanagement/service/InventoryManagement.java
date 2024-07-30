package com.inventorymanagement.service;

import java.util.HashMap;

import com.inventoymanagement.model.Product;

public class InventoryManagement {
	private HashMap<String ,Product>inventory;
	
	public InventoryManagement() {
		this.inventory=new HashMap<>();
	}
	
	public void addProduct(Product newProduct) {
		inventory.put(newProduct.getProductId(),newProduct);
	}
	
	public boolean updateProduct(String productId,Product updatedProduct) {
		if(inventory.containsKey(productId)) {
			inventory.put(productId, updatedProduct);
			return true;
		}else {
			System.out.println("No such Product found please check again\n");
			return false;
		}
		
	}
	
	public boolean deleteProduct(String productId) {
		if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            return true;
        } else {
            System.out.println("No such Product found please check again\n");
            return false;
        }
	}
	
	

    
    public void displayAllProducts() {
    	if(inventory.isEmpty()) {
    		System.out.println("Nothing in Inventory\n");
    		return;
    	}
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
