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

   public Item(String itemName, double itemPrice, boolean itemInStock,
               int introDiscount){
      name = itemName;
      price = itemPrice;
      inStock = itemInStock;
      discount = introDiscount;
   }// Alternate constructor for when all fields are known

   // Class Methods (Accessors and Mutators)
   // All have been created but some may be unnecessary.
   // Additional methods can be removed at a later date.

   protected String getName() {
      return name;
   }

   protected void setName(String name) {
      this.name = name;
   }

   protected double getPrice() {
      return price;
   }

   protected void setPrice(double price) {
      this.price = price;
   }

   protected boolean getInStock() {
      return inStock;
   }

   protected void setInStock(boolean inStock) {
      this.inStock = inStock;
   }

   protected int getDiscount() {
      return discount;
   }

   protected void setDiscount(int discount) {
      this.discount = discount;
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
