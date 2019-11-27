package CafeApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pg19coj on 21/11/2019
 * Methods to take an order
 */
public class TillOperator extends Staff {

    //defaultConstructor
    protected TillOperator(int loginCode){
        super(loginCode);
    }//defaultConstructor


    public static Scanner keyboard = new Scanner(System.in);

    //variables used throughout
    private int numAtTable;
    private int tableNumber;
    private String order;
    private static int orderCount = 0;


    // take Order Methods:
    public void setTableNumber(int tableNo) {
        tableNumber = tableNo;
    }//setTableNumber

    public void setNumAtTable(int peopleAtTable) {

        numAtTable = peopleAtTable;
    }//setNumAtTable

    //methods to get table number and number of people at the table
    public int getTableNumber (int tableNumber) {
        return tableNumber;
    }//geTableNumber

    public int getNumAtTable (int numAtTable) {
        return numAtTable;
    }//geNumAtTable



    //method to receive the order details
    //public String requestOrderDetails(int tableNumber, int numAtTable){
        //int person = 1;
       // order = "";
       // System.out.print("\n");
        //System.out.println("\nTable Number: " + tableNumber + "\t\tNumber of People at Table: " + numAtTable);
       // System.out.print("Person 1's Order:  ");
       // order = keyboard.nextLine();
      //  person = person + 1;
       // while (person <= numAtTable){
          //  System.out.print("Person " + person + "'s Order:  ");
           // order = keyboard.nextLine();
          //  person = person + 1;
       // }

      //  orderCount = orderCount +1;
       // System.out.print("\n");
      //  return order;
   // }//requestOrderDetails

    public void printOrder (){
       System.out.println("table " + tableNumber + "'s order is: " + order + "\n");
    } //getOrder

    //method to printOrder Count
    public void printOrderCount (){
        System.out.print("The number of orders is: " + orderCount);
    }

    //method to get Order Count
    public int getOrderCount() {
        return orderCount;
    }//getOrderCount
}//class

