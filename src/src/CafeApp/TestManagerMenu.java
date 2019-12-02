package CafeApp;

import java.util.Scanner;

public class TestManagerMenu {
    public static void main(String [] args) {

        Scanner keyboard = new Scanner(System.in);

         ManagerMenu managerMenu = new ManagerMenu();
         System.out.println("please select an item below you wish to edit:" );
         MenuForCafe.readyMenu();
         MenuForCafe.seeOptions();
         ManagementStaff.addItem();
         ManagementStaff.removeItem();


         managerMenu.Manager();


    }
}
