package com.example.Sort;
import com.example.Linked_list.linked_list;
import com.example.Linked_list.Node;

// shell sort menggunakan linked list sangat - sangat tidak efisien 
// ini dibuat hanya untuk menguji kemampuan java saja(demo)
public class ShellSort {

    // membuat 3 method utama untuk helper pada shell sort
    public static Node getNodeAtIndex(Node head, int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.getNext();
        }
        return current; 
    }

    public static int getSize(Node head) {
        int besar = 0;
        Node current = head;
        while (current != null) {
            besar++;
            current = current.getNext();
        }
        return besar;
    }

    public static Node shellsort(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        int size = getSize(head);

        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                Node tempNode = getNodeAtIndex(head, i);
                int tempData = tempNode.getData();
                int j;
                for (j = i; j >= gap; j -= gap) {
                    Node prevNode = getNodeAtIndex(head, j - gap);
                    if (prevNode.getData() > tempData) {
                        Node currentNode = getNodeAtIndex(head, j);
                        currentNode.setData(prevNode.getData());
                    } else {
                        break;
                    }
                }
                Node insertNode = getNodeAtIndex(head, j);
                insertNode.setData(tempData);
            }
        }
        return head;
    }
    
}
