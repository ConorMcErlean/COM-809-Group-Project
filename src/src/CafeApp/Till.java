package CafeApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jennifer Coggan on 21/11/2019
 * Methods to take an order
 */
public class Till extends Staff {
    // Static Variables
    static Scanner keyboard = new Scanner(System.in);
    static private boolean next = true;

    // Order Arrays
    static ArrayList<Item> order = new ArrayList<Item>();

    //defaultConstructor
    protected Till(int loginCode) {
        super(loginCode);
    }//defaultConstructor


    //variables used throughout
    private static int numAtTable;
    private static int tableNumber;



    // method for getting table number/ amount of people at table:
    protected static void tableInfo() {
        System.out.print("\nEnter Table Number: ");
        int tableNumber = keyboard.nextInt();
        Till.setTableNumber(tableNumber);
        System.out.print("Number of people at table: ");
        int noOfPeople = keyboard.nextInt();
        Till.setNumAtTable(noOfPeople);
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
        startOrder();
    }//tableOrder

    //method to add to order

    //method to view current order
    protected static void viewCurrentOrder() { viewOrder();
    }//viewCurrentOrder

    //method to remove item from order
    protected static void removeOrderItem(){
        removeFromOrder();
    }//removeOrderItem



    //method to start to take order
    protected static void startOrder() {
        int choice;
        char response = 'y';
        while (response == 'y') {
            order.add(StockList.selectItem());
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
            order.add(StockList.selectItem());
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
            System.out.println(number + item.getName());
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


