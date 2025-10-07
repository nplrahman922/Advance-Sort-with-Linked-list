package com.example.Linked_list;


public class linked_list {

    public Node head;
    
    public linked_list() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public boolean remove(int data) {
        if (this.head == null) {
            return false;
        }

        if (this.head.getData() == data) {
            this.head = this.head.getNext();
            return true;
        }

        Node temp = this.head;
        Node prev = null;

        while (temp != null && temp.getData() != data) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            return false;
        }

        prev.setNext(temp.getNext());
        return true;
    }

}