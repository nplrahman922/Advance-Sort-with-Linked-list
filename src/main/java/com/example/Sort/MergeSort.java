package com.example.Sort;

import com.example.Linked_list.linked_list;
import com.example.Linked_list.Node;

public class MergeSort {
    

    public static Node merge(Node a, Node b) {
        // basis
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        // rekursif
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(merge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(merge(a, b.getNext()));
        }

        return result;
    }

    public static Node mergeSort(Node head) {

        // validasi jika linkedlist kosong atau hanya memiliki satu elemen
        if (head == null || head.getNext() == null) {
            return head;
        }
        // algoritma kura - kura & kelinci katanya lebih efisien daripada loop biasa (T_T) 
        // membagi linkedlist menjadi 2 bagian
        Node cepat = head; // kelinci (>_<)
        Node lambat = head; // kura - kura (D:)
        Node prev = null; // untuk menyimpan node setelah lambat(XD)

        while(cepat != null && cepat.getNext() != null) {

            prev = lambat;
            lambat = lambat.getNext();
            cepat = cepat.getNext().getNext();

        }

        if (prev != null) {
            prev.setNext(null); // memutuskan linkedlist menjadi 2 bagian
        }

        // memanggil fungsi mergeSort secara rekursif pada kedua bagian
        Node kiri = head;
        Node kanan = lambat;   
        
        Node sortedA = mergeSort(kiri);
        Node sortedB = mergeSort(kanan);

        return merge(sortedA, sortedB);


    }
}
