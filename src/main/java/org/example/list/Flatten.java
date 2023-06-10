package org.example.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Flatten {
  public static void flatten(Node root) {
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.data));
    while (root != null) {
      queue.add(root);
      root = root.next;
    }
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.print(node.data + "\t");
      if (node.bottom != null) {
        queue.add(node.bottom);
      }
    }
  }

  public static void main(String[] args) {
    Node head = new Node(5);
    Node temp = head;
    Node bt = head;

    bt.bottom = new Node(7);
    bt.bottom.bottom = new Node(8);
    bt.bottom.bottom.bottom = new Node(30);

    temp.next = new Node(10);
    temp = temp.next;

    bt = temp;
    bt.bottom = new Node(20);

    temp.next = new Node(19);
    temp = temp.next;

    bt = temp;
    bt.bottom = new Node(22);
    bt.bottom.bottom = new Node(50);

    temp.next = new Node(28);
    temp = temp.next;

    bt = temp;
    bt.bottom = new Node(35);
    bt.bottom.bottom = new Node(40);
    bt.bottom.bottom.bottom = new Node(45);

    // Calling function to flatten the linked list
    flatten(head);
  }
}
