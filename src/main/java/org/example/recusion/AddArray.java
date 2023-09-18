package org.example.recusion;

import java.util.Arrays;

public class AddArray {
  private static void addArray(int[] array, int n) {
    if (n == 0) return;
    addArray(array, n - 1);
    array[n] = array[n] + array[n - 1];
  }

  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4, 5, 6};
    addArray(array, 5);
    Arrays.stream(array).sequential().forEach(data -> System.out.print(data + "\t"));
  }
}
