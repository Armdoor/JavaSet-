// Assignment: 8
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is managing class that implements bunch of methods like searching restaurant , cuisine, adding review sorting etc. 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Restaurant> reviewList;
// constructor method 
    public ReviewManager() 
    {
        reviewList = new ArrayList<>();
    }

    // this method checks of the restaraunt exists based on a particular name 
    public int restaurantExists(String resName, String resLocation)
    {
        int search =-1;
        for (int i =0;i<reviewList.size();i++)
        {// comparing restaraunt name 
        	if ( reviewList.get(i).getResrauntName().equals(resName))
            {// comparing restaraunt location
        		if ( reviewList.get(i).getLocation().equals(resLocation))
        		{//retuns index 
                return i;
        		}
        		}
        }
        return search;
    }
 // comparing a cuisine 
    public ArrayList<Integer> cuisineExists(String cuisine1)
    {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>(); 
    	for (int i=0;i<reviewList.size();i++)
    	{
    		if (cuisine1.equals(reviewList.get(i).getCuisisne().getName()))
    				{
    			list.add(reviewList.indexOf(reviewList.get(i)));
    			//return list ;
    				}
  
    	} return list;
    }
// getter method for restaraunt 
    public Restaurant getRestaurant(int res)
    {
    	Restaurant r1 =reviewList.get(res);
        return r1;
    }

    // method to add review for a restaurant
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, location, price, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }
//  method to remove a review from a restaraunt 
    public boolean removeReview(String resName, String resLocation )
    {
        boolean check= false;
        for (int i =0;i<reviewList.size();i++)
        {// checks if the restaurant even exists 
        	if (resName.equals(reviewList.get(i).getResrauntName()))
            {// now checks the location 
        		if (resLocation.equals(reviewList.get(i).getLocation().toString()))
        		{// removes the review from arraylist
        			reviewList.remove(i);
        			check = true;
        		}
                
            }
        }
        return check;

    }

    public void sortByRating()
    {// sorts based on review
    	ReviewRatingComparator rev = new ReviewRatingComparator();
    	Sorts.sort(reviewList, (Comparator<Restaurant>)rev);

    }

    public void sortByCuisine()
    {// sorts based on cuisine 
    	Sorts.sort(reviewList, new ReviewCuisineComparator());
    }

    public String listReviews()
    {//lists all the reviews 
        String list="";
        for (int i =0;i<reviewList.size();i++)
        {
            list+= reviewList.get(i);
        }
        return list;
    }

    public void closeReviewManager()
    {
    	reviewList.clear();
    }
    
    

}
