package lv_427.logic.zakhar_skaletskyi;

import java.util.Scanner;

import lv_427.logic.TaskExecutor;

public class WaysToCoverIn3steps implements TaskExecutor{
	private Scanner sc;
	private int findStep(int n) 
    { 
        if (n == 1 || n == 0)  
            return 1; 
        else if (n == 2)  
            return 2; 
       
        else
            return findStep(n - 3) +  
                   findStep(n - 2) + 
                   findStep(n - 1);     
    }
	public WaysToCoverIn3steps() {
		sc = new Scanner(System.in);
	}

	public void execute() {
		int distance = getDistance(sc);
		System.out.println("Total number of ways to cover the distance = " + findStep(distance));
		System.out.println("To return to menu just press Enter");
		sc.nextLine();
	} 
	
	private int getDistance(Scanner sc) {
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
