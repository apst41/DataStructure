package org.example.interview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class LFU {
  int capacity;
  ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
  ConcurrentLinkedDeque<String> queue = new ConcurrentLinkedDeque<>();

  public LFU(int capacity) {
    this.capacity = capacity;
  }

  private String getMinimumKey() {
    AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
    AtomicReference<String> minKey = new AtomicReference<>("");
    map.forEach(
        (key, value) -> {
          if (value < min.get()) {
            min.set(value);
            minKey.set(key);
          }
        });
    return minKey.get();
  }

  private void add(String key) {

    if (map.containsKey(key)) {
      map.put(key, map.get(key) + 1);
      return;

    } else if (map.size() == capacity) {
      map.remove(getMinimumKey());
    }
    map.put(key, 1);
  }

  public static void main(String[] args) {}
}
