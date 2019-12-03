package CafeApp;

import javax.jws.soap.SOAPBinding;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jennifer Coggan on 21/11/2019
 * Methods to take an order
 */

public class Till extends Staff {
    // Static Variables
    private static boolean next = true;

    // Order Arrays
    static private ArrayList<Order> orders = new
          ArrayList<Order>();

    //defaultConstructor
    protected Till(int loginCode) {
        super(loginCode);
    }//defaultConstructor

    //method to take table order
    protected static void tableOrder(){
        startOrder();
    }//tableOrder

    // Method to view all orders
    protected static void viewAllOrders() {
        int counter = 1;
        for (Order order: orders){
            System.out.print(counter + order.getOrderName());
            counter++;
        }
    }//viewAllOrders

    //Method to select an order
    protected static Order getOrder(){
        viewAllOrders();
        int selection = UserInput.getIntInput("Choose an order:");
        selection--;
        return orders.get(selection);
    }

    //method to view current order
    protected static void viewCurrentOrder() {
        Order order = getOrder();
        order.viewOrder();
    }//viewCurrentOrder

    //method to remove item from order
    protected static void removeOrderItem(){
        Order order = getOrder();
        order.removeFromOrder();
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
            response= UserInput.getCharInput("Add another item (y or n)?: ");
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
        amountTendered = UserInput.getDoubleInput("Enter amount Tendered: £");

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
        try{
            int choice;
            viewOrder();
            choice = UserInput.getIntInput("Remove number: ");
            order.remove(choice);
            System.out.print( "Item has been removed\n");
        }//try
        catch (Exception issue){
            System.out.println("No such item exists.");
        }//Catch
    }//removeFromOrder
}//class


