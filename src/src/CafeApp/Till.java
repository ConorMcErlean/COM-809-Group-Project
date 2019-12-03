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
        System.out.println("Creating a new order:");
        Order order = new Order();
        addToOrder(order);
        viewOrder(order);
        orders.add(order);
    }//tableOrder

    //method to add to an order
    protected static void addToOrder(Order order) {
        char response = 'y';
        System.out.print("\nAdd to Order: \n");
        while (response == 'y') {
            order.add(StockList.selectItem());
            response= UserInput.getCharInput("Add another item (y or n)?: ");
            System.out.print("\n");
        }//while
    }//addToOrder

    //method to view order
    protected static void viewOrder(Order order){
        order.viewOrder();
    }//viewOrder

    // Method to view all orders
    protected static void viewAllOrders() {
        int counter = 1;
        for (Order order: orders){
            System.out.println(counter +". "+ order.getOrderName());
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

    // Method to add to existing orders
    protected static void addToExisting(){
        System.out.println("Please select which order you wish to edit:");
        Order adding = getOrder();
        addToOrder(adding);
    }

    // Method to view current orders
    protected static void viewCurrentOrders(){
        System.out.println("Please select the order you would like to view:");
        Order viewing = getOrder();
        viewOrder(viewing);
    }

    //method to remove item from order
    protected static void removeOrderItem(){
        System.out.println("Please select which order you wish to edit:");
        Order order = getOrder();
        order.removeFromOrder();
    }//removeOrderItem

    //method to print the total cost - bill for the table
    protected static void printBill() {
        System.out.println("Please select which order you wish to print a" +
              " bill for:");
        Order toPrint = getOrder();
        toPrint.printBill();
    }//printBill

    protected static void takePayment() {
        System.out.println("Please select which bill is being paid:");
        Order toPay = getOrder();

        //variables
        DecimalFormat df = new DecimalFormat("0.00");
        double  amountTendered, changeDue, billTotal = toPay.getBillTotal();
        //provide amount due:
        System.out.println("\nThe Total Bill for order " + toPay.getOrderName()
              + " is: £" + df.format(billTotal) );

        //prompt for amount received
        amountTendered = UserInput.getDoubleInput("Enter amount Tendered: £");

        //calculate change
        changeDue = toPay.payOrder(amountTendered);

        //output statements
        System.out.println("Payment for order " + toPay.getOrderName());
        System.out.println("Amount Due: \t\t\t£" + df.format(billTotal) );
        System.out.println("Amount Tendered:\t\t£" + df.format(amountTendered));
        System.out.println("Change Due:\t\t\t\t£" + df.format(changeDue));
    }

}//class


