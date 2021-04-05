import GUI.Controller.GUIControllerMainForm;
import GUI.Model.Shop;

import java.io.*;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

     public static void main(String[]args) throws IOException {
            Shop shop1 = new Shop(new Logic.Purse(100));
//          Logic.Menu.startMenu(shop1);
       //   MainWindow mainWindow = new MainWindow();

         GUIControllerMainForm controller = new GUIControllerMainForm(shop1);
         controller.execute();
     }


    /**
     * Метод считывает команду из консоли и проверяет её корректность.
     * @param maxCommand число команд которые содержаться в меню.
     * @return введённую команду.
     */
    public static int inputCommand(int maxCommand){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int command;
        try {
            command = Integer.parseInt(reader.readLine());
            if (command < 0 || command > maxCommand) {
                System.out.println("Выбранного вами пункта меню не существует, повторите ввод!");
                command = inputCommand(maxCommand);
            }
        }
        catch(NumberFormatException ex1) {
            System.out.println("Пункт меню должен быть числом! Повторите ввод!");
            command = inputCommand(maxCommand);
        }
        catch(IOException ex2){
            System.out.println("Ошибка при вводе команды! Повторите ввод!");
            command = inputCommand(maxCommand);
        }
        return command;
    }

    public static void markup(){
        System.out.println("==========================================================================");
    }
}
