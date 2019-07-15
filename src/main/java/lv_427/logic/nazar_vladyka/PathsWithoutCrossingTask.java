package lv_427.logic.nazar_vladyka;

import java.util.Scanner;
import lv_427.logic.TaskExecutor;

/**
 * Paths without crossing.
 *
 * <p>The goal: Program to count number of ways to connect n (where n is even) points on a circle
 * such that no two connecting lines cross each other and every point is connected with one other
 * point.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
public class PathsWithoutCrossingTask implements TaskExecutor {
  private Scanner sc;
  private PathsWithoutCrossingTaskExecutor executor;

  public PathsWithoutCrossingTask() {
    this.sc = new Scanner(System.in);
    executor = new PathsWithoutCrossingTaskExecutor();
  }

  /** The method which doing job us a controller(validate input data and send data to execution). */
  public void execute() {
    String input;

    do {
      System.out.print("Please send me the odd number(bigger that 0 and less than 52): ");
      input = sc.nextLine();
    } while (!executor.isInputDataValid(input));

    System.out.println("Result: " + executor.countWays(Integer.parseInt(input)));
  }
}
