package org.example.recusion;

import java.util.Arrays;
import java.util.List;

public class MaxCoins {
  public static int maxCoins(long initialEnergy, List<Integer> energy, List<Integer> coins) {
    int coinSize = coins.size();
    if (coinSize == 0 || initialEnergy < 0) return 0;

    int[] previousResults = new int[coinSize + 1];
    Arrays.fill(previousResults, -1);
    int coin = coins.get(0);
    int energ = energy.get(0);

    previousResults[Math.min(coinSize, (int) initialEnergy)] = coin;

    int pickedEnergy = Math.min(coinSize, (int) initialEnergy + energ);
    previousResults[pickedEnergy] = Math.max(previousResults[pickedEnergy], 0);

    int ans = coin;

    for (int i = 1; i < coinSize; i++) {
      int[] newCoinArray = new int[coinSize + 1];
      Arrays.fill(newCoinArray, -1);
      coin = coins.get(i);
      energ = energy.get(i);

      for (int currentEnergy = 1; currentEnergy <= coinSize; currentEnergy++) {
        if (previousResults[currentEnergy] == -1) continue;
        int pickedCoin = previousResults[currentEnergy] + coin;
        newCoinArray[currentEnergy - 1] = Math.max(newCoinArray[currentEnergy - 1], pickedCoin);
        ans = Math.max(ans, pickedCoin);

        pickedEnergy = Math.min(coinSize, currentEnergy - 1 + energ);
        newCoinArray[pickedEnergy] =
            Math.max(newCoinArray[pickedEnergy], previousResults[currentEnergy]);
      }
      previousResults = newCoinArray;
    }
    return ans;
  }

  public static int maxCoinsWithEnergyLimit(
      long initialEnergy, List<Integer> energy, List<Integer> coins) {

    int n = coins.size();
    int[][] maxCoins = new int[n][(int) (initialEnergy + 1)];

    for (int e = 0; e <= initialEnergy; e++) {
      maxCoins[0][e] = (e >= energy.get(0)) ? coins.get(0) : 0;
    }

    for (int i = 1; i < n; i++) {
      for (int currentEnergy = 0; currentEnergy <= initialEnergy; currentEnergy++) {
        maxCoins[i][currentEnergy] = 0;

        if (currentEnergy >= energy.get(i)) {
          maxCoins[i][currentEnergy] =
              Math.max(
                  maxCoins[i][currentEnergy],
                  maxCoins[i - 1][currentEnergy - energy.get(i)] + coins.get(i));
        }

        maxCoins[i][currentEnergy] =
            Math.max(maxCoins[i][currentEnergy], maxCoins[i - 1][currentEnergy]);
      }
    }

    return (int) (maxCoins[n - 1][(int) initialEnergy] - initialEnergy);
  }

  public static void main(String[] args) {
    List<Integer> coin = List.of(3, 23, 9, 2, 2);
    List<Integer> energy = List.of(1, 5, 3, 3, 1);
    int initial_energy = 1;
    int result = maxCoins(initial_energy, energy, coin);
    System.out.println("Maximum Coins: " + result);
  }
}
