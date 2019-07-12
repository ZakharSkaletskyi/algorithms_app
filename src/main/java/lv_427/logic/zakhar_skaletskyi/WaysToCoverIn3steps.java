package lv_427.logic.zakhar_skaletskyi;

import java.util.Scanner;

import lv_427.logic.TaskExecutor;

public class WaysToCoverIn3steps implements TaskExecutor {
	private int totalCountOfWays;
	private int distance;
	private Scanner sc;

	public WaysToCoverIn3steps() {
		sc = new Scanner(System.in);
	}

	public void execute() {
		totalCountOfWays = 1; // all distance we cover by 1 step
		System.out.println("Please input distance");
		distance = sc.nextInt();
		totalCountOfWays += findWays(distance, 3, 0, 0, 0, 0);
		System.out.println("Total number of ways to cover the distance = " + totalCountOfWays + "\n");
	}

	private int findWays(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		int totalCountOfWays = 0;
		if (stepDistance == 3) {
			totalCountOfWays += getTwoStepsCount(distance, 2, passedSteps, step1, step2, step3);
			totalCountOfWays += getThreeStepsCount(distance, 3, passedSteps, step1, step2, step3);
		}
		if (stepDistance == 2) {
			totalCountOfWays += getOneStepsCount(distance, 2, passedSteps, step1, step2, step3);
			totalCountOfWays += getTwoStepsCount(distance, 2, passedSteps, step1, step2, step3);
			return totalCountOfWays;
		}
		if (stepDistance == 1) {
			totalCountOfWays += getOneStepsCount(distance, 2, passedSteps, step1, step2, step3);
			return totalCountOfWays;
		}
		return totalCountOfWays;
	}
	public int countWays(int passedSteps, int step1, int step2, int step3) {
		int factorial = getFactorial(passedSteps) / getFactorial(step1) / getFactorial(step2) / getFactorial(step3);
		return factorial;
	}

	public int getOneStepsCount(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		int twoStepsCount = 0;
		step1+= distance;
		passedSteps += distance;
		twoStepsCount += countWays(passedSteps, step1, step2, step3);
		return twoStepsCount;
	}
	public int getTwoStepsCount(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		int twoStepsCount = 0;
		for (int coveredDistanceWith2Steps = 2; coveredDistanceWith2Steps <= distance; coveredDistanceWith2Steps += 2) {
			passedSteps++;
			step2++;
			twoStepsCount += findWays(distance - coveredDistanceWith2Steps, 1, passedSteps, step1, step2, step3);
		}
		return twoStepsCount;
	}
	public int getThreeStepsCount(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		int threeStepsCount = 0;
		for (int coveredDistanceWith3Steps = 3; coveredDistanceWith3Steps <= distance; coveredDistanceWith3Steps += 3) {
			passedSteps++;
			step3++;
			threeStepsCount += findWays(distance - coveredDistanceWith3Steps, 2, passedSteps, step1, step2, step3);
		}
		return threeStepsCount;
	}
	public static int getFactorial(int n) {
		int r = 1;
		for (int i = 1; i <= n; i++) {
			r *= i;
		}
		return r;
	}
}
