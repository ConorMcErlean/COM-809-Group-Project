package CafeApp;/*
Created by: Conor McErlean
Created on: 03/12/2019

Class to create order objects to allow for multiple orders.
*/

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {
   private ArrayList<Item> order;
   private boolean orderComplete;
   private boolean orderCooked;
   private String orderName;
   private double orderTotalPrice;
   private static int posOrders = 1;
   private static DecimalFormat df = new DecimalFormat("0.00");

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

   // Object Methods

   protected void viewOrder(){
      int number = 1;
      System.out.println("\nThe current order is: ");
      for (Item item: order) {
         System.out.println(number + item.getName());
         number++;
      }//for
   }//viewOrder

   //method to remove from order
   protected void removeFromOrder(){
      try{
         int choice;
         viewOrder();
         choice = UserInput.getIntInput("Remove number: ");
         order.remove(choice);
         System.out.print( "Item has been removed\n");
      }//try
      catch (Exception issue){
         System.out.println("No such item exists.");
      }//Catch
   }//removeFromOrder

   //method to print the total cost - bill for the table
   protected void printBill() {
      //variables
      int number = 1;
      //for loop to get the name and price of each item in the view order list
      System.out.println("\nThe bill for order " + orderName +
            " is: ");
      for (Item item: order) {
         System.out.println(item.getName() + "\t\t£:" +
               df.format(item.getPrice()));
         //keep a running total of bill
         orderTotalPrice += item.getPrice();
         number++;
      }//for
      //total cost of bill
      System.out.println("The total bill is: £ " + df.format(orderTotalPrice));
   }//printBill

   protected double getBillTotal(){
      return orderTotalPrice;
   }

   protected void takePayment() {
      //variables
      double  amountTendered, changeDue;
      //provide amount due:
      System.out.println("\nThe Total Bill for order " + orderName +
            " is: £" + df.format(orderTotalPrice) );

      //prompt for amount received
      amountTendered = UserInput.getDoubleInput("Enter amount Tendered: £");

      //calculate change
      changeDue = amountTendered - orderTotalPrice;

      //output statements
      System.out.println("Payment for order: " + orderName );
      System.out.println("Amount Due: \t\t\t£" + df.format(orderTotalPrice) );
      System.out.println("Amount Tendered:\t\t£" + df.format(amountTendered));
      System.out.println("Change Due:\t\t\t\t£" + df.format(changeDue));
   }//Take Payment

   // Accessors & Mutators
   public boolean isOrderComplete() {
      return orderComplete;
   }

   public void setOrderComplete(boolean orderComplete) {
      this.orderComplete = orderComplete;
   }

   public boolean isOrderCooked() {
      return orderCooked;
   }

   public void setOrderCooked(boolean orderCooked) {
      this.orderCooked = orderCooked;
   }

   public String getOrderName() {
      return orderName;
   }

   public double getOrderTotalPrice() {
      return orderTotalPrice;
   }
}//class
