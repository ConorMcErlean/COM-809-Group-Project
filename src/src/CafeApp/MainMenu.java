package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019

Menu System for the CafeApp, allows a user to enter a login code an move to the relevant sub-menu.
*/

import java.util.Scanner;

public class MainMenu {
    // Objects & Variables required for main menu
    static private boolean logoutNow = false;
    static private int logincode;
    static private Scanner loginReader = new Scanner(System.in);
    static private String greeting = "Welcome to the Cafe app: \n"
            + "\t\t" + "\t) (\n"
            + "\t\t" + "\t( )\n"
            + "\t\t" + " |\t\t|\n"
            + "\t\t" + " |\t\t|)\n"
            + "\t\t" + " |\t\t|\n"
            + "\t\t" + " \\______/\n";

    // Simple method to greet on first opening
    protected static void greeting(){
        System.out.println(greeting);
    }//greeting

    protected static void login(){
        //Do while loop to repeat the login section until user chooses to exit.
        do {
            System.out.println("\nPlease enter your Staff Login Code (or enter 0000 to shut-down).");
            System.out.print("Login: ");
            logincode = loginReader.nextInt();

            // Switch block, leading into submenus
            switch (logincode) {

                case 1111:
                    // Code for entry into till menu below
                    System.out.println("You have entered the till");
                    TillMenu.TillOpMenu();
                    // Exit to login screen
                    logoutNow = false;
                    break;

                case 2222:
                    // Code for entry into kitchen menu below
                    System.out.println("You have entered the kitchen");
                    KitchenMenu.Kitchen();
                    // Exit to login screen
                    logoutNow = false;
                    break;

                case 3333:
                    // Code for entry into manager menu below
                    System.out.println("you have entered manager mode");
                    ManagerMenu.Manager();
                    // Exit to login screen
                    logoutNow = false;
                    break;

                case 0000:
                    // Code to exit system and break loop
                    System.out.println("System shutting down.");
                    logoutNow = true;
                    break;

                default:
                    // If incorrect entry is used
                    System.out.println("Sorry, this login code is not recognised. Speak to your manager if there is an error.");
                    logoutNow = false;
                    break;
            }// Switch
        }while (!logoutNow);
    }//MainMenu
}//class
