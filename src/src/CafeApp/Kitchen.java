package CafeApp;
/*
Created by: Conor McErlean
Created on: 19/11/2019

Kitchen Staff Class, contains the functions required by kitchen staff an accessed through the KitchenMenu Class.
*/

import java.util.Scanner;

class Kitchen extends Staff {
   // Methods will all be static to avoid the need to instantiate an object.

   //Static Variables
   static private Scanner kitchenScan = new Scanner(System.in);
   static private boolean logout = false;
   static private int choice;


   // Constructors - I may remove this soon as there is no need to instantiate the Kitchen class.
   protected Kitchen(int loginCode){
      super(loginCode);
   }// Default Constructor

   // Early version of method to print order to console. Once the Till class has a method to add to an array
   // any orders this method will need to be adjusted.
   protected static void viewOrders(String order){
      System.out.println(order);
   }//viewOrders

   // Method to mark an item out of stock. Takes in an item (the selectItem() method of the MenuForCafe Class will help
   // here and sets the instance variable inStock to false, and uses the addToOutOfStock() method.
   protected static void markOutOfStock(Item item){
      item.setInStock(false);
      MenuForCafe.addToOutOfStock(item);
      System.out.println("The item " + item.getName() + " has been marked out-of-stock.");
   }

   // Method to mark an item back in stock. Takes in an item (the selectOutOfStock() method of the MenuForCafe Class
   // will help here and sets the instance variable inStock to true, and uses the removeFromOutOfStock() method.
   protected static void markBackInStock(Item item){
      item.setInStock(true);
      MenuForCafe.removeFromOutOfStock(item);
      System.out.println("The item " + item.getName() + " has been marked back in stock");
   }

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
         choice = kitchenScan.nextInt();

         // Switch block where each option calls the static methods of the Kitchen Class to complete the function.
         switch (choice){
            case 1:
               Kitchen.viewOrders("Orders");
               logout = false;
               break;
            case 2:
               System.out.println("Out of stock items:");
               MenuForCafe.viewOutOfStock();
               logout = false;
               break;
            case 3:
               Kitchen.markOutOfStock(MenuForCafe.selectItem());
               logout = false;
               break;
            case 4:
               Kitchen.markBackInStock(MenuForCafe.selectOutOfStock());
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
