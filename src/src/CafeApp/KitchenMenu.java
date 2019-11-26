package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019

Additional Comments...
*/

import java.util.Scanner;

public class KitchenMenu {
   static Scanner kitchenscan = new Scanner(System.in);
   static private boolean logout = false;
   static private int choice;
   protected static void Kitchen(){
      do {
         // User prompt
         System.out.println("\nWhat do you require?");
         System.out.println("1. View current orders"
               + "\n2. View out of stock items"
               + "\n3. Mark item out of stock"
               + "\n4. Mark item back in stock"
               + "\n5. Logout");
         choice = kitchenscan.nextInt();

         // Switch block
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
      } while (!logout);
   }// Kitchen
}//class
