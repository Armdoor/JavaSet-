// Assignment: 8
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is class sorts the arraylist based on review or cuisine 
import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
	
	public static void sort(ArrayList<Restaurant> reviewList, Comparator<Restaurant> xComparator) {

		int index=0 ;
		// checks the size of arraylist 
		if (reviewList.size() == 1)
			return;
		for (int i = 0; i < reviewList.size()-1; i++) 
		{
			for (int j = i+1; j < reviewList.size(); j++) {
				if (xComparator.compare(reviewList.get(i),reviewList.get(j)) > 0) {
					index=i;
				}
			}// swaps the list based on the user input of cuisine or rating
					Restaurant temp = reviewList.get(index);
					reviewList.set(index, reviewList.get(index));
					reviewList.set(index, temp);
			
			
		}
	}
}