package org.example.interview;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRU {
  private final int capacity;
  private final Deque<String> deque = new LinkedList<>();
  private final LinkedHashSet<String> hashSet = new LinkedHashSet<>();

  public LRU(int capacity) {
    this.capacity = capacity;
  }

  private void insert(String value) {

    if (hashSet.contains(value)) {
      deque.remove(value);
      hashSet.remove(value);
    } else if (hashSet.size() == capacity) {
      String removeLast = deque.remove();
      hashSet.remove(removeLast);
    }
    deque.add(value);
    hashSet.add(value);
  }

  private void printQueue() {
    deque.forEach(System.out::println);
  }

  private void print() {
    hashSet.forEach(System.out::println);
  }

  public static void main(String[] args) {
    LRU lru = new LRU(3);
    lru.insert("A");
    lru.insert("A");
    lru.insert("C");
    lru.printQueue();
    lru.insert("D");

    lru.insert("E");
    lru.insert("E");
    lru.printQueue();
  }
}
