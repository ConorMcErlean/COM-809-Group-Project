package CafeApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pg19coj on 21/11/2019
 * Methods to take an order
 */
public class TillOperator extends Staff {

    //defaultConstructor
    protected TillOperator(int loginCode) {
        super(loginCode);
    }//defaultConstructor


    public static Scanner keyboard = new Scanner(System.in);

    //variables used throughout
    private static int numAtTable;
    private static int tableNumber;



    // method for getting table number/ amount of people at table:
    protected static void tableInfo() {
        System.out.print("\nEnter Table Number: ");
        int tableNumber = keyboard.nextInt();
        TillOperator.setTableNumber(tableNumber);
        System.out.print("Number of people at table: ");
        int noOfPeople = keyboard.nextInt();
        TillOperator.setNumAtTable(noOfPeople);
    }//takeOrder

    //set Methods for table number/ amount of people at table
    public static void setTableNumber(int tableNo) {
        tableNumber = tableNo;
    }//setTableNumber

    public static void setNumAtTable(int peopleAtTable) {

        numAtTable = peopleAtTable;
    }//setNumAtTable

    //methods to get table number and number of people at the table:
    public static int getTableNumber() {
        return tableNumber;
    }//geTableNumber

    public static int getNumAtTable() {
        return numAtTable;
    }//geNumAtTable

    //method to take table order
    protected static void tableOrder(){
        tableInfo() ;
        TakeOrder.startOrder();
    }//tableOrder

    //method to add to order
    protected static void addToOrder(){
        TakeOrder.addToOrder();
    }//tableOrder

    //method to view current order
    protected static void viewCurrentOrder() {
        System.out.println("The current order is: ");
        TakeOrder.viewOrder();
    }//viewCurrentOrder

    //method to remove item from order
    protected static void removeOrderItem(){
        TakeOrder.removeFromOrder();
        System.out.print( "Item has been removed");
    }//removeOrderItem

}//class


