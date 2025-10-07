package com.example.Sort;
import com.example.Linked_list.linked_list;
import com.example.Linked_list.Node;

public class QuickSort {
 
    public static Node Pengendaliquicksort (Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        return Quicksort(head)[0];
    }

    public static Node[] Quicksort(Node head) {
        if (head == null || head.getNext() == null) {
            return new Node[] {head, head};
        }

        Node pivot = head;
        Node kecilpala = null, ekorkecil = null;
        Node besarpala = null, ekorbesar = null;
        Node current = head.getNext();

        while (current != null) {
            if (current.getData() < pivot.getData()){
                if (kecilpala == null) {
                    kecilpala = ekorkecil = current;
                } else {
                    ekorkecil.setNext(current);
                    ekorkecil = current;
                }
            } else {
                if (besarpala == null) {
                    besarpala = ekorbesar = current;
                } else {
                    ekorbesar.setNext(current);
                    ekorbesar = current;
                }
            }
            current = current.getNext();
        }
        if (ekorkecil != null) 
            ekorkecil.setNext(null);
        
        if (ekorbesar != null) 
            ekorbesar.setNext(null);
        
        Node[] sortingkecil = Quicksort(kecilpala);
        Node[] sortingbesar = Quicksort(besarpala);
        
        Node palabatu , ekorbatu;

        if (sortingkecil[0] != null) {
            
            palabatu = sortingkecil[0];
            sortingkecil[1].setNext(pivot);
        } else {
            palabatu = pivot;
        }

        pivot.setNext(sortingbesar[0]);

        if (sortingbesar[1] != null) {
            ekorbatu = sortingbesar[1];
        } else {
            ekorbatu = pivot;
        }

        return new Node[] {palabatu, ekorbatu};
    }
}