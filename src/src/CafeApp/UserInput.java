package CafeApp;/*
Created by: Conor McErlean
Created on: 03/12/2019

Class for safely handling user input
*/

import java.util.Scanner;

public class UserInput {
   private static Scanner keyboard = new Scanner(System.in);

   // Method to get user input and protect from incorrect entries.
   protected static int getIntInput(){
      int inputvalue;
      try{
         inputvalue = keyboard.nextInt();
         return inputvalue;
      }//Try
      catch (Exception issue){
         inputvalue = 99;
         return inputvalue;
      }
   }//GetUserInput

   protected static int getIntInput(String message){
      int inputvalue;
      try{
         System.out.print(message);
         inputvalue = keyboard.nextInt();
         return inputvalue;
      }//Try
      catch (Exception issue){
         inputvalue = 99;
         return inputvalue;
      }
   }//GetUserInput

   // Method for getting an double input
   protected static double getDoubleInput(){
      double inputValue;
      try{
         inputValue = keyboard.nextDouble();
         return inputValue;
      }//Try
      catch (Exception issue){
         System.out.println("Incorrect value entered, defaulting to £0.00");
         inputValue = 0.00;
         return inputValue;
      }

   }//GetDoubleInput// Method for getting an double input
   protected static double getDoubleInput(String message){
      double inputValue;
      try{
         System.out.print(message);
         inputValue = keyboard.nextDouble();
         return inputValue;
      }//Try
      catch (Exception issue){
         System.out.println("Incorrect value entered, defaulting to £0.00");
         inputValue = 0.00;
         return inputValue;
      }
   }//GetDoubleInput

   // Method for getting a character input
   protected static char getCharInput(){
      String inputValue;
      char returnValue;
      try{
         inputValue = keyboard.next();
         returnValue = inputValue.toLowerCase().charAt(0);

         if (returnValue == 'n' || returnValue == 'y') {
            return returnValue;
         }
         else{
            System.out.println("Incorrect value entered, defaulting to " +
                  "No.");
            return 'n';
         }
      }//Try
      catch (Exception issue){
         System.out.println("Incorrect value entered, defaulting to No.");
         returnValue = 'n';
         return returnValue;
      }
   }//GetCharInput

   // Method for getting a character input
   protected static char getCharInput(String message){
      String inputValue;
      char returnValue;
      try{
         System.out.print(message);
         inputValue = keyboard.next();
         returnValue = inputValue.toLowerCase().charAt(0);

         if (returnValue == 'n' || returnValue == 'y') {
            return returnValue;
         }
         else{
            System.out.println("Incorrect value entered, defaulting to " +
                  "No.");
            return 'n';
         }
      }//Try
      catch (Exception issue){
         System.out.println("Incorrect value entered, defaulting to No.");
         returnValue = 'n';
         return returnValue;
      }
   }//GetCharInput

   protected static String getString(String message){
      System.out.print(message);
      return keyboard.next();
   }

}//class
