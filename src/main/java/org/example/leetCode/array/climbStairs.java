package org.example.leetCode.array;

import java.util.HashMap;
import java.util.Map;

public class climbStairs {
  private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

  private static int climbStairs(int n) {
    if (n <= 1) return 1;
    if (map.containsKey(n)) return map.get(n);
    int data = climbStairs(n - 1) + climbStairs(n - 2);
    map.put(n, data);
    return data;
  }
}
