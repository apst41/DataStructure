package org.example.leetCode.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
  static boolean isValidParentheses(String s) {

    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char input = s.charAt(i);
      if (input == '(' || input == '{' || input == '[') {
        stack.push(input);
        continue;
      }
      if (stack.isEmpty()) return false;

      char check;

      switch (input) {
        case ')' -> {
          check = stack.pop();
          if (check == '{' || check == '[') return false;
        }
        case '}' -> {
          check = stack.pop();
          if (check == '(' || check == '[') return false;
        }
        case ']' -> {
          check = stack.pop();
          if (check == '(' || check == '{') return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static int[] plusOne(int[] digits) {
    int lenght = digits.length - 1;
    return onePlus(digits, lenght);
  }

  static int[] onePlus(int[] digits, int n) {
    int i = n;
    if (digits[i] < 9) {
      digits[i] = digits[i] + 1;
      return digits;
    }
    digits[i] = 0;

    if (i == 0) {
      int[] array = new int[digits.length + 1];
      return onePlus(array, i);
    } else {
      i--;
      return onePlus(digits, i);
    }
  }

  public static void main(String[] args) {

    int[] data = plusOne(new int[] {9, 9, 9});
    for (int val : data) {
      System.out.print(val + "\t");
    }
  }
}
