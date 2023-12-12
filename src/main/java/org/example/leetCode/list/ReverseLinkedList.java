package org.example.leetCode.list;

import java.util.Stack;

class ReverseNode {
  int data;
  ReverseNode next;

  public ReverseNode(int data) {
    this.data = data;
    this.next = null;
  }
}

public class ReverseLinkedList {

  private static ReverseNode reverse(ReverseNode node) {
    Stack<ReverseNode> stack = new Stack<>();
    while (node != null) {
      stack.push(node);
      node = node.next;
    }
    ReverseNode head = stack.pop();
    ReverseNode current = head;

    while (!stack.isEmpty()) {
      current.next = stack.pop();
      current = current.next;
    }
    current.next = null;
    return head;
  }

  private static void reversePrintList(ReverseNode node) {
    if (node == null) return;
    reversePrintList(node.next);
    System.out.print(node.data + "-->");
  }

  private static void printListRecur(ReverseNode node) {
    if (node == null) return;

    System.out.print(node.data + "-->");
    printListRecur(node.next);
  }

  private static void print(ReverseNode node) {
    ReverseNode current = node;
    while (current != null) {
      System.out.print(current.data + "=>");
      current = current.next;
    }
  }

  private static ReverseNode reverseViaLoop(ReverseNode node) {
    ReverseNode current = node;
    ReverseNode prev = null;
    ReverseNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  private static ReverseNode reverseWithGroup(ReverseNode head, int k) {
    if (head == null) return null;
    ReverseNode current = head;
    ReverseNode prev = null;
    ReverseNode next = null;
    int count = 0;
    while (count < k && current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }
    if (next != null) {
      head.next = reverseWithGroup(next, count);
    }
    return prev;
  }

  private static ReverseNode reverseLinkedListRecursively(ReverseNode node) {
    if (node.next == null) {
      return node;
    }
    ReverseNode newNode = reverseLinkedListRecursively(node.next);
    node.next.next = node;
    node.next = null;
    return newNode;
  }

  public static void main(String[] args) {
    ReverseNode head = new ReverseNode(1);
    head.next = new ReverseNode(2);
    head.next.next = new ReverseNode(3);
    head.next.next.next = new ReverseNode(4);
    System.out.println();
    head = reverseLinkedListRecursively(head);
    print(head);
  }
}
