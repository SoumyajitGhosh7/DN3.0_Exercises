package com.library.service;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LibraryManagementSystem {
    private ArrayList<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void traverseBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
