package org.example.leetCode.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    static boolean isValidParentheses(String s){

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

    public static void main(String[] args) {
        System.out.println(isValidParentheses("([{}])"));
    }
}
