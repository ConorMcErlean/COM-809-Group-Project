package CafeApp;/*
Created by: Conor McErlean
Created on: 03/12/2019

Class to create order objects to allow for multiple orders.
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {
   private ArrayList<Item> order;
   private boolean orderComplete;
   private boolean orderCooked;
   private String orderName;
   private double orderTotalPrice, remainingTotal, payment, change;
   private static int posOrders = 1;
   private static DecimalFormat df = new DecimalFormat("0.00");
   private PrintWriter exportedFile;

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
         choice = UserInput.getArrayInput("Remove number: ", order);
         choice--;
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
         System.out.println(item.getName() + "\t\t\t£:" +
               df.format(item.getPrice()));
      }//for
      calculateTotal();
      //total cost of bill
      System.out.println("The total bill is: £" + df.format(orderTotalPrice));
   }//printBill

   protected double getBillTotal(){
      calculateTotal();
      return remainingTotal;
   }

   private void calculateTotal(){
      // If loop below should prevent doubling of bill price when two receipts
      // are printed
      if (orderTotalPrice == 0) {
         for (Item item : order) {
            //keep a running total of bill
            orderTotalPrice += item.getPrice();
         }//for

         // Setting remainingTotal
         remainingTotal = orderTotalPrice;
      }//if
   }

   // Method to take a payment value and subtract it from the total. Returning the change.
   private double takePayment(double payment){
      this.payment += payment;
      double change;
      change = -1* ( remainingTotal - payment);
      remainingTotal -= payment;

      if (remainingTotal <= 0){
         return change;
      }
      else{
         return 0;
      }
   }//Pay Order

   // Method to pay an order
   protected void payOrder(){
      char response;
      double amountTendered;

      // Make sure total has been updated
      calculateTotal();

      // User prompt for payment & then calculate change by calling takePayment()
      amountTendered = UserInput.getDoubleInput("Enter amount Tendered: £");
      change = takePayment(amountTendered);

      // If block for fully paid bill
      if (remainingTotal <= 0){
         //output
         System.out.println("\nAmount Due: \t\t\t£" + df.format(orderTotalPrice));
         System.out.println("Amount Tendered:\t\t£" + df.format(payment));
         System.out.println("Change Due:\t\t\t\t£" + df.format((change)) + "\n");

         // Block for printing to file
         response = UserInput.getCharInput("\nview + print the receipt (y or n)?: ");
         if (response == 'y'){
            viewReceipt();
            exportReceipt();
         }//if

      }//if

      // Else for partially paid bills
      else {
         System.out.println("Thank you for payment there is currently £" +
                 df.format(remainingTotal) + " to be paid.");
      }// else
   } //payOrder

   // Method to print end of transaction receipt
   protected void viewReceipt(){
      System.out.println("Print a receipt for table: ");
      System.out.println("\n");
      System.out.println("\t\t\tCafe App");
      System.out.println("\t\tCustomer Receipt");
      System.out.println("\t\t" + orderName);
      printAnOrder();
      System.out.println("\nAmount Due: \t\t\t£" + df.format(orderTotalPrice));
      System.out.println("Amount Tendered:\t\t£" + df.format(payment));
      System.out.println("Change Due:\t\t\t\t£" + df.format((change)) + "\n");
      System.out.println("**Thank you for your custom**\n");

      orderComplete = true;
   }//printReceipt

   //method to print receipt to file
   protected void exportReceipt() {
      //variables
      boolean open;
      String myFileName = "receipt.txt";

      //try..catch to catch any errors
      try {
         exportedFile = new PrintWriter(myFileName);
         open = true;
      }//try
      catch (FileNotFoundException error) {
         System.out.println("Error opening the file");
         open = false;
      }//catch
      //try.. catch to catch any errors while printing to and exporting file
      try {
         if (open) {
            exportedFile.println(toString());
            exportedFile.close();
            open = false;
            System.out.println("Successfully written to file and closed");
         }//if
      }//try
      catch (Exception error) {
         System.out.println("Exception " + error.getMessage() + " caught");
      }//catch
   }//exportReceipt


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

   //setter to try to apply discount. This works now!! added by Matthew
   public void setOrderTotalPrice(double orderTotalPrice) {
      this.orderTotalPrice = orderTotalPrice;
   }

   public double getOrderTotalPrice() {
      return orderTotalPrice;
   }

   //method to Print an order
   protected void printAnOrder(){
      int number = 1;
      System.out.println("\nThe order was: ");
      for (Item item: order) {
         System.out.println(item.getName() + "\t\t\t\t" + "£" + df.format(item.getPrice()));
         number++;
      }//for
   }//viewOrder

   public String toString(){
      String message = "";
      message.concat("\n");
      message.concat("\t\t\tCafe App");
      message.concat("\t\tCustomer Receipt");
      message.concat("\t\t" + orderName);
      for (Item item: order){
         message.concat(item.getName() + " " + item.getPrice() + "\n");
      }
      message.concat("\nAmount Due: \t\t\t£" + df.format(orderTotalPrice));
      message.concat("Amount Tendered:\t\t£" + df.format(payment));
      message.concat("Change Due:\t\t\t\t£" + df.format((change)) + "\n");
      message.concat("**Thank you for your custom**\n");
      return message;
   }

}//class
