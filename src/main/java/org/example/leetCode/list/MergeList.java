package org.example.leetCode.list;

class ListNode {
  int data;
  ListNode next;

  ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }
}

public class MergeList {
  static ListNode mergeList(ListNode a, ListNode b) {
    if (a == null) return b;
    if (b == null) return a;
    ListNode result;
    if (a.data < b.data) {
      result = a;
      result.next = mergeList(a.next, b);
    } else {
      result = b;
      result.next = mergeList(b.next, a);
    }
    return result;
  }

  static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.data + "\t");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1, null);
    ListNode node1 = new ListNode(3, null);
    node.next = node1;

    ListNode node2 = new ListNode(2, null);
    ListNode node3 = new ListNode(4, null);
    node2.next = node3;

    printList(mergeList(node, node2));
  }
}
