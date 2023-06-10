package org.example.structural.singleton;

public class SingleTon {
  private static SingleTon singleTon = null;

  public static SingleTon getInstance() {
    if (singleTon == null) singleTon = new SingleTon();
    return singleTon;
  }
}
