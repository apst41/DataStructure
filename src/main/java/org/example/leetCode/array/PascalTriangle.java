package org.example.leetCode.array;

public class PascalTriangle {

  int[][] pascalTriangle(int n) {
    int[][] array = new int[n][n];

    for (int line = 0; line < n; line++) {
      for (int i = 0; i <= line; i++) {
        if (i == 0 || i == line) array[line][i] = 0;
        else {
          array[line][i] = array[line - 1][i] + array[line - 1][i - 1];
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {}
}
