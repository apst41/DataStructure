package org.example.concentrix;

import java.util.PriorityQueue;

public class Train {

  // [1900,2000] check size output -> current size > outputSize  =3
  //    Output 3 Explanation There are at-most three trains at a time (time between 940 to 1200)
  //    Input arr[] = {900, 940},
  //    dep[] = {910, 1200} Output 1 Explanation Only one platform is needed.
  // [1900,2000] check size output -> current size > outputSize  =2
  private static int minimumPlatform(int[] arrival, int[] departure) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
    queue.add(departure[0]);

    int noOfPlatform = 0;

    for (int i = 1; i < arrival.length - 1; i++) {
      while (!queue.isEmpty() && arrival[i] > queue.peek()) {
        queue.poll();
      }

      queue.add(departure[i]);

      if (queue.size() > noOfPlatform) {
        noOfPlatform = queue.size();
      }
    }
    return noOfPlatform;
  }

  public static void main(String[] args) {

    int arrival[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1050, 1130, 1900, 2000};

    System.out.println(minimumPlatform(arrival, dep));
  }
}
