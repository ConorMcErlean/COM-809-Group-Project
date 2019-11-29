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
    static  private int choice;

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

    // Program to provide the counter staff with options of what to do
    protected static void TillOpMenu() {

        //do..while to keep the menu looping
        do {
            //switch statement to offer the till staff options of what to do
            System.out.println("\nTill Operator\nEnter a menu choice: ");
            System.out.println("1. \t Take Order");
            System.out.println("2. \t Add to Order");
            System.out.println("3. \t View Order");
            System.out.println("4. \t Remove Item from Order");
            System.out.println("5. \t View out of Stock");
            System.out.println("6. \t Print Bill");
            System.out.println("7. \t Logout");
            choice = keyboard.nextInt();

            //Output
            switch (choice) {
                case 1:
                    //methods to take order
                    Till.tableOrder();
                    next = false;
                    break;
                case 2:
                    //method to add to order
                    Till.addToOrder();
                    next = false;
                    break;
                case 3:
                    //method to view order
                    Till.viewCurrentOrder();
                    next = false;
                    break;
                case 4:
                    //method to remove from order
                    Till.removeOrderItem();
                    next = false;
                    break;
                case 5:
                    //method to view out of stock
                    MenuForCafe.viewOutOfStock();
                    next = false;
                    break;

                case 6:
                    //method to print bill to be added
                    System.out.print("You have opted to print a bill");
                    next = false;
                    break;
                case 7:
                    //method to return to start
                    System.out.print("You have opted to return to log in page");
                    next = true;
                    break;
                default:
                    System.out.println("Option not recognised, please try again");
                    next = false;;
                    break;
            }//switch
        } while (!next);

    }//main

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


