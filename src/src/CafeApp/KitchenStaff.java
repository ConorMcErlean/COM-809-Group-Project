package CafeApp;
/*
Created by: Conor McErlean
Created on: 19/11/2019

Kitchen Staff Class, to allow Kitchen staff to view orders and mark out of stock.
*/

class KitchenStaff {
   // Constructors
   protected KitchenStaff(){
   }// Default Constructor

   // Early version of method to print order to console
   protected void viewOrders(String order){
      System.out.println(order);
   }//viewOrders

   // Method to mark an item out of stock
   protected void markOutOfStock(Item item){
      item.setInStock(false);
      System.out.println("The item " + item.getName() + " has been marked out-of-stock.");
   }
   protected void markBackInStock(Item item){
      item.setInStock(true);
      System.out.println("The item " + item.getName() + " has been marked back in stock");
   }
}//class
