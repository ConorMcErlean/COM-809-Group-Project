package CafeApp;/*
Created by: Conor McErlean
Created on: 29/11/2019

Additional Comments...
*/

import java.util.Scanner;

public class TestingNOTFORUSE {

   public static void addItem(){
      Scanner test = new Scanner(System.in);
      System.out.println("Item Name:");
      String name = test.next();
      System.out.println("Item Price:");
      double price = test.nextDouble();
      Item item = new Item(name, price);
      MenuForCafe.menu.add(MenuForCafe.menu.size(), item );
   }

   public static void main(String[] args) {
      MenuForCafe.readyMenu();
      MenuForCafe.seeOptions();
      addItem();
      addItem();
      MenuForCafe.seeOptions();
   }//main
}//class
