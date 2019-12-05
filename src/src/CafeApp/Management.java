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
      for (Item newItem : menu) {
         name = UserInput.getString("Enter Item Name: ");
         price = UserInput.getDoubleInput("Enter price: £");
         newItem.setName(name);
         newItem.setPrice(price);
         menu.add(newItem);
      }
   }//addItem()

   protected static void removeItem() {
      ArrayList<Item> menu = StockList.getMenu();
      Item dueForRemoval = StockList.selectItem();
      menu.remove(dueForRemoval);
   }//removeItem

}//class
