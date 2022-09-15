// Assignment: 8
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is comparator class that compares reataraunt based on cuisine
import java.util.Comparator;

public class ReviewCuisineComparator implements Comparator<Restaurant>
{
	public int compare(Restaurant first, Restaurant second) 
	{// comparing cuisines based on name 
		int nameCom= first.getCuisisne().getName().compareTo(second.getCuisisne().getName());
    	if ( nameCom>0)
    	{
    		return 1;
    	}
    	else if (nameCom<0)
    	{
    		return -1;
    	}
    	else if (nameCom==0)
    	{// comparing based on price range 
    		int priceCom = (first.getPriceRange()-second.getPriceRange());
    		if (priceCom>0)
    		{
    			return 1;
    		}
    		else if (priceCom<0)
    			return -1;
    		else if (priceCom==0)
    		{// comparing based of restarunt name 
    			int nameDiff= first.getResrauntName().compareTo(second.getResrauntName());
        		if (nameDiff>0)
        		{
        			return 1;
        		}
		           else if (nameDiff<0)
		           {
		        	   return -1;
		           }
		           else if (nameDiff==0)
		           {// comparing based on location 
		        	   int locDiff= first.getLocation().compareTo(second.getLocation());
		        	   if (locDiff>0 )
		        	   {
		        		   return 1;
		        	   }
		        	   else if (locDiff <0)
		        	   {
		        		   return -1;
		        	   }
		        	   else if (locDiff==0)
		        	   {// comparing based on review 
		        		   int revDiff = first.getReview().compareTo(second.getReview());
		        		   if (revDiff>0)
		        		   {
		        			   return 1;
		        			  
		        		   }
		        		   else if (revDiff <0 )
		        		   {
		        			   return -1;
		        		   }
		        		   else if (revDiff ==0 )
		        		   {
		        			   return 0;
		        		   }
    		}
    	}
	}

    	}return 0;}}

//2 before 1 gives positivee
