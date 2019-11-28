package CafeApp;

import java.util.Scanner;

/**
 * Created by pg19coj on 21/11/2019
 * Jen's tests - program to test Till Operator
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

        //order1.setNumAtTable(peopleAtTable);
        //order1.setTableNumber(tableNumber);


        System.out.println("\n***TEST***");
        //method to start to take order


        TakeOrder.order.add(MenuForCafe.selectItem());
        TakeOrder.order.add(MenuForCafe.selectItem());
        TakeOrder.order.add(MenuForCafe.selectItem());


        TakeOrder.order.add(MenuForCafe.selectItem());





        }//class
    }//main