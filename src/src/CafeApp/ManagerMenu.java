package CafeApp;
import java.util.Scanner;
/*
Created by Matthew McCafferty
Created on 26/11/19

This sub-menu is for the manager. It will allow access to functions within the ManagementStaff class.
 */

public class ManagerMenu {
    static private Scanner manageScan = new Scanner(System.in);
    static private boolean logout = false;
    static private int choice;

    // This method will be used in the main menu to access the manager menu.
    protected static void Manager() {


        //The following do..while loop will allow you to perform as many actions as required within the ManagerMenu
        //When finished, you can logout by setting a boolean value to true.
        do {
            System.out.println("\nPlease select an option.");
            System.out.println("1. Add item to menu"
                    + "\n2. Remove item from the menu"
                    + "\n3. View current orders"
                    + "\n4. Apply discount"
                    + "\n5.View out of stock"
                    + "\n6. Mark item out of stock"
                    + "\n7. Mark item back in stock"
                    + "\n8. Logout");
            choice = manageScan.nextInt();

            switch (choice) {
                case 1:
                    ManagementStaff.addItem();
                    logout = false;
                    break;
                case 2:
                    ManagementStaff.removeItem();
                    logout = false;
                    break;
                case 3:
                    KitchenStaff.viewOrders("Orders");
                    logout = false;
                    break;
                case 4:
                    ManagementStaff.applyDiscount();
                    logout = false;
                    break;
                case 5:
                    System.out.println("Out of stock items:");
                    MenuForCafe.viewOutOfStock();
                    logout = false;
                case 6:
                    KitchenStaff.markOutOfStock(MenuForCafe.selectItem());
                    logout = false;
                    break;
                case 7:
                    KitchenStaff.markBackInStock(MenuForCafe.selectOutOfStock());
                    logout = false;
                    break;
                case 8:
                    System.out.println("Logging out");
                    logout = true;
                    break;
                default:
                    System.out.println("Choice not recognised");
                    logout = false;
                    break;
            }// Switch
        } while (!logout);
    }
}
