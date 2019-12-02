package CafeApp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jennifer Coggan on 21/11/2019
 * Methods to take an order
 */
public class Till extends Staff {
    // Static Variables
    private static Scanner keyboard = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static double total;
    private static boolean next = true;

    // Order Arrays
    static private ArrayList<Item> order = new ArrayList<Item>();

    //defaultConstructor
    protected Till(int loginCode) {
        super(loginCode);
    }//defaultConstructor


    //variables used throughout
    private static int numAtTable;
    private static int tableNumber;



    // method for getting table number/ amount of people at table:
    private static void tableInfo() {
        System.out.print("\nEnter Table Number: ");
        int tableNumber = keyboard.nextInt();
        Till.setTableNumber(tableNumber);
        System.out.print("Number of people at table: ");
        int noOfPeople = keyboard.nextInt();
        Till.setNumAtTable(noOfPeople);
    }//takeOrder

    //set Methods for table number/ amount of people at table
    private static void setTableNumber(int tableNo) {
        tableNumber = tableNo;
    }//setTableNumber

    private static void setNumAtTable(int peopleAtTable) {

        numAtTable = peopleAtTable;
    }//setNumAtTable

    //methods to get table number and number of people at the table:
    private static int getTableNumber() {
        return tableNumber;
    }//geTableNumber

    public static int getNumAtTable() {
        return numAtTable;
    }//geNumAtTable

    //method to take table order
    private static void tableOrder(){
        tableInfo() ;
        startOrder();
    }//tableOrder


    //method to view current order
    private static void viewCurrentOrder() { viewOrder();
    }//viewCurrentOrder

    //method to remove item from order
    private static void removeOrderItem(){
        removeFromOrder();
    }//removeOrderItem

    //method to print the total cost - bill for the table
    protected static void printBill() {
        //variables
        int number = 1;
        //for loop to get the name and price of each item in the view order list
        System.out.println("\nThe bill for table " + getTableNumber() + " is: ");
        for (Item item: order) {
            System.out.println(item.getName() + "\t\t£:" + df.format(item.getPrice()));
            //keep a running total of bill
            total = total + item.getPrice();
            number++;
        }//for
        //total cost of bill
        System.out.println("The total bill is: £ " + df.format(total));
    }//printReceipt

    //method to start to take order
    private static void startOrder() {
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
    private static void addToOrder() {
        char response = 'y';
        System.out.print("\nAdd to Order: \n");
        while (response == 'y') {
            order.add(StockList.selectItem());
            System.out.print("Add another item (y or n)?: ");
            response=keyboard.nextLine().charAt(0);
            System.out.print("\n");
        }//while

    }//addToOrder

    private static double getBillTotal(){
        return total;
    }
    protected static void takePayment() {
        //variables
        double  amountTendered, changeDue, billTotal = getBillTotal();
        char answer;
        //provide amount due:
        System.out.println("\nThe Total Bill for table " + getTableNumber() +  " is: £" + df.format(billTotal) );

        //prompt for amount received
        System.out.print("Enter amount Tendered: £ ");
        amountTendered = keyboard.nextDouble();

        //calculate change
        changeDue = amountTendered - billTotal;

        //output statements
        System.out.println("Payment for table " + getTableNumber());
        System.out.println("Amount Due: \t\t\t£" + df.format(billTotal) );
        System.out.println("Amount Tendered:\t\t£" + df.format(amountTendered) );
        System.out.println("Change Due:\t\t\t\t£" + df.format(changeDue));

        System.out.print("Would you like to logout? (y or n) ");
        answer = keyboard.nextLine().charAt(0);

    }
    //method to view order
    private static void viewOrder(){
        int number = 1;
        System.out.println("\nThe current order is: ");
        for (Item item: order) {
            System.out.println(number + item.getName());
            number++;
        }//for
    }//viewOrder


    //method to remove from order
    private static void removeFromOrder (){
        int choice;
        viewOrder();
        System.out.print("Remove number: ");
        choice = keyboard.nextInt();
        order.remove(choice);
        System.out.print( "Item has been removed\n");
    }//removeFromOrder


}//class


