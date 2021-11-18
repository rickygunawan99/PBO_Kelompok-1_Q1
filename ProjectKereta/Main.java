import Gui.BerandaUserGui;
import Gui.LoginUserGui;
import controller.KeretaController;
import controller.UserController;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    private static KeretaController keretaController = new KeretaController();
    private static UserController userController = new UserController();

    public static void main(String[] args) {
        new BerandaUserGui().setVisible(true);
    }
}
