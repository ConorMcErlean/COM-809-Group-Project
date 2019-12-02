package CafeApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jennifer Coggan on 27/11/2019
 * Program to take a tables order
 */
public class TakeOrder {
    static Scanner keyboard = new Scanner(System.in);

    static ArrayList<Item> order = new ArrayList<Item>();

   //copy of Conor's method to be able to see menu items
   private static void seeOptions(){
      int counter = 1;
      for (Item item: MenuForCafe.menu){
          System.out.println(counter + ". " + item.getName());
          counter++;
      }//for
   }// See Options

    //method to start to take order
    protected static void startOrder() {
       int choice;
       char response = 'y';
       while (response == 'y') {
            order.add(MenuForCafe.selectItem());
            System.out.print("Add another item (y or n)?: ");
             response=keyboard.nextLine().charAt(0);
             System.out.print("\n");
        }//while
        viewOrder();
    }//startOrder

    //method to add to order
    protected static void addToOrder() {
        char response = 'y';
       System.out.print("\nAdd to Order: \n");
        while (response == 'y') {
            order.add(MenuForCafe.selectItem());;
            System.out.print("Add another item (y or n)?: ");
            response=keyboard.nextLine().charAt(0);

            System.out.print("\n");
        }//while

    }//addToOrder

    //method to view order
    protected static void viewOrder(){
        int number = 1;
        System.out.println("\nThe current order is: ");
        for (Item item: order) {
            System.out.println(number + ". " + item.getName());
            number++;
        }//for
    }//viewOrder


    //method to remove from order
    protected static void removeFromOrder (){
        int choice;
        viewOrder();
        System.out.print("Remove number: ");
        choice = keyboard.nextInt();
        order.remove(choice);
        System.out.print( "Item has been removed\n");
    }//removeFromOrder



}//class



