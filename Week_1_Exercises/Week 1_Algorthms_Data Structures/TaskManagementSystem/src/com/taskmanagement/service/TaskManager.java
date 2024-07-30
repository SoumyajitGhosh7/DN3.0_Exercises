package com.taskmanagement.service;

import com.taskmanagement.model.Task;

public class TaskManager {
	public Node addTask(Node head, Task newTask) {
        Node newNode = new Node(newTask);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        return head;
    }

    public Node deleteTask(Node head, String taskId) {
        if (head == null) {
            return null;
        }
        if (head.getTask().getTaskId().equals(taskId)) {
            return head.getNext();
        }
        Node current = head;
        while (current.getNext() != null && !current.getNext().getTask().getTaskId().equals(taskId)) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
        return head;
    }
    
    public Task searchTask(Node head, String taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId().equals(taskId)) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }
	
	public void traverseTasks(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.getNext();
        }
    }
}
