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
         System.out.println(number + ". "+ item.getName());
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

   // Method to add to order objects arraylist.
   protected void add(Item item){
      order.add(item);
   }

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
      }//for
      calculateTotal();
      //total cost of bill
      System.out.println("The total bill is: £" + df.format(orderTotalPrice));
   }//printBill

   protected double getBillTotal(){
      calculateTotal();
      return orderTotalPrice;
   }

   private void calculateTotal(){
      // If loop below should prevent doubling of bill price when two receipts
      // are printed
      if (orderTotalPrice == 0) {
         for (Item item : order) {
            //keep a running total of bill
            orderTotalPrice += item.getPrice();
         }//for
      }//if
   }

   protected double payOrder(double payment){
      double change;
      change = -1* ( orderTotalPrice - payment);
      orderTotalPrice -= payment;

      if (orderTotalPrice <= 0){
         return change;
      }
      else{
         System.out.println("\n" + df.format(orderTotalPrice) + " still to be paid.");
         return 0;
      }
   }//Pay Order

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

   protected void PrintAnOrder(){
      int number = 1;
      System.out.println("\nThe order was: ");
      for (Item item: order) {
         System.out.println(item.getName() + "\t\t\t\t" + "£" + df.format(item.getPrice()));
         number++;
      }//for
   }//viewOrder
}//class
