package CafeApp;/*
Created by: Conor McErlean
Created on: 02/12/2019

Additional Comments...
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Management extends Staff {
   public Management (int loginID) { super(loginID); } // Default Constructor
   private static Scanner keyboard = new Scanner(System.in);
   private static DecimalFormat df = new DecimalFormat("0.00");

   protected static void addItem() {
      String name;
      double price;
      int counter = 1;

      for (Item newItem : StockList.menu) {
         System.out.print("Enter Item Name: ");
         name = keyboard.nextLine();
         System.out.print("Enter price: £ ");
         price = keyboard.nextDouble();
         newItem.setName(name);
         newItem.setPrice(price);
         StockList.menu.add(newItem);
      }
   }

   protected static void removeItem() {
      Item dueForRemoval = StockList.selectItem();
      StockList.menu.remove(dueForRemoval);
   }//removeItem

}//class
