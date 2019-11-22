package CafeApp;

import java.util.Scanner;

/**
 * Created by pg19coj on 21/11/2019
 * COMMENTS ABOUT PROGRAM HERE
 */
public class TestTillOperator {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int tableNumber, peopleAtTable, orderCount;

        TillOperator order1 = new TillOperator(101);

        System.out.print("Enter Table Number: ");
        tableNumber = keyboard.nextInt();
        System.out.print("Enter Number of people at table: ");
        peopleAtTable = keyboard.nextInt();


        order1.setNumAtTable(peopleAtTable);
        order1.setTableNumber(tableNumber);
        order1.requestOrderDetails(tableNumber, peopleAtTable);

        TillOperator order2 = new TillOperator(101);

        System.out.print("Enter Table Number: ");
        tableNumber = keyboard.nextInt();
        System.out.print("Enter Number of people at table: ");
        peopleAtTable = keyboard.nextInt();


        order2.setNumAtTable(peopleAtTable);
        order2.setTableNumber(tableNumber);
        order2.requestOrderDetails(tableNumber, peopleAtTable);

        order2.printOrderCount();


    }//class
}//main