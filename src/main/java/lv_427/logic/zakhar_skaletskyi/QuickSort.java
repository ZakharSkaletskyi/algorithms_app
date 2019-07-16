package lv_427.logic.zakhar_skaletskyi;

import java.util.Arrays;
import java.util.Scanner;
import lv_427.logic.TaskExecutor;

/**
 * Quick sort
 *
 * @author Zakhar Skaletskyi
 * @version 1.0
 */
public class QuickSort implements TaskExecutor {
	private Scanner sc;

	public QuickSort() {
		sc = new Scanner(System.in);
	}

	/** The method which doing job us a controller */
	public void execute() {
		int[] inputArray = getInputArray(sc);
		quickSort(inputArray, 0, inputArray.length - 1);
		for (int n : inputArray) {
			System.out.print(n + " ");
		}
		System.out.println("\nTo return to menu just press Enter");
		sc.nextLine();
	}

	/**
	 * Method sort array. In result we have pivot element in the middle and smaller
	 * unsorted values than the pivot element on the left and bigger values on the
	 * right
	 * 
	 * @param      arr[] - array to sort
	 * @param low  - index of first element in array to sort
	 * @param high - index of last element in array to sort
	 */
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

	/**
	 * Method of main algorithm which sort array with Quick sort algorithm
	 * 
	 * @param      arr[] - array to sort
	 * @param low  - index of first element in array to sort
	 * @param high - index of last element in array to sort
	 */
	private void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pivot = getPivot(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	/**
	 * Method read input array from console and check if incoming data is valid. If
	 * input data is invalid the method write to console message and read next line
	 * 
	 * @param sc - Scanner to read input data.
	 * @return int[] - array we have read.
	 */
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
