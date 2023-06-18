package org.example.leetCode.tree;

public class Symmetrical {
  private boolean isSymmetricalUtil(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;

    if (left == null || right == null) return false;

    return left.val == right.val
        && isSymmetricalUtil(left.left, right.right)
        && isSymmetricalUtil(left.right, right.left);
  }

  public boolean isSymmetric(TreeNode root) {
    return isSymmetricalUtil(root.left, root.right);
  }
}
