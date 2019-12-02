package CafeApp;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *  Created by Matthew on the 27/11/19
 */

public class ManagementStaff extends Staff {
    public ManagementStaff(int loginID) { super(loginID); } // Default Constructor
static Scanner keyboard = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");


   protected static void addItem() {
       String name;
       double price;
       int counter = 1;

       for (Item newItem : MenuForCafe.menu) {
           System.out.print("Enter Item Name: ");
           name = keyboard.nextLine();
           System.out.print("Enter price: £ ");
           price = keyboard.nextDouble();
           newItem.setName(name);
           newItem.setPrice(price);
           MenuForCafe.menu.add(newItem);
//           counter++;
       }

   }

    protected static void removeItem() {
       String itemName;

        System.out.println("Please enter the item you wish to remove: ");
        itemName = keyboard.nextLine();

//        for(int removeItem =0; removeItem < MenuForCafe.menu.size();removeItem++){
//            if(itemName.equalsIgnoreCase(MenuForCafe.menu.get(removeItem).getName())){
//                MenuForCafe.menu.remove(MenuForCafe.menu.get(removeItem));
//            }//if
//        }//for

        Item dueforremoval = MenuForCafe.selectItem();
        MenuForCafe.menu.remove(dueforremoval);
    }//removeItem

//    protected static double applyDiscount(double total) {
//
//       double discount;
//
//       System.out.println("Please enter how much discount you wish to apply: ");
//       discount = keyboard.nextDouble();
//
//
//
//        }

    }
