// Assignment: 8
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is comparator class that compares reataraunt based on review
import java.util.Comparator;
public class ReviewRatingComparator implements Comparator<Restaurant>
 {
	//compare method that takes 2 objects of restaraunt type to compare 
	
    public int compare(Restaurant r1, Restaurant r2)
    {
    	// compare the based on number of stars 
    	int starsDiff = r1.getStars()-(r2.getStars()) ;
        if (r1.getStars()!=r2.getStars())
        {
            return starsDiff;
        }
        else if (starsDiff==0)
        {
        	// compare based onprice range 
        	int priceDiff= r1.getPriceRange()-(r2.getPriceRange());
        	if (r1.getPriceRange()!=r2.getPriceRange())
        	{
        		return priceDiff;
        	}
        	else if (priceDiff==0)
        	{
        		// comparing based on name 
        		int nameDiff= r1.getResrauntName().compareTo(r2.getResrauntName());
        		if (!r1.getResrauntName().equals(r2.getResrauntName()))
        		{
        			return nameDiff;
        		}
        		else if (nameDiff==0)
		           {//comparing based on location
		        	   int locDiff= r1.getLocation().compareTo(r2.getLocation());
		        	   if (!r1.getLocation().equals(r2.getLocation()))
		        	   {
		        		   return locDiff;
		        	   }
		        	   else if (locDiff==0)
		        	   {// comparing based on review 
		        		   int revDiff = r1.getReview().compareTo(r2.getReview());
		        		   if (!r1.getReview().equals(r2.getReview()))
		        		   {
		        			   return revDiff;  
		        		   }
		        		   else if (revDiff ==0 )
		        		   {
		        			   return 0;
		        		   }
		        	   }
		           }
		        }
        }
        return 0;
		       
		    }
		
		}
