package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019

Additional Comments...
*/

import java.util.Scanner;

public class MainMenu {
   // Objects & Variables required for main menu
   static private boolean logoutNow = false;
   static private int logincode;
   static private Scanner loginReader = new Scanner(System.in);
   static private String greeting = "Welcome to the Cafe app: ";

   // Simple method to greet on first opening
   protected static void greeting(){
      System.out.println(greeting);
   }//greeting

   protected static void login(){
      //Login System
      do {
         System.out.println("\nPlease enter your Staff Login Code (or enter 0000 to shut-down).");
         System.out.print("Login: ");
         logincode = loginReader.nextInt();

         // Switch block
         switch (logincode) {
            case 1111:
               // Code for entry into till menu below
               System.out.println("You have entered the till");
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

   public static void main(String[] args) {
      KitchenStaff kitchen1 = new KitchenStaff(2222);
      TillOperator till1 = new TillOperator(1111);

      MainMenu.greeting();
      MainMenu.login();
   }//main
}//class
