package CafeApp;
/*
Created by: Conor McErlean
Created on: 03/12/2019

Class for safely handling user input
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class UserInput {
   private static Scanner keyboard = new Scanner(System.in);

   // Method to get user input and protect from incorrect entries.
   protected static int getIntInput(){
      int inputValue = 0;
      boolean invalidResponse = true;
      do {
         try {
            inputValue = keyboard.nextInt();
            invalidResponse = false;
         }//Try
         catch (Exception issue) {
            System.out.println("Try again:");
         }
      }while (invalidResponse);
      return inputValue;
   }//GetUserInput

   protected static int getIntInput(String message){
      int inputValue = 0;
      boolean invalidResponse = true;
      do {
         try {
            System.out.print(message);
            invalidResponse = false;
            inputValue = keyboard.nextInt();
         }//Try
         catch (Exception issue) {
            System.out.println("Invalid entry, Try again:");
         }
      }while (invalidResponse);
      return inputValue;
   }//GetUserInput

   //GetDoubleInput// Method for getting an double input
   protected static double getDoubleInput(String message){
      double inputValue = 0;
      boolean invalidResponse = true;
      do {
         try {
            System.out.print(message);
            inputValue = keyboard.nextDouble();
            invalidResponse = false;
         }//Try
         catch (Exception issue) {
            System.out.println("Incorrect value entered, try again:");
         }
      }while(invalidResponse);
      return inputValue;
   }//GetDoubleInput

   // Method for getting a character input
   protected static char getCharInput(){
      String inputValue;
      char returnValue = 'x';
      boolean invalidResponse = true;
      do {
         try {
            inputValue = keyboard.next();
            returnValue = inputValue.toLowerCase().charAt(0);

            if (returnValue == 'n' || returnValue == 'y') {
               invalidResponse = false;
            }
            else {
               System.out.println("Incorrect value entered, try again:");
            }
         }//Try
         catch (Exception issue) {
            System.out.println("Incorrect value entered, try again:");
         }
      }while (invalidResponse);
      return returnValue;
   }//GetCharInput

   // Method to get an array position safely
   protected static int getArrayInput(String message, ArrayList<Item> array) {
      boolean invalidResponse = true;
      int input = 0;
      System.out.println(message);
      do {
         try {
            input = keyboard.nextInt();
            if (input - 1 < array.size()) {
               invalidResponse = false;
            } else {
               System.out.println("Not an option, Try again:");
            }
         } catch (Exception issue) {
            String hold = keyboard.next();
            System.out.println("Not an option, Try again:");
         }
      } while (invalidResponse);
      return input;
   }//GetArrayInput

   // Method for getting a character input
   protected static char getCharInput(String message){
      String inputValue;
      boolean invalidResponse = true;
      char returnValue = 'x';
      do {
         try {
            System.out.print(message);
            inputValue = keyboard.next();
            returnValue = inputValue.toLowerCase().charAt(0);

            if (returnValue == 'n' || returnValue == 'y') {
               invalidResponse = false;
            } else {
               System.out.println("Incorrect value entered, try again:");
            }
         }//Try
         catch (Exception issue) {
            System.out.println("Incorrect value entered, try again:");
         }
      }while (invalidResponse);
      return returnValue;
   }//GetCharInput

   protected static String getString(String message){
      System.out.print(message);
      return keyboard.next();
   }

}//class
