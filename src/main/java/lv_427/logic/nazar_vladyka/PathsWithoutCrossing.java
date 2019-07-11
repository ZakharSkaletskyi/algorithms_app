package lv_427.logic.nazar_vladyka;

import lv_427.logic.AlgorithmExecutor;

public class PathsWithoutCrossing implements AlgorithmExecutor {
  public void execute() {}

  static int catalanDP(int n) {

    int[] catalan = new int[n + 1];

    catalan[0] = catalan[1] = 1;

    for (int i = 2; i <= n; i++) {
      catalan[i] = 0;
      for (int j = 0; j < i; j++) catalan[i] += catalan[j] * catalan[i - j - 1];
    }

    return catalan[n];
  }

  static int countWays(int n) {
    if (n < 1) {
      System.out.println("Invalid");
      return 0;
    }

    return catalanDP(n / 2);
  }

  public static void main(String[] args) {
    System.out.println(countWays(6) + " ");
  }
}
