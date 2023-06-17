package org.example.structural;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tain {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    List<Integer> integers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      integers.add(scanner.nextInt());
    }
    integers.forEach(System.out::println);
  }
}
