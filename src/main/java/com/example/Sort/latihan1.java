package com.example.Sort;
import com.example.Linked_list.Node;
import com.example.Linked_list.linked_list;

public class latihan1 {

    public static Node merge(Node a, Node b) { // fungsi menggabungkan dua linked list terurut
        if (a == null) return b; // jika perbandingan a kosong, kembalikan b
        if (b == null) return a; // jika perbandingan b kosong, kembalikan a

        Node result; // node hasil penggabungan

        if (a.getData() <= b.getData()) { // fungsi rekursif
            result = a;
            result.setNext(merge(a.getNext(), b)); // membuat variabel b setelah variabel a 
        } else {
            result = b;
            result.setNext(merge(a, b.getNext()));
        }

        return result;
    }
    public static Node mergeSort2 (Node head) {
        if (head == null || head.getNext() ==null) {
            return head;
        }

        Node middle = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.getNext() != null) {
            prev = middle;
            middle = middle.getNext();
            fast = fast.getNext().getNext();
        }

        if (prev != null) {
            prev.setNext(null);
        }

        Node sortedLeft = mergeSort2(prev);
        Node sortedRight = mergeSort2(middle);

        return merge(sortedLeft, sortedRight);
    }

}
