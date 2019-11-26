package CafeApp;
/*
Created by: Conor McErlean
Created on: 19/11/2019

Kitchen Staff Class, contains the functions required by kitchen staff an accessed through the KitchenMenu Class.
*/

class KitchenStaff extends Staff {
   // Methods will all be static to avoid the need to instantiate an object.

   // Constructors - I may remove this soon as there is no need to instantiate the KitchenStaff class.
   protected KitchenStaff(int loginCode){
      super(loginCode);
   }// Default Constructor

   // Early version of method to print order to console. Once the TillOperator class has a method to add to an array
   // any orders this method will need to be adjusted.
   protected static void viewOrders(String order){
      System.out.println(order);
   }//viewOrders

   // Method to mark an item out of stock. Takes in an item (the selectItem() method of the MenuForCafe Class will help
   // here and sets the instance variable inStock to false, and uses the addToOutOfStock() method.
   protected static void markOutOfStock(Item item){
      item.setInStock(false);
      MenuForCafe.addToOutOfStock(item);
      System.out.println("The item " + item.getName() + " has been marked out-of-stock.");
   }

   // Method to mark an item back in stock. Takes in an item (the selectOutOfStock() method of the MenuForCafe Class
   // will help here and sets the instance variable inStock to true, and uses the removeFromOutOfStock() method.
   protected static void markBackInStock(Item item){
      item.setInStock(true);
      MenuForCafe.removeFromOutOfStock(item);
      System.out.println("The item " + item.getName() + " has been marked back in stock");
   }
}//class
