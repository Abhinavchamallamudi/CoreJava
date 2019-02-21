import javax.swing.*;
import java.awt.*;
import java.awt.Graphics.*;
import javax.swing.event.*;
import javax.swing.SwingUtilities.*;
import java.lang.Runnable;
import java.util.Random;
import java.lang.Object;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;

class AlgorithmSorting extends JPanel
{	
	//Sort animation panel
	private animatedalgorithm amimationPanel = new animatedalgorithm();
	boolean s= false;
	//Array full button
	private JButton PopulateArrray = new JButton("Populate Array");
	Thread t1;
	//Sort button
	private JButton ButtonSort = new JButton("Sort");
	
	//Stop button to stop sorting entirely
	private JButton ButtonStop = new JButton("Stop");
	
	//Array for the sort types
	private String[] sortMethods = { "Selection", "Quick", "Bubble", "Cocktail", "Shell", "Insertion", "Gnome", "Cycle"};
	
	//Combo box to list sort types
	private JComboBox sortTypes = new JComboBox<>(sortMethods);
	
	//Array for the sort types
	private String[] startsorting = { "Random", "Ascending", "Descending"};
	
	//Combo box to list sort types
	private JComboBox startsortingcombo = new JComboBox<>(startsorting);
	
	//Integer array to be sorted
	private int[] Arrayforsorting = new int[525];
	
	//Speed integer
	int speed = 500; 
	
	//Array for the sortingspeed
	private String[] sortingspeedort = { "100", "1000", "5000"};
	
	//Combo box to list various sortingspeed
	private JComboBox sortingspeed = new JComboBox<>(sortingspeedort);
   		final animatedalgorithm topPanel = new animatedalgorithm();

	
	public AlgorithmSorting()
	{
		this.add(topPanel);
		
		//Create a panel to hold the controls
		JPanel mainpanel = new JPanel();
		
		//Set the control panel layout to centred flow layout
		mainpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Add the controls to the control panel
		mainpanel.add(new JLabel("Initial: "));
		mainpanel.add(startsortingcombo);
		mainpanel.add(PopulateArrray);
		mainpanel.add(ButtonSort);
		mainpanel.add(sortTypes);
		mainpanel.add(sortingspeed);
      mainpanel.add(ButtonStop);
		
		//Disable the sort button and stop button
		ButtonSort.setEnabled(false);
		//ButtonStop.setEnabled(false);
		
		//Add the control panel to the sort panel
		this.add(mainpanel);
      
		mainpanel.setVisible(true);
		
		//When the populate array button is pressed fill it with random numbers and display it. 
		//Also enable the sort button and disable the populate button
		PopulateArrray.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
            {     populateArray();

				
				String sortselection = startsortingcombo.getSelectedItem().toString();
				
				//Show the array in the selected ordering*/
				if(sortselection.equals("Ascending"))
				{
					Arrays.sort(Arrayforsorting);
					repaint();
				}

				if(sortselection.equals("Descending"))
				{
					
               decendingsorting();  
						repaint();
				}
				
				if(sortselection.equals("Random"))
				{
					repaint();
				}
				
				
				//Disable populate button and enable sort button
				ButtonSort.setEnabled(true);
				PopulateArrray.setEnabled(false);
			}
		});
		
		//When the sort button is pressed call the appropriate sort method
		ButtonSort.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent f)
            {
				
				 t1 = new Thread(topPanel);
				t1.start();
				
			}
		});
		
		//When the stop button is pressed stop the sorting
		ButtonStop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent f)
            {
            if(s==false)
            {
            s=true;
            t1.suspend();
            ButtonSort.setEnabled(true);
           
            }
            
			}
		});
	}
	
		
		private class animatedalgorithm extends JPanel implements Runnable 
	{
		public int number;
		public int[] numbers;
		/***************************************************************
		Method: Run

		Use:  Call the sort methods to run the animation. 

		Arguments: String

		Returns: N/A
		***************************************************************/
		public void run()
		{
			//Get the values of sort type and speed
			String sortselection = sortTypes.getSelectedItem().toString();
			String SortSpeed = sortingspeed.getSelectedItem().toString();
		
			ButtonSort.setEnabled(false);
			
			if(SortSpeed.equals("Slow"))
			{
				speed = 5000;
			}
			
			if(SortSpeed.equals("Medium"))
			{
				speed = 1000;
			}
			
			if(SortSpeed.equals("Fast"))
			{
				speed = 100;
			}
			
			//Run the selected sort algorithm
			if(sortselection.equals("Selection"))
			{
				selectionSort(Arrayforsorting);
			}
			
			if(sortselection.equals("Quick"))
			{
				quickSort(Arrayforsorting, 0, Arrayforsorting.length - 1);
				PopulateArrray.setEnabled(true);
			}
			
			
			if(sortselection.equals("Bubble"))
			{
				bubbleSort(Arrayforsorting);
			}
			
			
			if(sortselection.equals("Insertion"))
			{
				insertionSort(Arrayforsorting);
			}
			
				}
		
		public animatedalgorithm()
		{
			//set the size of the animation window
			this.setPreferredSize(new Dimension(530, 525));
			
			//set the background to white
			this.setBackground(new Color(255,255,255));
			
		}
		
		//Paint method to draw the lines
		public void paintComponent( Graphics g )
		{	
			if(Arrayforsorting[0] !=0)
			{
				
				for(int i=0; i<Arrayforsorting.length; i++)
				{
					g.drawLine(i,530,i,530-Arrayforsorting[i]);
					g.setColor(Color.RED); 
				}
			}
		}	
	
	}
	
	/***************************************************************
	Method: SelectionSort
	
	Use:  Sort the array of integers using selection sort and display the lines after every swap
	
	Arguments: Array
	
	Returns: N/A
	***************************************************************/
	public void selectionSort(int[] ArrayInteger) 
	{
		try
		{
		
			for (int i=0; i<ArrayInteger.length-1; i++) 
			{
				for (int j=i+1; j<ArrayInteger.length; j++) 
				{
					if (ArrayInteger[i] > ArrayInteger[j]) 
					{
						int temp = ArrayInteger[i];
						ArrayInteger[i] = ArrayInteger[j];
						ArrayInteger[j] = temp;
						
						//Redraw the lines after swapping elements
						repaint();
					}
				}
				Thread.sleep(speed);
			}
			
			//Re-Enable array button
			PopulateArrray.setEnabled(true);
		}
		
		catch (InterruptedException e) 
		{
			e.printStackTrace();
    
		}
	}
	
	/***************************************************************
	Method: quickSort, swap
	
	Use:  Sort the array of integers using quickSort and call swap to swap the elements
	
	Arguments: Array, array start, array end
	
	Returns: N/A
	***************************************************************/
	public void quickSort(int ArrayInteger[], int start, int end)
	{
		int i = start;                          
		int k = end;                            
	
		try
		{
			if (end - start >= 1)               
			{
				int pivot = ArrayInteger[start];       
			
				while (k > i)                   
				{
					while (ArrayInteger[i] <= pivot && i <= end && k > i)  
					{
						i++;                                    
					}
					
					while (ArrayInteger[k] > pivot && k >= start && k >= i) 
					{	
						k--;                                        
					}
					if (k > i) 
					{
						int temp = ArrayInteger[i];           
						ArrayInteger[i] = ArrayInteger[k];      
						ArrayInteger[k] = temp; 
						repaint();
					}
				}
				
				int temp1 = ArrayInteger[start];           
				ArrayInteger[start] = ArrayInteger[k];      
				ArrayInteger[k] = temp1; 
				repaint();

				quickSort(ArrayInteger, start, k - 1);
				Thread.sleep(speed);

				quickSort(ArrayInteger, k + 1, end);   
			}
			else 
			{
				return;
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
    
		}
	}
	
	/***************************************************************
	Method: bubbleSort
	
	Use:  Sort the array of integers using bubbleSort. Redraw the lines after every swap
	
	Arguments: Array
	
	Returns: N/A
	***************************************************************/
	public void bubbleSort(int[] ArrayInteger) 
	{
		
		try
		{
			int n = ArrayInteger.length;
			int temp = 0;
		
			for(int i=0; i < n; i++)
			{
                for(int j=1; j < (n-i); j++)
				{           
                    if(ArrayInteger[j-1] > ArrayInteger[j])
					{
						//swap the elements!
						temp = ArrayInteger[j-1];
						ArrayInteger[j-1] = ArrayInteger[j];
						ArrayInteger[j] = temp;
						repaint();
                    }          
                }
				Thread.sleep(speed);
            }

			//Re-Enable array button
			PopulateArrray.setEnabled(true);
		}
		
		catch (InterruptedException e) 
		{
			e.printStackTrace();
    
		}
		PopulateArrray.setEnabled(true);
    }
	
		public void insertionSort(int[] ArrayInteger) 
	{	
		try
		{
			for (int i = 1; i < ArrayInteger.length; i++) 
			{	
				int j = i;
				int temp = ArrayInteger[i];
				
				while ((j > 0) && (ArrayInteger[j-1] > temp)) {
					
					ArrayInteger[j] = ArrayInteger[j-1];
					j--;
					repaint();
				}
				
				ArrayInteger[j] = temp;
				repaint();
				Thread.sleep(speed);
			}
			
			//Re-Enable array button
			PopulateArrray.setEnabled(true);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
    
		}
	}

		public void cocktailSort( int[] ArrayInteger )
	{
		try
		{
			boolean swapped;
			do 
			{
				swapped = false;
				
				for (int i =0; i<=  ArrayInteger.length  - 2;i++) 
				{
					if (ArrayInteger[ i ] > ArrayInteger[ i + 1 ]) 
					{
						int temp = ArrayInteger[i];
						ArrayInteger[i] = ArrayInteger[i+1];
						ArrayInteger[i+1]=temp;
						swapped = true;
						repaint();
					}
				}
				if (!swapped) 
				{
					break;
				}
				
				swapped = false;
				Thread.sleep(speed);
				for (int i= ArrayInteger.length - 2;i>=0;i--) 
				{
					if (ArrayInteger[ i ] > ArrayInteger[ i + 1 ]) 
					{
						int temp = ArrayInteger[i];
						ArrayInteger[i] = ArrayInteger[i+1];
						ArrayInteger[i+1]=temp;
						swapped = true;
						repaint();
					}
				}
			} while (swapped);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();    
		}
		//Re-Enable array button
		PopulateArrray.setEnabled(true);
	}
	

	 
    public void  populateArray()
    {
    
    Random rand = new Random();
				for(int i=0; i< Arrayforsorting.length; i++)
				{
					//Generate a random integer and add it to the array
					Arrayforsorting[i] = rand.nextInt((530 - 1) + 1) + 1;
				}
				
}
    
public void decendingsorting()
{

	



	int temp;
					int start = 0;
					int end = Arrayforsorting.length-1;
					
					//Sort the array in ascending order
					Arrays.sort(Arrayforsorting);
					
					//Reverse the array so it is not in descending order
					while(start < end)
					{
						temp = Arrayforsorting[start];  
						Arrayforsorting[start] = Arrayforsorting[end];
						Arrayforsorting[end] = temp;
						start++;
						end--;
					}   
	}
   
   public void thrednew()
   {
   t1 = new Thread(topPanel);
				t1.start();
		
   }
   
   
   }		