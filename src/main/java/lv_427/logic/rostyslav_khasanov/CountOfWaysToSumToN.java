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

    System.out.println("Enter array of numbers like '1 5 2 12 1': \n");
    try {
      str = sc.nextLine();
    } catch (Exception e) {
      e.printStackTrace();
    }
    number = Integer.parseInt(sc.nextLine());
    strArr = str.split(" ");
    numbers = new int[strArr.length + 1];
    for (int i = 0; i < strArr.length; i++) {
      numbers[i] = Integer.parseInt(strArr[i]);
    }
    System.out.println(Arrays.toString(numbers));
    System.out.println(countWays(numbers, number));
  }

  public int countWays(int[] arr, int n) {
    int mas[] = arr;
    mas[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (i >= mas[i]) {
          mas[i] += mas[i - mas[j]];
        }
      }
    }
    return mas[n];
  }
}
