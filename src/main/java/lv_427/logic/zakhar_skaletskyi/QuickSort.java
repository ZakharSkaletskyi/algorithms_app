package lv_427.logic.zakhar_skaletskyi;

import java.util.Arrays;
import java.util.Scanner;
import lv_427.logic.TaskExecutor;

public class QuickSort implements TaskExecutor {
	private Scanner sc;

	public QuickSort() {
		sc = new Scanner(System.in);
	}

	public void execute() {
		int[] inputArray = getInputArray(sc);
		quickSort(inputArray, 0, inputArray.length - 1);
		for (int n : inputArray) {
			System.out.print(n + " ");
		}
		System.out.println("\nTo return to menu just press Enter");
		sc.nextLine();
	}
	private int getPivot(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); 
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	private void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pivot = getPivot(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	private int[] getInputArray(Scanner sc) {
		boolean check = true;
		int[] inputArray = null;
		System.out.println("Please enter int array for Quick Sort in format n1 n2 n3 n4 n5");
		while (check) {
			try {
				inputArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				check = false;
			} catch (Exception e) {
				System.out.println("Please enter array of numbers with SPACE as separator");
			}
		}
		return inputArray;
	}

}
