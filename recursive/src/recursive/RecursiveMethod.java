package recursive;

import javax.swing.JOptionPane;

public class RecursiveMethod 
{
	private static String number;
	private static int num;
	private static int counter = 0, count = -1; 
	private static String word; 
	private static int b = 0; 
	private static String ancestors; 
	private static int ancest = 0; 
	private static int countAncestors = 0;
	private static int total = 0;
	private static int starter = 1;
	
	public static void main(String[] args)
	{
		//get user input for recursion method and error check their entries 
		while(true)
		{
			boolean yes = true;
			try
			{
				number = JOptionPane.showInputDialog(null, "Enter a number!"); 
				num = Integer.parseInt(number);
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "That's not a number, silly.");
				yes = false; 
			}
			if(yes == true)
			{
				break; 
			}
		}
		
		while(num>0)
		{
			numbers();
		}
		
		System.out.println("It took so long to get there: " + counter);
		System.out.println("Final number is: " + num);
		JOptionPane.showMessageDialog(null, "We divided your number " + 
		counter + " time(s) before we got to the number " + num + "."); 
		
		//begin string recursion 
		word = JOptionPane.showInputDialog(null, "Enter a random word!");
		char[] nuggets = word.toCharArray();
		words(nuggets); 
		
		//begin ancestoral count 
		while(true)
		{
			boolean yest = true; 
			try
			{
				ancestors = JOptionPane.showInputDialog("Please enter the amount of generations that you would like to go back: ");		
				ancest = Integer.parseInt(ancestors); 

			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "That's not a number, goofy.");
				yest = false; 
			}
			if(yest == true)
			{
				break;
			}
		}
		int ancestors = ancestorCount(ancest);
		System.out.println("Total number of ancestors " + ancest + " generations back is " + ancestors);
		{
			
		}
	}
	
	private static int ancestorCount(int ancest)
	{
		
		if(countAncestors == ancest)
		{
			return total;
		}
		total = (starter * 2);
		//System.out.println(total);
		starter = total;
		//System.out.println(starter);
		countAncestors = countAncestors+1;
		return(ancestorCount(ancest)); 
	}
	
	private static char[] words(char[] worddap)
	{
		if(count == worddap.length)
		{
			return worddap; 
		}
		count = count + 1; 
		try
		{
			System.out.println(worddap[count]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return worddap; 
		}
		return words(worddap);	
	}
	
	private static int numbers()
	{
		counter = counter + 1; 
		num = num/2; 
		//System.out.println("Number " + num);
		//System.out.println("Counter " + counter);
		return(num); 
	}
}
