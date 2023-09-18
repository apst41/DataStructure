package org.example.searching;

import java.util.Date;

public class BinarySearch {

  private static int searchBinary(int[] array, int l, int h, int key) {
    if (l > h) return -1;
    int mid = l + (h - l) / 2;
    if (array[mid] == key) return mid;

    if (array[l] <= array[mid]) {

      if (key >= array[l] && key < array[mid]) return searchBinary(array, l, mid - 1, key);

      return searchBinary(array, mid + 1, h, key);
    }

    if (key < array[mid] && key <= array[h]) return searchBinary(array, mid + 1, h, key);

    return searchBinary(array, l, mid - 1, key);
  }

  public static void main(String[] args) {
    System.out.println(new Date(0L));
  }
}
