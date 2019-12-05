package CafeApp;
/*
Created by: Conor McErlean
Created on: 26/11/2019

Class should act as the stock-list for the cafe, storing all menu items &
providing methods to allow those items to be retrieved for use elsewhere in the
program.
*/

import java.util.ArrayList;

public class StockList {
   // Items to be sold go below, this allows us to create an instance of the
   // Item class for each menu item as such each item will have a name & a
   // price.
   private static Item americano = new Item("Americano",
         2.00);
   private static Item capucchino = new Item("Cappuccino",
         3.00);
   private static Item latte = new Item("Latte     ",
         3.00);
   private static Item tea = new Item ("Tea       ",
         1.00);
   private static Item friedegg = new Item("Fried Eggs",
         3.50);
   private static Item sodabread = new Item("Soda Bread",
         1.50);

   // Two Key array lists that will be needed. These store the items above in a
   // list for access in other parts of the program. Otherwise we'd need to
   // create a new pointer to the object in each class.
   private static ArrayList<Item> outOfStock = new ArrayList<Item>();
   private static ArrayList<Item> menu = new ArrayList<Item>();

   // Prepares the menu for the cafe, simply adds the items below into the list
   // 'menu'.
   public static void readyMenu(){
      // Add items below:
      menu.add(americano);
      menu.add(capucchino);
      menu.add(latte);
      menu.add(tea);
      menu.add(friedegg);
      menu.add(sodabread);
   }

   // Method to see all available menu items. This is a private method to
   // support the select item method below.
   private static void seeOptions(){
      int counter = 1;
      for (Item item: menu){
         System.out.println(counter + ". " + item.getName());
         counter++;
      }//for
   }// See Options

   // Method to see all out of stock items. This method may be used within the
   // program as classes may need to view out
   // of stock items.
   protected static void viewOutOfStock(){
      int counter = 1;
      if (outOfStock.size() > 0){
      for (Item item: outOfStock){
         System.out.println(counter + ". " + item.getName());
         counter++;
      }//for
          }//if
      else{
         System.out.println("Nothing is out of stock.");
      }

   }//View Out of Stock

   // Method to select an item from the menu. This is an important method as it
   // allows us to access all the menu items we need for other functions. It
   // returns an Item, so you could think of it as a fancy getItem() method.
   protected static Item selectItem(){
      // Variables and objects required
      int choice;
         seeOptions();
         choice = UserInput.getArrayInput("Enter the item number: ", menu);
         choice--;
         return menu.get(choice);
   }// Select Item

   // Method to select an item from out of stock. Works in a similar fashion to
   // selectItem() above, but is focused on the outOfStock arrayList.
   protected static Item selectOutOfStock(){
      // Variables and objects required
      int choice;
      viewOutOfStock();
      choice = UserInput.getArrayInput("Enter the item number: ", outOfStock);
      choice--;
      return outOfStock.get(choice);
   }// Select out of stock.

   // Method to add an object to the out of stock arrayList, and remove it from
   // the menu so it cannot accidentally be ordered.
   protected static void addToOutOfStock(Item oosItem){
      menu.remove(oosItem);
      outOfStock.add(oosItem);
   }//addToOutOfStock

   // Method to remove an object from the out of stock array list. Does the
   // exact opposite of addToOutOfStock() in that it adds an item back into the
   // menu, so it can once more be ordered.
   protected static void removeFromOutOfStock(Item inStockItem){
      menu.add(inStockItem);
      outOfStock.remove(inStockItem);
   }

   protected static ArrayList getMenu(){
      return menu;
   }//getMenu

   //jen test to get mark out of stock working
   protected static void seeOOS(){
      int counter = 1;
      for (Item item: outOfStock){
         System.out.println(counter + ". " + item.getName());
         counter++;
      }//for
   }// See Options

   //jen test to get mark out of stock working
   protected static Item selectStock() {
      int choice;
      seeOOS();
      choice = UserInput.getIntInput("Enter the item number: ");
      choice--;
      return outOfStock.get(choice);
   }
   protected static int getOutOfStockSize(){
      return outOfStock.size();
   }

}//class
