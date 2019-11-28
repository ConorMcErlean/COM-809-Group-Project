package CafeApp;

import java.util.Scanner;

/**
 * Created by Jen on 26/11/2019
 * Program to provide the counter staff with options of what to do
 */
public class TillMenu {

   static Scanner keyboard = new Scanner(System.in);
    static private boolean next = true;
    static  private int choice;

    //to be accessible by TillStaff Only
    protected static void TillMenu () {

        //do..while to keep the menu looping
        do {
            //switch statement to offer the till staff options of what to do
            System.out.println("\nTill Operator\nEnter a menu choice: ");
            System.out.println("1. \t Take Order");
            System.out.println("2. \t View Order");
            System.out.println("3. \t Remove Item from Order");
            System.out.println("4. \t View out of Stock");
            System.out.println("5. \t Print Bill");
            System.out.println("5. \t Logout");
            choice = keyboard.nextInt();

            //Output
            switch (choice) {
                case 1:
                    //methods to take order
                    TillOperator.tableOrder();
                    next = true;
                    break;
                case 2:
                    //method to view order
                    TakeOrder.addToOrder();
                    //TillOperator.viewCurrentOrder();
                    break;
                case 3:
                    //method to remove from order
                    TillOperator.removeOrderItem();
                    next = true;
                    break;
                case 4:
                    //method to view out of stock
                    MenuForCafe.viewOutOfStock();
                    next = true;
                    break;

                case 5:
                    //method to print bill to be added
                    System.out.print("You have opted to print a bill");
                    next = true;
                    break;
                case 6:
                    //method to return to start
                    System.out.print("You have opted to return to log in page");
                    MainMenu.login();
                    next = false;
                    break;
                default:
                    System.out.println("Option not recognised, please try again");
                    next = true;;
                    break;
            }//switch
        } while (!next);

    }//main
}//class 