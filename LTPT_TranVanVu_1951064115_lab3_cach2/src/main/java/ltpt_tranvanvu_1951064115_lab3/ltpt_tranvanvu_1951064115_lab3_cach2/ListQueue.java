/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltpt_tranvanvu_1951064115_lab3.ltpt_tranvanvu_1951064115_lab3_cach2;

/**
 *
 * @author tranvanvu
 */
public class ListQueue {
    class Node {
        public String data;
        public Node next;
    }
    Node head = null, tail = null;
    public synchronized void enqueue(String data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        if (tail == null) {
            tail = temp;
            head = tail;
        } else {
            tail.next = temp;
            tail = temp;
        }
        notify();
    }
    public synchronized String dequeue() {
        while (head == null)
            Util.myWait(this);
        String returnval = head.data;
        if (head == tail) tail = null;
        head = head.next;
        return returnval;
    }
}
