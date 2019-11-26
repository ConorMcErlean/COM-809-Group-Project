package CafeApp;
/*
Created by: Conor McErlean
Created on: 26/11/2019

Below is the sub-menu for the kitchen. Once entered from the main menu it will allow you to access the functions of the
KitchenStaff class.
*/

import java.util.Scanner;

public class KitchenMenu {
   static private Scanner kitchenscan = new Scanner(System.in);
   static private boolean logout = false;
   static private int choice;

   // Below is the method that will be used in the main menu to access the kitchen menu.
   protected static void Kitchen(){

      // The below do..while loop will allow you to perform as many actions as required in the kitchen staff menu.
      // Then when finished it will allow to logout by setting a boolean value to true.
      do {
         // User prompt
         System.out.println("\nWhat do you require?");
         System.out.println("1. View current orders"
               + "\n2. View out of stock items"
               + "\n3. Mark item out of stock"
               + "\n4. Mark item back in stock"
               + "\n5. Logout");
         choice = kitchenscan.nextInt();

         // Switch block where each option calls the static methods of the KitchenStaff Class to complete the function.
         switch (choice){
            case 1:
               KitchenStaff.viewOrders("Orders");
               logout = false;
               break;
            case 2:
               System.out.println("Out of stock items:");
               MenuForCafe.viewOutOfStock();
               logout = false;
               break;
            case 3:
               KitchenStaff.markOutOfStock(MenuForCafe.selectItem());
               logout = false;
               break;
            case 4:
               KitchenStaff.markBackInStock(MenuForCafe.selectOutOfStock());
               logout = false;
               break;
            case 5:
               System.out.println("Logging out");
               logout = true;
               break;
            default:
               System.out.println("Choice not recognised");
               logout = false;
               break;
         }// Switch
      } while (!logout); // This segment means while (logout is not true).
   }// Kitchen
}//class
