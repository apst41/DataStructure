package org.example.array;

import java.util.Arrays;

public class RotateArray {
  public static void rotateArray(int[] nums) {
    int first = nums[0];

    for (int i = 0; i < nums.length - 1; i++) {
      nums[i] = nums[i + 1];
    }
    nums[nums.length - 1] = first;
  }

  public static void rotate(int[] nums, int k) {

    int totalRotation = k % nums.length;

    for (int i = 0; i < totalRotation; i++) rotateArray(nums);
  }

  public static void main(String[] args) {
    int array[] = new int[] {1, 2, 3, 4, 5, 6};

    rotate(array, 3);
    Arrays.stream(array).forEach(System.out::println);
  }
}
