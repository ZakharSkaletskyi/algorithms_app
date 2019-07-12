package lv_427.logic.rostyslav_khasanov;

import lv_427.logic.TaskExecutor;

import java.util.Arrays;
import java.util.Scanner;

public class CountOfWaysToSumToN implements TaskExecutor {

  public void execute() {

    Scanner sc = new Scanner(System.in);
    String strArr[];
    int numbers[];
    String str = "";
    int number = 0;
    int m = 0;

    System.out.println("Enter array of numbers like '1 5 2 12 1': \n");
    try {
      str = sc.nextLine();
    } catch (Exception e) {
      e.printStackTrace();
    }
    number = Integer.parseInt(sc.nextLine());
    strArr = str.split(" ");
    m = strArr.length;
    numbers = new int[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      numbers[i] = Integer.parseInt(strArr[i]);
    }
    System.out.println(Arrays.toString(numbers));
    System.out.println(countWays(numbers, number, m));
  }

  public int countWays(int[] arr, int n, int m) {
    int mas[] = arr;
    int count[] = new int[n + 1];
    count[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m-1; j++) {
        if (i >= mas[i]) {
          count[i] += count[i - mas[j]];
        }
      }
    }
    return count[n];
  }
}
