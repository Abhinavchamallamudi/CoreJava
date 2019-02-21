import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.SwingUtilities.*;


class Sortingmain
{	
	//Two sort panel objects
	
	
	public static void framefunction()
	{
       JFrame f = new JFrame("Sorting");
		//Create a class object (window)
      	AlgorithmSorting sortA = new AlgorithmSorting();
      	AlgorithmSorting sortB = new AlgorithmSorting();

		Sortingmain sortframe  = new Sortingmain();
		
		//GUI Window Information
	
	   f.add(sortA);
   	f.add(sortB);

		//Create a class object (window)
		//Sortingmain sortframe  = new Sortingmain();
		
		//GUI Window Information
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100,600);
		f.setLayout(new GridLayout(2,2));
		f.setTitle("Sorting Animation");
		f.setVisible(true);
		f.setResizable(true);
		
	}
}

class programframe
{
	public static void main(String args[])
   {
   Sortingmain  s= new Sortingmain();
   s.framefunction();
   
   }
}		
		



