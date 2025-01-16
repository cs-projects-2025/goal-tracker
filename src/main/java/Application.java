import models.Menu;

public class Application {
    private static int userChoice;
    public static void main(String[] args) {
        /*Main method here as entry point for program*/

        // generate the menu options
        userChoice = Menu.generateMenu();
        System.out.println(userChoice);

    }
}
