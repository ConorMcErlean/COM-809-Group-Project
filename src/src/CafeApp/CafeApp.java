package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019

Begin the program here.
The Class below begins the program by readying up the menu, then greeting the user.
After this it opens the login system.
*/

public class CafeApp {
   public static void main(String[] args) {
      // Method to greet users on initial boot & Initialise menu
      Menu.greeting();
      // Menu for staff to login
      Menu.login();
   }//main
}//class

