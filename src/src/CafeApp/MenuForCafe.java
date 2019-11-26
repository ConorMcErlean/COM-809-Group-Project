package CafeApp;/*
Created by: Conor McErlean
Created on: 26/11/2019

Class should act as the menu for the cafe, storing all menu items
*/

import java.util.ArrayList;
import java.util.Scanner;

public class MenuForCafe {
   // Items to be sold
   private static Item americano = new Item("Americano", 2.00);
   private static Item capucchino = new Item("Cappuchino", 3.00);
   private static Item latte = new Item("Latte", 3.00);
   private static Item friedegg = new Item("Fried Eggs", 3.50);
   private static Item sodabread = new Item("Soda Bread", 1.50);

   // Two Key array lists
   static ArrayList<Item> outOfStock = new ArrayList<Item>();
   static ArrayList<Item> menu = new ArrayList<Item>();

   // Prepares the menu for the cafe
   public static void readyMenu(){
      // Add items below:
      menu.add(americano);
      menu.add(capucchino);
      menu.add(latte);
      menu.add(friedegg);
      menu.add(sodabread);
   }

   // Method to see all available menu items.
   private static void seeOptions(){
      int counter = 1;
      for (Item item: menu){
         System.out.println(counter + ". " + item.getName());
         counter++;
      }//for
   }// See Options

   // Method to see all out of stock items.
   protected static void viewOutOfStock(){
      int counter = 1;
      for (Item item: outOfStock){
         System.out.println(counter + ". " + item.getName());
         counter++;
      }//for
   }//View Out of Stock

   // Method to select an item from the menu
   protected static Item selectItem(){
      // Variables and objects required
      Scanner sc = new Scanner(System.in);
      int choice;
      seeOptions();
      System.out.print("Enter the item number: ");
      choice = sc.nextInt();
      choice--;
      return menu.get(choice);
   }// Select Item

   // Method to select an item from out of stock
   protected static Item selectOutOfStock(){
      // Variables and objects required
      Scanner sc = new Scanner(System.in);
      int choice;
      viewOutOfStock();
      System.out.print("Enter the item number: ");
      choice = sc.nextInt();
      choice--;
      return outOfStock.get(choice);
   }



   //Method to add an object to the out of stock arrayList
   protected static void addToOutOfStock(Item oosItem){
      menu.remove(oosItem);
      outOfStock.add(oosItem);
   }//addToOutOfStock

   // Method to remove an object from the out of stock array list
   protected static void removeFromOutOfStock(Item inStockItem){
      menu.add(inStockItem);
      outOfStock.remove(inStockItem);
   }


}//class
