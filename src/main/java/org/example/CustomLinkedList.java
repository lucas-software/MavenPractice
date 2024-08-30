package org.example;

import java.util.Objects;

public class CustomLinkedList<T> {
    private Node head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add element to the end of the list
    public void add(int quantity) {
        Node newNode = new Node(quantity);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove element from the list
    public boolean remove(int quantity) {
        if (head == null) {
            return false; // List is empty
        }

        if (Objects.equals(head.quantity, quantity)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        Node prev = null;

        while (current != null && !Objects.equals(current.quantity, quantity)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false; // Element not found
        }

        prev.next = current.next;
        size--;
        return true;
    }


    // Get element at a specific index
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.quantity;
    }

    // Check if the list contains a specific element
    public boolean contains(int quantity) {
        Node current = head;
        while (current != null) {
            if (current.quantity == quantity) { // Use == for primitive type comparison
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // Get the size of the list
    public int size() {
        return size;
    }
}
