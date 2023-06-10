package org.example.array;

import java.util.Arrays;

public class CylindricalArray {
  static void rotate(int[] array) {

    int i = 0;
    int j = array.length - 1;
    int temp;
    while (i != j) {
      temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    rotate(array);
    System.out.println(Arrays.toString(array));
  }
}
