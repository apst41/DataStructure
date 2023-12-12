package org.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Main {
  /*



  class D extends B
  class B extends A

  Object Type Hierarchy Tree
             Object
         A           G
      B     C        H
      D   E   F    I   J

  PL internal representation of Type Hierarchy

  Find the best type  of 2 objects
  // Example:
    D & E = A
    I & F = Object
    I & J = H

  Several Use cases:

  x =  condition ? st1 : st2;
  st1 of type D
  st2 of type F

  Type of x -- ?

  // Trying to infer the type of an
  //   If-Else statement
  //   Terinary (:) operators
  //   Return of a function

    condition ? statement1 : statement2
    statement1 is a object of class1
    statement2 is a object of class2


  // Other use cases
  // Find the common function in hierarchy
  // to execute on these two objects, for
  // example +
  */

  /*
  E = {name: "E"}; F = {name: "F"}
  C = {name: "C", left: E, right: F}
  D = {name: "D"};
  B = {name: "B", left: D}
  A = {name: "A", left: B, right: C};


  I = {name: "I"}; J = {name: "J"};
  H = {name: "H", left: I, right: J};
  G = {name: "G", left: H};

  Object = {name: "Object", left: A, right: G};
  Root = Object;

              Root
         A           G
      B     C        H
    D     E   F    I   J
  */

  private static Set<String> set = new HashSet<>();

  static class Node {
    String name;
    Node left, right;

    Node(String name) {
      this.name = name;
      this.left = null;
      this.right = null;
    }

    Node(String name, Node a) {
      this.name = name;
      this.left = a;
      this.right = null;
    }

    Node(String name, Node a, Node b) {
      this.name = name;
      this.left = a;
      this.right = b;
    }
  }
  /*


              Object
         A           G
      B     C        H
    D     E   F    I   J
  */

  static Node e = new Node("E");
  static Node f = new Node("F");
  static Node c = new Node("C", e, f);

  static Node d = new Node("D");
  static Node b = new Node("B", d);
  static Node a = new Node("A", b, c);

  static Node i = new Node("I");
  static Node j = new Node("J");
  static Node h = new Node("H", i, j);
  static Node g = new Node("G", h);

  static Node root = new Node("Object", a, g);

  public static String inferBaseType(Node[] nodes) {

    return helper(nodes, root).name;
  }

  private static Node helper(Node[] nodes, Node no) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(no);

    Node node = null;

    while (!queue.isEmpty()) {
      set.clear();
      node = queue.poll();

      getChildNode(node.left);

      int count = countNode(nodes, set);

      if (count == nodes.length) {
        queue.add(node.left);
      } else if (count == 0) {
        queue.add(node.right);
      }
    }

    return node;
  }

  private static int countNode(Node[] nodes, Set<String> set) {

    int count = 0;
    for (Node node : nodes) {
      if (set.contains(node.name)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {

    System.out.println("Hello world!" + inferBaseType(new Node[] {d, f}));
  }

  private static Set<String> getChildNode(Node node) {
    if (node == null) return set;

    getChildNode(node.left);
    set.add(node.name);
    getChildNode(node.right);

    return set;
  }
}
