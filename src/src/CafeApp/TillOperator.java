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
    private static int numAtTable;
    private static int tableNumber;
    private String order;
    private static int orderCount = 0;


    // set methods for table number/ amount of people at table:

    public static void setTableNumber(int tableNo) {
        tableNumber = tableNo;
    }//setTableNumber

    public static void setNumAtTable(int peopleAtTable) {

        numAtTable = peopleAtTable;
    }//setNumAtTable


    //methods to get table number and number of people at the table:
    public int getTableNumber (int tableNumber) {
        return tableNumber;
    }//geTableNumber

    public int getNumAtTable (int numAtTable) {
        return numAtTable;
    }//geNumAtTable

    public static void tableInfo(){
        System.out.print("Enter Table Number: ");
        int tableNumber = keyboard.nextInt();
        TillOperator.setTableNumber(tableNumber);
        System.out.print("Number of people at table: ");
        int noOfPeople = keyboard.nextInt();
        TillOperator.setNumAtTable(noOfPeople);
    }//takeOrder

      //  orderCount = orderCount +1;
       // System.out.print("\n");
      //  return order;
   // }//requestOrderDetails

    //method to print order:
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

