package CafeApp;
/*
Created by: Conor McErlean
Created on: 19/11/2019

Program to test the Item class.
*/

public class TestItem {
   public static void main(String[] args) {
      // Test creating items.
   Item soda = new Item("Soda Bread", 3.50);
   Item egg = new Item("Fried Egg", 2.00, true, 0);
   Item coffee = new Item();

      System.out.print(soda);
      System.out.print(egg);
      System.out.print(coffee);
   }//main
}//class
