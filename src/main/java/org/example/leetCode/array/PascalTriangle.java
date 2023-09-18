package org.example.leetCode.array;

public class PascalTriangle {

  static void pascalTriangle(int n) {
    for (int line = 1; line <= n; line++) {

      int C = 1; // used to represent C(line, i)
      for (int i = 1; i <= line; i++) {
        System.out.print(C + " ");
        C = C * (line - i) / i;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pascalTriangle(4);
  }
}
