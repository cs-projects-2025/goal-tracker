package models;

import java.util.Scanner;

/*
 * Author: Tony Sandoval
 * Description: This class holds the menu method. It uses an int as a parameter
 * and returns different methods based on the input.
 * */
public class Menu {
    /*models.Goal Tracker models.Menu: The menu will use an integer option menu
     * There will be option 0 to return to main menu at all times
     * */
    private int mainMenu;
    private int createGoal;
    private int recordProgress;
    private int seeMyProgress;
    private int exportMyData;

    public static int generateMenu() {
        System.out.println(welcomeMessage());
        return numberOptions();
    }

    private static String welcomeMessage() {
        return "Welcome to the models.Goal Tracker 2025! ";
    }

    private static int numberOptions() {
        System.out.println("What would you like to do?" +
                "[0] Main models.Menu [1] Create a new goal [2] Record goal progress [3] See my progress [4] Export Data");

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            if (choice >= 0 && choice <= 4) {
                // return the choice number
                return choice;
            } else {
                System.out.println("Invalid option. Please enter a number between 0 and 4.");
            }
        } else {
            System.out.println("Invalid option. Please enter a valid integer.");
            sc.next(); // Consume the non-integer input to avoid an infinite loop
        }

        return choice;
    }
}
