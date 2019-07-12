package lv_427.logic.rostyslav_khasanov;

import java.io.IOException;
import lv_427.logic.TaskExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountOfWaysToSumToN implements TaskExecutor {

  public void execute() {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String strArr[];
    int numbers[];
    String str = "";
    int num = 0;
    int sum = 0;
    int counter = 0;

    System.out.println("Enter array of numbers like '1 5 2 12 1': \n");
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    strArr = str.split(" ");
    numbers = new int[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      numbers[i] = Integer.parseInt(strArr[i]);
    }
    System.out.println(Arrays.toString(numbers));
    try {
      num = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < numbers.length; i++) {
      while (sum < num) {
        sum += numbers[i];
        if (sum == num) {
          counter++;
        }
      }
      while (sum < num) {
      }
      //        for (int j = 1; j < numbers.length; j++) {
      //            if (numbers[i] + j == num) {
      //                counter++;
      //            }
      //        }
      sum = 0;
    }
    System.out.println(counter);
  }
}
