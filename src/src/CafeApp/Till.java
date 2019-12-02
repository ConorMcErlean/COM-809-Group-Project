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
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static double total;
    private static boolean next = true;
    private static int numAtTable;
    private static int tableNumber;

    // Order Arrays
    static private ArrayList<Item> order = new ArrayList<Item>();

    //defaultConstructor
    protected Till(int loginCode) {
        super(loginCode);
    }//defaultConstructor

    // Method for getting an integer input
    private static int getIntegerInput(){
        Scanner keyboard = new Scanner(System.in);
        int inputValue;
        try{
            inputValue = keyboard.nextInt();
            return inputValue;
        }//Try
        catch (Exception issue){
            inputValue = 99;
            return inputValue;
        }
    }//GetIntegerInput

    // Method for getting an double input
    private static double getDoubleInput(){
        Scanner keyboard = new Scanner(System.in);
        double inputValue;
        try{
            inputValue = keyboard.nextDouble();
            return inputValue;
        }//Try
        catch (Exception issue){
            System.out.println("Incorrect value entered, defaulting to £0.00");
            inputValue = 0.00;
            return inputValue;
        }
    }//GetDoubleInput

    // Method for getting a character input
    private static char getCharInput(){
        Scanner keyboard = new Scanner(System.in);
        String inputValue;
        char returnValue;
        try{
            inputValue = keyboard.next();
            returnValue = inputValue.toLowerCase().charAt(0);

            if (returnValue == 'n' || returnValue == 'y') {
                return returnValue;
            }
            else{
                System.out.println("Incorrect value entered, defaulting to " +
                      "No.");
                return 'n';
            }
        }//Try
        catch (Exception issue){
            System.out.println("Incorrect value entered, defaulting to No.");
            returnValue = 'n';
            return returnValue;
        }
    }//GetCharInput

    // method for getting table number/ amount of people at table:
    protected static void tableInfo() {
        System.out.print("\nEnter Table Number: ");
        int tableNumber = getIntegerInput();
        Till.setTableNumber(tableNumber);
        System.out.print("Number of people at table: ");
        int noOfPeople = getIntegerInput();
        Till.setNumAtTable(noOfPeople);
    }//takeOrder

    //set Methods for table number/ amount of people at table
    protected static void setTableNumber(int tableNo) {
        tableNumber = tableNo;
    }//setTableNumber

    protected static void setNumAtTable(int peopleAtTable) {

        numAtTable = peopleAtTable;
    }//setNumAtTable

    //methods to get table number and number of people at the table:
    protected static int getTableNumber() {
        return tableNumber;
    }//geTableNumber
    protected static int getNumAtTable() {
        return numAtTable;
    }//geNumAtTable

    //method to take table order
    protected static void tableOrder(){
        tableInfo() ;
        startOrder();
    }//tableOrder

    //method to view current order
    protected static void viewCurrentOrder() { viewOrder();
    }//viewCurrentOrder

    //method to remove item from order
    protected static void removeOrderItem(){
        removeFromOrder();
    }//removeOrderItem

    //method to print the total cost - bill for the table
    protected static void printBill() {
        //variables
        int number = 1;
        //for loop to get the name and price of each item in the view order list
        System.out.println("\nThe bill for table " + getTableNumber() +
              " is: ");
        for (Item item: order) {
            System.out.println(item.getName() + "\t\t£:" +
                  df.format(item.getPrice()));
            //keep a running total of bill
            total = total + item.getPrice();
            number++;
        }//for
        //total cost of bill
        System.out.println("The total bill is: £ " + df.format(total));
    }//printBill

    //method to start to take order
    protected static void startOrder() {
        addToOrder();
        viewOrder();
    }//startOrder

    //method to add to an order
    protected static void addToOrder() {
        char response = 'y';
        System.out.print("\nAdd to Order: \n");
        while (response == 'y') {
            order.add(StockList.selectItem());
            System.out.print("Add another item (y or n)?: ");
            response=getCharInput();
            System.out.print("\n");
        }//while
    }//addToOrder

    protected static double getBillTotal(){
        return total;
    }
    protected static void takePayment() {
        //variables
        double  amountTendered, changeDue, billTotal = getBillTotal();
        //provide amount due:
        System.out.println("\nThe Total Bill for table " + getTableNumber() +
              " is: £" + df.format(billTotal) );

        //prompt for amount received
        System.out.print("Enter amount Tendered: £ ");
        amountTendered = getDoubleInput();

        //calculate change
        changeDue = amountTendered - billTotal;

        //output statements
        System.out.println("Payment for table " + getTableNumber());
        System.out.println("Amount Due: \t\t\t£" + df.format(billTotal) );
        System.out.println("Amount Tendered:\t\t£" + df.format(amountTendered));
        System.out.println("Change Due:\t\t\t\t£" + df.format(changeDue));
    }

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
        Scanner keyboard = new Scanner(System.in);
        int choice;
        viewOrder();
        System.out.print("Remove number: ");
        choice = keyboard.nextInt();
        order.remove(choice);
        System.out.print( "Item has been removed\n");
    }//removeFromOrder
}//class


