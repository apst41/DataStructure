package org.example.string;

public class Find3As {
  public boolean winnerOfGame(String colors) {
    int aOccurances = findTriplets(colors, 'A');
    int bOccurances = findTriplets(colors, 'B');
    return aOccurances > bOccurances;
  }

  private int findTriplets(String colors, char triplet) {
    int result = 0;
    for (int i = 0; i < colors.length() - 2; i++) {
      if (colors.charAt(i) == triplet
          && colors.charAt(i + 1) == triplet
          && colors.charAt(i + 2) == triplet) result++;
    }
    return result;
  }
}
