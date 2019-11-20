package CafeApp;/*
Created by: Conor McErlean
Created on: 19/11/2019

Additional Comments...
*/

public class TestKitchenStaff {
   public static void main(String[] args) {
      String order = "1 Soda bread\n1 Egg\n1 Potato Bread";
      Item soda = new Item("Soda Bread", 3.50);
      Item egg = new Item("Fried Egg", 2.00, false, 0);

      KitchenStaff joe = new KitchenStaff(1000);
      joe.viewOrders(order);
      joe.markBackInStock(egg);
      joe.markOutOfStock(soda);
   }//main
}//class
