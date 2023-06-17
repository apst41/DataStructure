package org.example.leetCode.string;

public class IntToRoman {
  static String intToRoman(int value) {
    String[] m = {"", "M", "MM", "MMM"};
    String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

    String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    String thousands = m[value / 1000];
    String hundreds = c[(value % 1000) / 100];
    String tens = x[(value % 100) / 10];
    String onc = i[value % 10];

    return thousands + hundreds + tens + onc;
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(500));
  }
}
