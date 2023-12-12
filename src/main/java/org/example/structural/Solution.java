package org.example.structural;

class Solution {

  private static int helper(int N) {
    int num1 = 0;
    int num2 = 1;

    int counter = 0;

    while (counter < N) {
      int num3 = num2 + num1;
      num1 = num2;
      num2 = num3;
      counter = counter + 1;
    }

    return counter;
  }

  public static void main(String[] args) {
    System.out.println(helper(4));
  }
}
