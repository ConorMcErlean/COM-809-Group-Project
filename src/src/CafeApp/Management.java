package CafeApp;/*

Management functions class created by Matthew McCafferty.
*/

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Management extends Staff {
   public Management (int loginID) { super(loginID); } // Default Constructor

   private static DecimalFormat df = new DecimalFormat("0.00");

   protected static void addItem() {
      String name;
      double price;
      ArrayList<Item> menu = StockList.getMenu();

      //Creating an instance of Item
      Item newItem = new Item();

      name = UserInput.getString("Enter Item Name: ");     //every time i used this the add item would crash
      newItem.setName(name);
      price = UserInput.getDoubleInput("Enter price: £ ");
      newItem.setPrice(price);

      //Adding the item object                                 //this shows that the item has been added to the list of
      menu.add(newItem);                                       //current items

      //Printing each item to check if new item has been added
      for (Item item : menu) {
         System.out.println(item);
      }
   }//addItem()

   protected static void removeItem() {
      ArrayList<Item> menu = StockList.getMenu();
      Item dueForRemoval = StockList.selectItem();
      menu.remove(dueForRemoval);
   }//removeItem

}//class
