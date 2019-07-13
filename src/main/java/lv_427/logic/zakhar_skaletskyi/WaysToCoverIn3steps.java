package lv_427.logic.zakhar_skaletskyi;

import java.util.Scanner;

import lv_427.logic.TaskExecutor;

public class WaysToCoverIn3steps implements TaskExecutor {
	private long totalCountOfWays;
	private int distance;
	private Scanner sc;

	public WaysToCoverIn3steps() {
		sc = new Scanner(System.in);
	}

	public void execute() {
		totalCountOfWays = 1; // all distance we cover by 1 step
		distance = getDistance(sc);
		totalCountOfWays += findWays(distance, 3, 0, 0, 0, 0);
		System.out.println("Total number of ways to cover the distance = " + totalCountOfWays);
		System.out.println("To return to menu just press Enter");
		sc.nextLine();
	}

	private long findWays(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		long totalCountOfWays = 0;
		if (stepDistance == 3) {	//start calculate for 3 steps and than for less steps
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

	public long countWays(int passedSteps, int step1, int step2, int step3) {
		long factorial = getFactorial(passedSteps) / getFactorial(step1) / getFactorial(step2) / getFactorial(step3);
		return factorial;
	}

	public long getOneStepsCount(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		long twoStepsCount = 0;
		step1 += distance;
		passedSteps += distance;
		twoStepsCount += countWays(passedSteps, step1, step2, step3);
		return twoStepsCount;
	}

	public long getTwoStepsCount(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		long twoStepsCount = 0;
		for (int coveredDistanceWith2Steps = 2; coveredDistanceWith2Steps <= distance; coveredDistanceWith2Steps += 2) {
			passedSteps++;
			step2++;
			twoStepsCount += findWays(distance - coveredDistanceWith2Steps, 1, passedSteps, step1, step2, step3);
		}
		return twoStepsCount;
	}

	public long getThreeStepsCount(int distance, int stepDistance, int passedSteps, int step1, int step2, int step3) {
		long threeStepsCount = 0;
		for (int coveredDistanceWith3Steps = 3; coveredDistanceWith3Steps <= distance; coveredDistanceWith3Steps += 3) {
			passedSteps++;
			step3++;
			threeStepsCount += findWays(distance - coveredDistanceWith3Steps, 2, passedSteps, step1, step2, step3);
		}
		return threeStepsCount;
	}

	public static long getFactorial(int n) {
		long r = 1;
		for (int i = 1; i <= n; i++) {
			r *= i;
		}
		return r;
	}

	public int getDistance(Scanner sc) {
		boolean check = true;
		int distance = 0;
		System.out.println("Please enter a distance less than 30");
		while (check) {
			try {
				distance = Integer.parseInt(sc.nextLine());
				if ((distance > 0) && (distance <=30)) {
					check = false;
				} else {
					check = true;
					System.out.println("Please enter just one positive number less than 30!");
				}
			} catch (Exception e) {
				System.out.println("Please enter just one positive number less than 30!");
			}
		}
		return distance;
	}
}
