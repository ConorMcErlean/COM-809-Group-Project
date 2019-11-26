package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019
Begin the program here.
*/

public class CafeApp {
   public static void main(String[] args) {
      KitchenStaff kitchen1 = new KitchenStaff(2222);
      TillOperator till1 = new TillOperator(1111);

      MainMenu.greeting();
      MainMenu.login();
   }//main
}//class
