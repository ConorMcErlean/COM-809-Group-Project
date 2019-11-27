package CafeApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pg19coj on 27/11/2019
 * Program to take a tables order
 */
public class TillTakeOrder {
    static Scanner keyboard = new Scanner(System.in);

    protected static void takeOrder()

    {
        //switch statements to offer the till staff options of what to do

        System.out.println("\n1. \t Take Order");
        System.out.println("2. \t See Order");
        System.out.println("3. \t Remove Item");
        System.out.println("4. \t ");
        System.out.println("5. \t Return to Till Op Menu");

        System.out.print("\nEnter a menu choice: ");
        int choice = keyboard.nextInt();

        //Output
        switch (choice) {
            case 1:
                //method to take order to be added
                System.out.println("You have opted to take order");
                TillOperator.tableInfo();

                break;
            case 2:
                //method to print bill to be added
                System.out.print("You have opted to see the order");
                break;
            case 3:
                //method to view out of stock to be added
                System.out.print("You have opted to remove an item");

                break;
            case 4:
                //empty ATM;

                break;
            case 5:
                //method to return to start
                System.out.print("return to Till Op's menu page");
            default:
                System.out.println("Option not recognised, please try again");
        }//switch
    }


    static ArrayList<Item> order = new ArrayList<Item>();




}//class 