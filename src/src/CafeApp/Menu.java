package CafeApp;
/*
The code below is source code for the applications menu system, and the relevant
branches for each of the roles: Till, Kitchen, Management.

The menu assumes the user knows their individual login code, but for
demonstration purposes used the logins below:
Till: 1111
Kitchen: 2222
Management: 3333
*/

public class Menu {

   // Objects & Variables required for main menu
   static private boolean shutdown = false;
   static private boolean logout = false;
   static private int loginCode;
   static private int choice;
   static private String greeting = "Welcome to the Cafe app: \n"
         + "\t\t" + "\t) (\n"
         + "\t\t" + "\t( )\n"
         + "\t\t" + " |\t\t|\n"
         + "\t\t" + " |\t\t|)\n"
         + "\t\t" + " |\t\t|\n"
         + "\t\t" + " \\______/\n";

   // Simple method to greet on first opening & prepare menu.
   protected static void greeting(){
      System.out.println(greeting);
      StockList.readyMenu();
   }//greeting

   // Menu System for the CafeApp, allows a user to enter a login code and move
   // to the relevant sub-menu.
   protected static void login(){
      //Do while loop to repeat the login section until user chooses to exit.
      do {
         System.out.println("\nPlease enter your Staff Login Code " +
               "(or enter 0000 to shut-down).");
         loginCode = UserInput.getIntInput("Login: ");

         // Switch block, leading into submenus
         switch (loginCode) {
            case 1111:
               // Code for entry into till menu below
               System.out.println("You have entered the till");
               tillMenu();
               // Exit to login screen
               break;
            case 2222:
               // Code for entry into kitchen menu below
               System.out.println("You have entered the kitchen");
               Kitchen();
               // Exit to login screen
               break;
            case 3333:
               // Code for entry into manager menu below
               System.out.println("you have entered manager mode");
               Manager();
               // Exit to login screen
               break;
            case 0000:
               // Code to exit system and break loop
               System.out.println("System shutting down.");
               shutdown = true;
               break;
            default:
               // If incorrect entry is used
               System.out.println("Sorry, this login code is not recognised. " +
                     "Speak to your manager if there is an error.");
               break;
         }// Switch
      }while (!shutdown);
   }//MainMenu

   // Program to provide the counter staff with options of what to do, entered
   // from the main menu.
   private static void tillMenu() {

      //do..while to keep the menu looping
      do {
         //switch statement to offer the till staff options of what to do
         System.out.println("\nTill Operator\nSelect an option: ");
         System.out.println("1. \t Take Order");
         System.out.println("2. \t Add to Order");
         System.out.println("3. \t View Order");
         System.out.println("4. \t Remove Item from Order");
         System.out.println("5. \t View out of Stock");
         System.out.println("6. \t Print Bill");
         System.out.println("7. \t Take Payment");
         System.out.println("8. \t Logout");
         choice = UserInput.getIntInput("Enter Choice: ");
         logout = false;

         //Output
         switch (choice) {
            case 1:
               //methods to take order
                Till.tableOrder();
               break;
            case 2:
               //method to add to order
                Till.addToExisting();
               break;
            case 3:
               //method to view order
                Till.viewCurrentOrders();
               break;
            case 4:
               //method to remove from order
                Till.removeOrderItem();
               break;
            case 5:
               //method to view out of stock
                System.out.println("\nView out of stock");
                StockList.viewOutOfStock();
               break;
            case 6:
               //method to print bill to be added
                Till.printBill();
               break;
            case 7:
               // Method to take Payment
                Till.takePayment();
                break;
            case 8:
               //method to return to start
                System.out.print("\nReturn to log in page");
                logout = true;
                break;
            default:
                System.out.println("\nOption not recognised, please try again");
                break;
         }//switch
      } while (!logout);
   }//Till Menu

   // Below is the method that will be used in the main menu to access the
   // kitchen menu.
   private static void Kitchen(){
      // The below do..while loop will allow you to perform as many actions as
      // required in the kitchen staff menu then when finished it will allow
      // logout by setting a boolean value to true.
      do {
         // User prompt
         System.out.println("\nWhat do you require?");
         System.out.println("1. View current orders"
               + "\n2. View out of stock items"
               + "\n3. Mark item out of stock"
               + "\n4. Mark item back in stock"
               + "\n5. Logout");
         choice = UserInput.getIntInput("Enter Choice: ");
         logout= false;

         // Switch block where each option calls the static methods of the
         // Kitchen Class to complete the function.
         switch (choice){
            case 1:
               Till.viewCurrentOrders();
               break;
            case 2:
               System.out.println("Out of stock items:");
               StockList.viewOutOfStock();
               break;
            case 3:
               Kitchen.markOutOfStock();
               break;
            case 4:
               Kitchen.markBackInStock();
               break;
            case 5:
               System.out.println("Logging out");
               logout = true;
               break;
            default:
               System.out.println("Choice not recognised");
               break;
         }// Switch
      } while (!logout);
   }// Kitchen

   // This method will be used in the main menu to access the manager menu,
   // providing the managerial functions.
   protected static void Manager() {
      //The following do..while loop will allow you to perform as many actions
      // as required within the ManagerMenu when finished, you can logout by
      // setting a boolean value to true.
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
         choice = UserInput.getIntInput("Enter Choice: ");
         logout = false;

         switch (choice) {
            case 1:
               Management.addItem();
               break;
            case 2:
               Management.removeItem();
               break;
            case 3:
               Till.viewCurrentOrders();
               break;
            case 4:
               Till.applyDiscount();
               break;
            case 5:
               System.out.println("Out of stock items:");
               StockList.viewOutOfStock();
            case 6:
               Kitchen.markOutOfStock();
               break;
            case 7:
               Kitchen.markBackInStock();
               break;
            case 8:
               System.out.println("Logging out");
               logout = true;
               break;
            default:
               System.out.println("Choice not recognised");
               break;
         }// Switch
      } while (!logout);
   }//Manager Menu

}//class
