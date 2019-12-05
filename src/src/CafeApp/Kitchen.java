package CafeApp;
/*
Created by: Conor McErlean
Created on: 19/11/2019

Kitchen Staff Class, contains the functions required by kitchen staff and
accessed through the Kitchen Menu method of the Menu.
*/

class Kitchen extends Staff {
   // Methods will all be static to avoid the need to instantiate an object.
   //Static Variables

   // Constructors - I may remove this soon as there is no need to instantiate
   // the Kitchen class.
   protected Kitchen(int loginCode){
      super(loginCode);
   }// Default Constructor

   // Method to mark an item out of stock, using the selectItem() Method, the
   // addToOutOfStock() Method and the setInStock() Method.
   protected static void markOutOfStock(){
      Item item = StockList.selectItem();
      item.setInStock(false);
      StockList.addToOutOfStock(item);
      System.out.println("The item " + item.getName() + " has been marked " +
            "out-of-stock.");
   }

   // Method to mark an item back in stock. using the selectItem() Method, the
   // setInStock() Method & the removeFromOutOfStock() Method.
   protected static void markBackInStock(){
      // Line below prevents eternal loops
      if (StockList.getOutOfStockSize() > 0) {
         Item item = StockList.selectOutOfStock();
         StockList.removeFromOutOfStock(item);
         System.out.println("The item " + item.getName() + " has been marked" +
                 " back in stock");
      }//if
      else{
         System.out.println("There is currently nothing out of stock.");
      }
   }
}//class
