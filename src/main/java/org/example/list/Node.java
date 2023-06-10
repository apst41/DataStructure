package org.example.list;

import lombok.Data;

@Data
public class Node {
  int data;
  Node next;
  Node bottom;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.bottom = null;
  }
}
