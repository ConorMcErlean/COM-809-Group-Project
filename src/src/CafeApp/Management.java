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

      // User Prompts
      name = UserInput.getString("Enter Item Name: ");
      price = UserInput.getDoubleInput("Enter price: £ ");

      // Creating an instance of Item
      Item newItem = new Item(name, price);

      //Adding the item object
      menu.add(newItem);

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

   protected static void applyDiscount(){
      DecimalFormat df = new DecimalFormat("0.00");
      double discount =0;
      //Select order to discount
      Order order = Till.getOrder();
      //User Prompt
      discount = UserInput.getDoubleInput("Please enter the discount you wish to apply in %: ");
      // Calling the discount method in Order Class
      order.discountOrder(discount);
   }//applyDiscount

}//class
