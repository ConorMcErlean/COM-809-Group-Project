package CafeApp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jennifer Coggan on 21/11/2019
 * Methods to take an order
 */
public class TillOperator extends Staff {

    //defaultConstructor
    protected TillOperator(int loginCode) {
        super(loginCode);
    }//defaultConstructor


    public static Scanner keyboard = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    //variables used throughout
    private static int numAtTable;
    private static int tableNumber;
    private static double total =0.00;



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
        TakeOrder.viewOrder();
    }//viewCurrentOrder

    //method to remove item from order
    protected static void removeOrderItem(){
        TakeOrder.removeFromOrder();
    }//removeOrderItem



    public static void printBill() {
            int number = 1;
            System.out.println("\nThe bill for table " + getTableNumber() + " is: ");
            for (Item item: TakeOrder.order) {
                System.out.println(number + ". " + item.getName() + "\t\t£:" + df.format(item.getPrice()));
                total = total + item.getPrice();
                number++;
            }//for
        System.out.println("\nThe total bill is: £ " + df.format(total));
    }//printReceipt


}//class