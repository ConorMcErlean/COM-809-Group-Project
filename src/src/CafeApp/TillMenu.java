package CafeApp;

import java.util.Scanner;

/**
 * Created by Jen on 26/11/2019
 * Program to provide the counter staff with options of what to do
 */
public class TillMenu {

   static Scanner keyboard = new Scanner(System.in);

   //to be accessible by TillStaff Only
    protected static void CounterMenu () {

         //switch statements to offer the till staff options of what to do
        System.out.println("1. \t Take Order");
        System.out.println("2. \t Print table's bill");
        System.out.println("3. \t View out of Stock");
        System.out.println("4. \t Empty ATM");
        System.out.println("5. \t Logout");

        System.out.print("\nEnter a menu choice: ");
        int choice = keyboard.nextInt();

        //Output
        switch (choice) {
            case 1:
                //method to take order to be added
                System.out.print("You have opted to take order");
                break;
            case 2:
                //method to print bill to be added
                System.out.print("You have opted to print a bill");
                break;
            case 3:
                //method to view out of stock to be added
                System.out.print("You have opted to view the out of stock items");
                MenuForCafe.viewOutOfStock();
                break;
            case 4:
                //empty ATM;

                break;
            case 5:
                //method to return to start
                System.out.print("You have opted to return to log in page");
            default:
                System.out.println("You have not entered a recognised option, please try again");
        }//switch

    }//main
}//class 