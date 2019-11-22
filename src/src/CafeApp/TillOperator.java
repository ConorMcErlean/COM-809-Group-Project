package CafeApp;

import java.util.Scanner;

/**
 * Created by pg19coj on 21/11/2019
 * Methods to take an order
 */
public class TillOperator {
    public static Scanner keyboard = new Scanner(System.in);

    //variables used throughout

    private int numAtTable;
    private int tableNumber;
    private static int orderCount = 0;


    // take Order Methods:

    public void setTableNumber(int tableNo) {
        tableNumber = tableNo;
    }//setTableNumber

    public void setNumAtTable(int peopleAtTable) {

        numAtTable = peopleAtTable;
    }

    public int getTableNumber (int tableNumber) {
        return tableNumber;
    }//geTableNumber

    public int getNumAtTable (int numAtTable) {
        return numAtTable;
    }//geNumAtTable


    public void requestOrderDetails(int tableNumber, int numAtTable){
        int person = 1;
        String order = "";
        System.out.print("\n");
        System.out.println("\nTable Number: " + tableNumber + "\t\tNumber of People at Table: " + numAtTable);
        System.out.print("Person 1's Order:  ");
        order = keyboard.nextLine();
        person = person + 1;
        while (person <= numAtTable){
            System.out.print("Person " + person + "'s Order:  ");
            order = keyboard.nextLine();
            person = person + 1;
        }

        orderCount = orderCount +1;
        System.out.print("\n");
    }//requestOrderDetails


    public void printOrderCount (){
        System.out.print("The number of orders is: " + orderCount);
    }


}//class

