package CafeApp;
/*
Created by: Conor McErlean
Created on: 19/11/2019

Class for menu items.
Allows each item once instantiated to have both a name and a price, alongside
holding other relevant instance variables.
*/

import java.text.DecimalFormat;

public class Item {
   // Instance variables
   private String name;
   private double price;
   private boolean inStock;
   private int discount;
   DecimalFormat df = new DecimalFormat("0.00");

   // Constructors
   public Item(String itemName, double itemPrice){
      name = itemName;
      price= itemPrice;
      inStock = true;
      discount = 0;
   }// Most likely used constructor

   public Item(){
   }// Default Constructor

   // Class Methods (Accessors and Mutators)

   protected String getName() {
      return name;
   }


   protected double getPrice() {
      return price;
   }


   protected void setInStock(boolean inStock) {
      this.inStock = inStock;
   }

   public String toString(){
      if (inStock){
         return "The item " + name + " costs £" + df.format(price)
               + ", it is currently in stock and has a discount of "
               + discount + "%.\n";
      }//if
      else{
         return "The item " + name + " costs £" + df.format(price)
               + ", it is currently out of stock and had a discount of "
               + discount + "%.\n";
      }//else
   }//toString()
}//class
