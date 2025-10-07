package com.example;
import com.example.Linked_list.linked_list;
import com.example.Sort.MergeSort;
import com.example.Sort.QuickSort;
import com.example.Linked_list.Node;


public class Main {
    public static void main(String[] args) {
        
        linked_list list = new linked_list();
        list.insert(10);
        list.insert(3);
        list.insert(5);
        list.insert(1);


        printList(list.head);
        Node Mergesort = CopyList(list.head);
        Node Quicksort = CopyList(list.head);
        Node Shellsort = CopyList(list.head);

        Mergesort = MergeSort.mergeSort(Mergesort);
        System.out.println("Setelah di Merge Sort : ");
        printList(Mergesort);
        Quicksort = QuickSort.Pengendaliquicksort(Quicksort);
        System.out.println("Setelah di Quick Sort : ");
        printList(Quicksort);
        Shellsort = com.example.Sort.ShellSort.shellsort(Shellsort);
        System.out.println("Setelah di Shell Sort : ");
        printList(Shellsort);
        
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static Node CopyList(Node head) {
        if (head == null) {
            return null;
        }

        Node newpala = new Node(head.getData());
        Node currentlama = head.getNext();
        Node currentbaru = newpala;

        while (currentlama != null) {
            currentbaru.setNext(new Node(currentlama.getData()));
            currentbaru = currentbaru.getNext();
            currentlama = currentlama.getNext();
        }

        return newpala;
    }
}