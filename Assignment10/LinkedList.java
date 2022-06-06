// Assignment: 10
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is a linked list class that implements methods like removing, adding and printing a linked list 

public class LinkedList 
{
    Table first;
    int size;
    
    public LinkedList()
    {
        first = null;
        size = 0;
    }
    // add the guest to the wait list 
    public void add(int numberOfGuests, String name)
    {
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){// checks if the wait list is empty 
            first = newGuest;
        }
        else{
            Table pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }  

    // removes the first name from from the wait list 
    public Table removeFirst()
    {
    	Table table = first;
       if (first == null)// checks if the wait list is empty 
        {
         return new Table.EmptyTable();// returns an empty table 
        }
       else
        {
          first = first.next;  // removes the guest by overriding second with the first 
          size--;
          return table;
        }
       
    }

    // removes the last member of wait list 
    public Table removeLast() 
    {
    	Table temp= first;
    	while (temp.next==null)
    	{
    		temp=null;
    	}
		return temp;
	}
    
    // removes that guest with matching name
    public Table removeGuest(String guest) 
    {	
    	Table temp=first;
    	
    	if (first==null)
    	{
    		return new Table.EmptyTable();
    	}
    	else
    	{// is guest is number 1 in the list 
    		if (first.name.equals(guest))
    		{
    			Table hold=first;
    			first=first.next;
    			size--;
    			return hold;
    		}
	    	else 
			{
	    		 // if the guest is any other position other than number 1 
				Table current = temp.next;
				Table holdRef= first;
				while (current != null && !current.name.equals(guest))
				{
					temp = current;
					current = current.next;
				}
				if (current != null)
				{
					holdRef = current;
					temp.next = current.next; 
					size--;
					return holdRef;
				}// return -1 if the guest is not found 
				return new Table.EmptyTable();
			}
    		
    	}
    }    	
    // return the position of the guest 
    public int getPosition(String pos)
    {
    	Table temp = first;
    	int count =0;
    	while (temp!=null)
    	{
    		if (temp.name.equals(pos))// checks the name 
    			return count;
    		count++;// keeps counting 
    		temp=temp.next;  // moves to next  			
		} return -1;   // if not found then returns -1	
    }
    
    // returns the guest based on their number 
    public int getNumberOfParties(int i)
    {
    	int counter=0;
    	Table temp= first;
    	if (temp==null)// check if the list is empty 
    		return -1;
    	else 
    	{
    		while(temp!=null)
    		{
    			if (i== temp.guests) 
    			{
        			counter++;// counts the guest
    			}
    			
    			temp=temp.next;// moves to next guest
    		}
			return counter;
    	}
    }
    
    // prints the list 
    public String listReservations()
    {
    	Table temp=first;
    	String str =" ";
    	if (temp==null)// check if the list is empty 
    		return "No reservations in queue at this time. \n";
    	else {
    		while(temp!=null)
        	{
    			str += "\nReservation for "+ temp.name +": party of "+temp.guests+".\n";
    			temp= temp.next;
        	}
    		return str + "\nTotal reservations: "+ count()+".\n ";
    	}
    		
    }
    // helper method for counting the number guests in the wait list
    public int count()
    {
    	Table temp=first;
    	int counter=0;
    	if (temp==null)
    		return 0;
    	else
    	{
    		while (temp!=null)
    		{
    			counter+=1;
    			temp=temp.next;
    		}
    		return counter;
    	}
    }
    	
    }

