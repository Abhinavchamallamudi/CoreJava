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
 * is the MileReedemer class and involves the logic   *
 * to determine the suitable trips the customer can   *
 * take as per the users input for the mielage and    *
 * month it also computes the remaining miles after   *
 * taking the trips and returns it                    *
 *                                                    *
 *****************************************************/

//Import Statements 
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//Creating the MileReedemer class for MileReedemer 
public class MileRedeemer {
 
 private Destination[] destinations;
 private int remainingMiles;
 
 public MileRedeemer()
 {
  destinations = null;
  remainingMiles = 0;
 }
 
 //Creating the readDestinations method
 public void readDestinations(Scanner fileScanner)
 {
  ArrayList<Destination> destinationList = new ArrayList<Destination>();
  int i = 0;
  while (fileScanner.hasNext()){
      String[] destination = fileScanner.nextLine().split(";");
      String[] months = destination[4].split("-");
      destinationList.add(new Destination(destination[0],Integer.parseInt(destination[1]),
        Integer.parseInt(destination[2]),Integer.parseInt(destination[3]),
        Integer.parseInt(months[0]),Integer.parseInt(months[1])));
      
   }
  destinations = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);
  Arrays.sort(destinations, new MileageComparator());
 }
 
 
//Creating the getCityNames method  
 public String[] getCityNames()
 {
  String[] cityNames = new String[destinations.length];
  
  for (int i=0; i<destinations.length;i++)
   cityNames[i] = destinations[i].getName();
  
  Arrays.sort(cityNames);
  return cityNames;
  
 }
 
//Creating the reedemMile method  
 public String[] redeemMiles(int miles, int month)
 {
  remainingMiles = miles;
  ArrayList<Destination> dest = new ArrayList<Destination>();
  ArrayList<Destination> destFFMApplied = new ArrayList<Destination>();
  ArrayList<Destination> finalDests = new ArrayList<Destination>();
  dest = flightsInMonth(month);
  
  destFFMApplied = applyFFM(dest);
  
  finalDests = normalMileage(month,destFFMApplied);
  
  String[] availableTrips = new String[finalDests.size()];
  
  ArrayList<Integer> index = upgradeClass(finalDests);
  Collections.sort(index);
  
  for (int i = 0; i < finalDests.size(); i++)
  {
   availableTrips[i] = "* A trip to "+finalDests.get(i).getName()+" in Economy Class";
  }
  
  for (int i = 0; i < finalDests.size(); i++)
  {
   String Name = finalDests.get(i).getName();
   for (int ind: index)
   {    
    if(i == ind) 
    {
     System.out.println(i);
     availableTrips[i] = "* A trip to "+Name+" in First Class";
     break;   
    }     
   }
   
  }  
  return availableTrips;
 }
 
 private ArrayList<Destination> normalMileage(int m, ArrayList<Destination> dests)
 {
  for(Destination d: destinations)
  {
   if(!(d.getStartingMonth() <= m && d.getEndingMonth() >= m)  && d.getNormalMiles() <= remainingMiles)
   {
    dests.add(d);
    remainingMiles -= d.getNormalMiles();
    
   }
  }
  return dests;
  
 }
 
 private ArrayList<Integer> upgradeClass(ArrayList<Destination> dest)
 {
  ArrayList<Integer> index = new ArrayList<Integer>();
  int counter = 0;
  for(Destination d: dest)
  {
   if(d.getAdditionalMiles() <= remainingMiles)
   {
    remainingMiles -= d.getAdditionalMiles();
    index.add(counter);
   }
   counter++;
    
  }
  return index;
  
 }
 public ArrayList<Destination> flightsInMonth(int m)
 {
  ArrayList<Destination> dests = new ArrayList<Destination>();
  for(Destination d: destinations)
  {
   if(d.getStartingMonth() <= m && d.getEndingMonth() >= m)
   {
    dests.add(d);
   }
  }
  return dests;
 }
 
 private ArrayList<Destination> applyFFM(ArrayList<Destination> destMonthFiltered)
 {
  ArrayList<Destination> dests = new ArrayList<Destination>();
  
  for(Destination d: destMonthFiltered)
  {
   if(remainingMiles >= d.getFlyerMiles() )
   {
    dests.add(d);
    remainingMiles -= d.getFlyerMiles();
   }
    
  }
  return dests;
  
 }
  public int getRemainingMiles( )
 {
  return remainingMiles;
 }
  
//MielageComparator class   
  public class MileageComparator implements Comparator<Destination>
 { 
  public int compare(Destination d1, Destination d2)
  { 
   return (d2.getNormalMiles() - d1.getNormalMiles()); 
  } 
 }
}


