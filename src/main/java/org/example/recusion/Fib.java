package org.example.recusion;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Fib {

  private static final Map<Integer, BigInteger> map = new HashMap<>();

  private static BigInteger fib(int num) {
    if (num <= 2) return BigInteger.ONE;

    BigInteger value;

    if (map.containsKey(num)) {
      return map.get(num);
    }

    value = fib(num - 1).add(fib(num - 2));

    map.put(num, value);
    return value;
  }

  public static void main(String[] args) {
    System.out.println(LocalDate.now());

    System.out.println(LocalDateTime.now());

    System.out.println("LBA_GENIE_SIGN_REMINDER".toLowerCase());
  }
}
