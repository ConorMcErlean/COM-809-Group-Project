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


//method to print the total cost - bill for the table
    protected static void printBill() {
        //variables
            int number = 1;
            //for loop to get the name and price of each item in the view order list
            System.out.println("\nThe bill for table " + getTableNumber() + " is: ");
            for (Item item: TakeOrder.order) {
                System.out.println(item.getName() + "\t\t£:" + df.format(item.getPrice()));
                //keep a running total of bill
                total = total + item.getPrice();
                number++;
            }//for
        //total cost of bill
        System.out.println("The total bill is: £ " + df.format(total));
    }//printReceipt

    protected static double getBillTotal(){
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


}//class