package CafeApp;
/*

This is a command line program written for use in a cafe or restaurant, it will
take orders, pass those orders on to the kitchen, allow reciepts to be printed
and provide management functions for adjusting prices or adding new menu items.

The following code uses the Ulster University Code Conventions.
Created as part of COM809: Professional Software Development.
The following work is a group project, written, edited and tested in equal parts
by: Conor McErlean, Jennifer Coggan & Matthew McCafferty.
Created between: 18/11/2019 & 16.12.2019.

Begin the program here.

The Class below begins the program by readying up the menu & greeting the user.
After this it opens the login system.
*/

public class CafeApp {
   public static void main(String[] args) {
      // Method to greet users on initial boot & Initialise menu
      Menu.greeting();
      // Menu for staff to login
      Menu.login();
   }//main
}//class

