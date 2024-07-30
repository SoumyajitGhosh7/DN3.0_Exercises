package com.taskmanagement.service;

import com.taskmanagement.model.Task;

public class Node {
	 Task task;
	 Node next;
	public Node(Task task) {
		
		this.task = task;
		this.next =null;
	}
	public Node getNext() {
		return this.next;
	}
	public void setNext(Node newNode) {
		this.next=newNode;
		
	}
	public Task getTask() {
		return this.task;
	}	
	
}
