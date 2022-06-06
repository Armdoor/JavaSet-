// Assignment: 9
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is Assignment 9 is that implements 4 different recursive methods 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment9 {

    public static void main(String[] args) {
    
    	char choice = ' ';// variable for switch 
		 String line1;
		
		try {
			// for reading file 
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            do {
            	printMenu();
                line1=br.readLine().trim();                
                choice = line1.charAt(0);

                switch (choice) 
                {
                case '1':
                {
                	//calculates the largest number 
                	int[] val =parseInts(br);
                	System.out.println("The largest number in the array is: " + largest(val, 0, val.length -1));
                	break;}
                	
                case '2':
                {
                	// calculates the product of all prime numbers 
                	int[] val =parseInts(br);
                	System.out.println("The product of all prime numbers in the array is: "+ productOfPrime(val, val.length -1));
                	break;}

                case '3':
                {   
                	//calculates the largest sum of digits 
                	int[] val =parseInts(br);            
                	System.out.println("The largest sum of digits in the array is: " +largestSum(val,0,val.length-1));
                	break;}
                	
                case '4':
                {
                	// deletes the duplicates in the sentence
                	System.out.print("Please enter String:\n");           
                	String string = br.readLine();                   
                	System.out.println("String after adjacent duplicate characters were removed: "+ remDuplicate(string));
                	break;}
                	
                case '5': // Quit
                    break;
                	
                default:
                {// default case 
                	System.out.print("Please choose a number between 1 and 5.\n");
                    break;
                }
                }
            }
             while (choice!='5'|| line1.length()!=1);
            
		}
		catch(IOException exception) {
			System.out.println(exception);
		}
    }


    // Utility method for printing the menu 
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest number in an array of integers\n");
        System.out.print("2: Calculate the product of all prime numbers in an array of integers\n");
        System.out.print("3: Find the element with the largest sum of digits in an array of integers\n");
        System.out.print("4: Remove adjacent duplicate characters in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
         for(int i = 0; i < container.size(); i++){
             result[i] = container.get(i);
         }
        return result;
    }
    
    // method that calculates the largest number 
    public static int largest(int[] array,int start,int end) 
    {
    	// base case
    	if (end == start)
		{
			return array[end];
		}
		else
		{
			//call method recursively
			int larger = largest(array, start, end - 1);
			
			//if the last number is smaller than the current number, then return the current number as the largest
			if (larger < array[end])
			{
				return array[end];
			}
			//else if the last number was larger, return that instead
			else
			{
				return larger;
			}
		}
    }
    
    // utility method that checks if the number is prime or not 
    public static boolean isPrime(int num ) 
    { 
		if (num<=1)
		{
			return false;
		}
		else if (num==2)
			return true;
		else if (num%2==0)
			return false;
		for (int i=3;i<=Math.sqrt(num);i+=2)
		{
			if (num%i==0)
				return false;
		}
		return true;		
    } 
	
	// method that return tthe product of prime
	public static int productOfPrime(int[] array, int leng)
	{// base case 
		if(leng==1)
			return array[0];
		else 
		{
			if (isPrime(leng-1))
			{// recursive call 
				return array[leng-1]*productOfPrime(array,leng-1);
			}// recursive call
			return productOfPrime(array,leng-1);
		}				
	}
    
    
    
    // method that calculates the largest sum of digits 
    public static int largestSum(int[] array,int start,int end)
    {
    	
    	int digit = array[start];
    	//calls utility method 
    	array[start] = sumItUp(digit);
//base case 
    	if (start==end )
    		return largest(array , 0,end);
    	else
    	{
    		//r recursive method 
    	return largestSum(array,start+1,end);
    	}
    	
    }
 
    // utility method that returns the sum of a digit 
    public static int sumItUp(int digit)
    {
    	int sum=0;
    	if (digit==0)
    		return sum;
    	else 
    		return digit % 10 +sumItUp(digit/10);
    	
    }
    
    // method to delete the duplicates 
    public static String remDuplicate(String statement)
    {
    	// base case 
    	 if(statement.length()<=1)
    	 {	 
    		 return statement;
    	 }
	        if(statement.charAt(0)==statement.charAt(1))// compares the characters 
	        {
	        	return remDuplicate(statement.substring(1));// recursive call 
	        }
	        else// concatinates the string
	        {
	        	return statement.charAt(0) + remDuplicate(statement.substring(1));
	        }
    	 
		 
    }

}
        