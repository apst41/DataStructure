package org.example.string;

public class String3 {

  public String reverseWords(String s) {
    int start;
    int end;

    int current = 0;

    StringBuilder sb = new StringBuilder(s);

    while (current < sb.length()) {
      if (sb.charAt(current) == ' ') {
        current++;
      } else {
        start = current;
        while (current < sb.length() && sb.charAt(current) != ' ') current++;
        end = current - 1;
        reverseString(sb, start, end);
      }
    }
    return sb.toString();
  }

  private void reverseString(StringBuilder sb, int start, int end) {
    while (start <= end) {
      char temp = sb.charAt(end);
      sb.setCharAt(end, sb.charAt(start));
      sb.setCharAt(start, temp);
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    String3 string3 = new String3();
    System.out.println(string3.reverseWords("Let's take LeetCode contest"));
  }
}
