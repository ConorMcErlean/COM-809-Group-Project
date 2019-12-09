package CafeApp;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Jennifer Coggan on 21/11/2019
 * Methods to take an order
 */

public class Till extends Staff {

    //static decimal format
    static DecimalFormat df = new DecimalFormat("0.00");

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
    protected static void tableOrder() {
        System.out.println("\nCreate a new order:");
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
            response = UserInput.getCharInput("Add another item (y or n)?: ");
            System.out.print("\n");
        }//while
    }//addToOrder

    //method to view order
    protected static void viewOrder(Order order) {
        order.viewOrder();
    }//viewOrder

    // Method to view all orders
    protected static void viewAllOrders() {
        int counter = 1;
        for (Order order : orders) {
            System.out.println(counter + ". " + order.getOrderName());
            counter++;
        }
    }//viewAllOrders

    //Method to select an order
    protected static Order getOrder() {
        viewAllOrders();
        int selection = UserInput.getArrayInput( orders,
                "Choose an order:");
        selection--;
        return orders.get(selection);
    }//getOrder

    // Method to add to existing orders
    protected static void addToExisting() {
        System.out.println("\nSelect which order you wish to edit:");
        Order adding = getOrder();
        addToOrder(adding);
    }//addToExisting

    // Method to view current orders
    protected static void viewCurrentOrders() {
        System.out.println("\nSelect the order you wish to view:");
        Order viewing = getOrder();
        viewOrder(viewing);
    }//viewCurrentOrders

    //method to remove item from order
    protected static void removeOrderItem() {
        System.out.println("\nSelect an order to edit:");
        Order order = getOrder();
        order.removeFromOrder();
    }//removeOrderItem

    //method to print the total cost - bill for the table
    protected static void printBill() {
        System.out.println("\nSelect an order to print the" +
                " bill for:");
        Order toPrint = getOrder();
        toPrint.printBill();
    }//printBill

    // Method to select and pay an order.
    protected static void takePayment() {
        System.out.println("\nSelect which bill is being paid:");
        Order toPay = getOrder();
        toPay.payOrder();
    }//takePayment
}//class

