package lv_427.logic.zakhar_skaletskyi;

import java.util.Scanner;
/**
 * Ways to cover in 3 steps
 *
 * <p> The goal: We want to calculate our possibility to cover the distance with 1, 2 and 3 steps.
 *
 * @author Zakhar Skaletskyi
 * @version 1.0
 */
import lv_427.logic.TaskExecutor;

public class WaysToCoverIn3steps implements TaskExecutor {
	private Scanner sc;

	public WaysToCoverIn3steps() {
		sc = new Scanner(System.in);
	}

	/**
	 * The method of main algorithm which count total number of ways to cover the
	 * distance
	 * 
	 * @param n - distance, which we need to cover
	 * @return int - total number of ways to cover input distance
	 */
	private int findStep(int n) {
		if (n == 1 || n == 0)
			return 1;
		else if (n == 2)
			return 2;

		else
			return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
	}

	/** The method which doing job us a controller */
	public void execute() {
		int distance = getDistance(sc);
		System.out.println("Total number of ways to cover the distance = " + findStep(distance));
		System.out.println("To return to menu just press Enter");
		sc.nextLine();
	}

	/**
	 * Method read distance from console and check if incoming data is valid. If
	 * input data is invalid the method write to console message and read next line
	 * 
	 * @param sc - Scanner to read input data.
	 * @return int - distance which we read.
	 */
	private int getDistance(Scanner sc) {
		boolean check = true;
		int distance = 0;
		System.out.println("Please enter a distance less than 30");
		while (check) {
			try {
				distance = Integer.parseInt(sc.nextLine());
				if ((distance > 0) && (distance <= 30)) {
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
