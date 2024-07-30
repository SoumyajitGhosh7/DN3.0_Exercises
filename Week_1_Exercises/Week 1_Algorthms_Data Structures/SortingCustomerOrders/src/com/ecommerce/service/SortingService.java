package com.ecommerce.service;

import java.util.ArrayList;

import com.ecommerce.model.Order;

public class SortingService {
	public static void bubbleSort(ArrayList<Order> orders) {
        int n = orders.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders.get(j).getTotalPrice() > orders.get(j + 1).getTotalPrice()) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(ArrayList<Order> orders, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(orders, low, high);
            quickSort(orders, low, partitionIndex - 1);
            quickSort(orders, partitionIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Order> orders, int low, int high) {
        Order pivot = orders.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() <= pivot.getTotalPrice()) {
                i++;
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);
        return i + 1;
    }
}
