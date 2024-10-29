package com.example.al_dat_20105865_asgn;

public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    // Insert at the end of the list
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at the beginning of the list
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at a specific position (0-based index)
    public void insertAtPosition(T data, int position) {
        if (position <= 0) {
            insertAtBeginning(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int count = 0;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // Insert at the end if position is greater than the length
        if (current == null) {
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;

            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;  // Update tail if new node is at the end
            }

            current.next = newNode;
        }
    }

    // Print the list from head to tail
    public void printList() {
        Node<T> currNode = head;
        System.out.print("Doubly Linked List (Head to Tail): ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // Print the list from tail to head
    public void printReverse() {
        Node<T> currNode = tail;
        System.out.print("Doubly Linked List (Tail to Head): ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.prev;
        }
        System.out.println();
    }

    // Search for a specific element in the list
    public boolean search(T data) {
        Node<T> currNode = head;

        while (currNode != null) {
            if (currNode.data.equals(data)) {
                return true;  // Data found
            }
            currNode = currNode.next;
        }
        return false; // Data not found
    }

    // Delete the first occurrence of a given data
    public void delete(T data) {
        Node<T> currNode = head;

        // Traverse the list to find the node to delete
        while (currNode != null) {
            if (currNode.data.equals(data)) {
                // Case 1: Node to be deleted is the head
                if (currNode == head) {
                    head = currNode.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null; // List is now empty
                    }
                }
                // Case 2: Node to be deleted is the tail
                else if (currNode == tail) {
                    tail = currNode.prev;
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        head = null; // List is now empty
                    }
                }
                // Case 3: Node to be deleted is in the middle
                else {
                    currNode.prev.next = currNode.next;
                    currNode.next.prev = currNode.prev;
                }
                return; // Data found and deleted; exit the method
            }
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Test insertions
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.printList();  // Output: 1 3 4

        list.insertAtBeginning(0);
        list.printList();  // Output: 0 1 3 4

        list.insertAtPosition(2, 2);
        list.printList();  // Output: 0 1 2 3 4

        list.insertAtPosition(5, 10); // Inserts at the end since position > length
        list.printList();  // Output: 0 1 2 3 4 5
    }
}
