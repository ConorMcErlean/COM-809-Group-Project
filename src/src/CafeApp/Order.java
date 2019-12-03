package CafeApp;/*
Created by: Conor McErlean
Created on: 03/12/2019

Class to create order objects to allow for multiple orders.
*/

import java.util.ArrayList;

public class Order {
   private ArrayList<Item> order;
   private boolean orderComplete;
   private boolean orderCooked;
   private String orderName;
   private static int posOrders = 1;

   protected Order(){
      order = new ArrayList<Item>();
      orderComplete = false;
      orderCooked = false;
      int tableNumber = UserInput.getIntInput("Enter the table number or " +
            "enter -1 for Take-Away/P.O.S orders: ");
      if (tableNumber == -1){
         orderName = "POS Order #" + posOrders;
         posOrders++;
      }
      else {
         orderName = "Table number " + tableNumber;
      }
   }
}//class
