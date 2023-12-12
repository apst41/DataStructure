package org.example.leetCode.array;

public class RotatedArray {
  private int findPivot(int[] nums) {

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (mid > 0 && mid < high) {
        if ((nums[mid] < nums[mid - 1]) && (nums[mid] < nums[mid + 1])) return mid;
      }

      if (nums[mid] < nums[high]) {
        high = mid - 1;
      } else low = mid + 1;
    }

    if (high == -1) return 0;

    return high;
  }
}
