package org.example.tree;

import lombok.Data;

@Data
public class BinaryTreeNode {
  BinaryTreeNode left;
  BinaryTreeNode right;
  int value;

  public BinaryTreeNode(int value) {
    this.left = null;
    this.right = null;
    this.value = value;
  }
}
