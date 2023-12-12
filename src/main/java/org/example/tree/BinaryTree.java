package org.example.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
  BinaryTreeNode root;

  public void insert(BinaryTreeNode node) {
    if (root == null) {
      root = node;
      return;
    }
    Deque<BinaryTreeNode> deque = new LinkedList<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      BinaryTreeNode poppedNode = deque.pop();
      if (poppedNode.left == null) {
        poppedNode.left = node;
        return;
      } else deque.add(poppedNode.left);

      if (poppedNode.right == null) {
        poppedNode.right = node;
        return;
      } else deque.add(poppedNode.right);
    }
  }

  public void print() {
    Deque<BinaryTreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    System.out.println();
    while (!deque.isEmpty()) {
      BinaryTreeNode poppedNode = deque.pop();
      System.out.print(poppedNode.value + "\t");
      if (poppedNode.left != null) {
        deque.add(poppedNode.left);
      }
      if (poppedNode.right != null) {
        deque.add(poppedNode.right);
      }
    }
  }

  private int findMin(BinaryTreeNode node) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }

    int left = findMin(node.left);
    int right = findMin(node.right);

    return Math.min(node.value, Math.min(left, right));
  }

  private void preorder(BinaryTreeNode node) {
    if (node == null) return;
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);
  }

  private int height(BinaryTreeNode node) {
    if (node == null) return 0;
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  private int sizeOfTree(BinaryTreeNode node) {
    if (node == null) return 0;
    return sizeOfTree(node.left) + sizeOfTree(node.right) + 1;
  }

  private BinaryTreeNode lastNodeInBinaryTree() {
    if (root == null) return null;
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    BinaryTreeNode tmp = null;
    queue.offer(root);
    while (!queue.isEmpty()) {
      tmp = queue.poll();
      if (tmp.left != null) queue.offer(tmp.left);
      if (tmp.right != null) queue.offer(tmp.right);
    }
    return tmp;
  }

  private int maxDepth() {
    if (root == null) return 0;
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(root);
    int maxDepth = 0;
    BinaryTreeNode prev = null;
    while (!stack.isEmpty()) {
      BinaryTreeNode current = stack.peek();
      if (prev == null || prev.left == current || prev.right == current) {
        if (current.left != null) stack.push(current.left);
        if (current.right != null) stack.push(current.right);
      } else if (current.left == prev) {
        if (current.right != null) stack.push(current.right);
      } else stack.pop();
      prev = current;
      maxDepth = Math.max(maxDepth, stack.size());
    }
    return maxDepth;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    for (int i = 0; i <= 90; i++) {
      binaryTree.insert(new BinaryTreeNode(i));
    }

    System.out.println(binaryTree.height(binaryTree.root));

    System.out.println(binaryTree.sizeOfTree(binaryTree.root));

    System.out.println(binaryTree.lastNodeInBinaryTree().value);
  }
}
