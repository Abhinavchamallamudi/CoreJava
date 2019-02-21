/*CSCI 502          Assignment 4          Fall 2018   *
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
 * is the destination class which can take the        *
 * input from the file and encapusulates the          *
 * variable values using the setters and getters      *
 *                                                    *
 *****************************************************/
  
// Creating the destination class    
public class Destination {

//Variable declaration  
 private String destinationName;
 private int normalMiles;
 private int flyerMiles;
 private int additionalMiles;
 private int startingMonth;
 private int endingMonth;
 
//Constructor
public Destination(String name, int normal, int flyer, int add, int start, int end)
 {
  destinationName = name;
  normalMiles = normal;
  flyerMiles = flyer;
  additionalMiles = add;
  startingMonth = start;
  endingMonth = end;
 }
   
//Using the public access methods (Set Get) to obtain the variable values 
 public void setName(String name) {
  destinationName = name;
 }
 public void setNormalMiles(int nMiles) {
  normalMiles = nMiles;
 }
 public void setFlyerMiles(int fMiles) {
  flyerMiles = fMiles;
 }
 public void setAdditionalMiles(int addMiles) {
  additionalMiles = addMiles;
 }
 public void setStartingMonth(int start) {
  startingMonth = start;
 }
 public void setEndingMonth(int end) {
  endingMonth = end;
 }
 public String getName() {
  return destinationName;
 }
 public int getNormalMiles() {
  return normalMiles;
 }
 public int getFlyerMiles() {
  return flyerMiles;
 }
 public int getAdditionalMiles() {
  return additionalMiles;
 }
 public int getStartingMonth() {
  return startingMonth;
 }
 public int getEndingMonth() {
  return endingMonth;
 }
}
