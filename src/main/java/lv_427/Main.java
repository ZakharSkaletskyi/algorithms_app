
package lv_427;

import lv_427.logic.TaskExecutor;

import java.util.Scanner;

/**
 * Our first task.
 *
 * @author lv-427
 * @version 1.0
 */
public class Main {

    /**
     * This is main method.
     *
     * @param args args
     */
    public static void main(String[] args) {
        TaskExecutor executor;

        Scanner scanner = new Scanner(System.in);

        int select;
        String input;

        while (true) {
            System.out.println(TaskFactory.MENU);

            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Bye!");
                break;
            }

            try {
                select = Integer.valueOf(input);
            } catch (Exception c) {
                System.out.println("You have to input integer or \'q\' to exit!!!");
                continue;
            }

            executor = TaskFactory.getInstance(select);

            if (executor == null) {
                System.out.println("You have to input number between 1 and 19 or \'q\' to exit!");
                continue;
            }

            System.out.println();

            executor.execute();
        }
    }
}