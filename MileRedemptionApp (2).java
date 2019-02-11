/*CSCI 502          Assignment 4          Fall 2018 *
 * ********          ************           ********* *
 *                                                    *
 * Programmer : Abhinav Chamallamudi                  *
 * Z-ID : Z1826541                                    *
 * Date Due : 10/5/2018                               *
 *                                                    *
 * ------------------------------------               *
 *                                                    *
 *                                                    *
 * Description : The following piece of code          * 
 * is the test class which demonstrates and displays  *
 * the output formulated by the logics in the         *
 * MileReedemer class , it also include the           *
 * print statetments to display the output            *
 *                                                    *
 *****************************************************/

//Import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Creating MileRedemptionApp class
public class MileRedemptionApp {
 public static void main(String args[]) throws FileNotFoundException
 {
  String choice = "y";
  int departureMonth;
  int flyerMiles;
  String[] redeemed;
  Scanner userInput = new Scanner(System.in);
  
  System.out.print("Please Enter the name of .txt file containg Destinations (including .txt extension): ");
  
  File file = new File(userInput.nextLine());
  
  Scanner destinations = new Scanner(file);
  
  System.out.println("----------------------------------------------------------------");
  System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
  System.out.println("----------------------------------------------------------------");
  
  MileRedeemer mileRedeemer = new MileRedeemer();
  
  mileRedeemer.readDestinations(destinations); // Reads Destinations from list
  
  // Displaying all the possible destinations
  System.out.println("\nList of destination cities your client can travel to:\n");
  for (String destination: mileRedeemer.getCityNames()) {           
         System.out.println(destination); 
     }
  
  System.out.println("\n----------------------------------------------------------------\n");
  Scanner ch = new Scanner(System.in);
  while("y".equals(choice) || "yes".equals(choice))
  {
   
   System.out.print("Please enter your client's accumulated Frequent Flyer Miles: ");
   flyerMiles = userInput.nextInt();
   
   System.out.print("\nPlease enter your client's month of departure (1-12): ");
   departureMonth = userInput.nextInt();
   
   
   redeemed = mileRedeemer.redeemMiles(flyerMiles, departureMonth);
   
   if(redeemed.length > 0)
   {
    System.out.println("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:\n");
    for(int i = 0; i < redeemed.length; i++)
    {
     System.out.println(redeemed[i]);
    }
    
   }
   else 
   {
    System.out.println("*** Your client has not accumulated enough Frequent Flyer Miles ***");
   }
   
   System.out.print("Your client's remaining Frequent Flyer Miles: "+ mileRedeemer.getRemainingMiles());
   
   System.out.println("\n----------------------------------------------------------------\n");
   System.out.print("Do you want to continue (y/n)? ");
   choice = ch.next();
   choice.toLowerCase();
   System.out.println("\n----------------------------------------------------------------\n");
   
  }
  
  System.out.println("-------------------------------------------------------------------------");
  System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
  System.out.println("-------------------------------------------------------------------------");
 }
}
