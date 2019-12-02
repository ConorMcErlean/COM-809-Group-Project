package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019

Begin the program here.
The Class below begins the program by readying up the menu, then greeting the user.
After this it opens the login system.
*/

public class CafeApp {
   public static void main(String[] args) {
      TillOperator till1 = new TillOperator(1111);
      MenuForCafe.readyMenu();
      MainMenu.greeting();
      MainMenu.login();
   }//main
}//class

