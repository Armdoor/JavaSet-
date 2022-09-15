import java.io.Serializable;

public class Restaurant implements Serializable {

	private static final long serialVersionUID = 205L;
	private String restrauntName, review, location ;
	private int stars, priceRange ;
	private Cuisine cuisine;

public Restaurant (String restName, int stars ,String review, String location, int priceRange, Cuisine cus)
{
	this.restrauntName= restName;
	this.stars= stars;
	this.review= review;
	this.location= location;
	this.priceRange= priceRange;
	this.cuisine= cus;
	
}
// Restaurant name getter method 
public String getResrauntName()
{
	return restrauntName; 
}
//Restaurant stars getter method 
public int getStars()
{
	return stars;
}
//Restaurant price range getter method 
public int getPriceRange()
{
	return priceRange;
}
//Restaurant location getter method 
public String getLocation()
{
	return location;
}
//Restaurant review getter method 
public String getReview()
{
	return review;
}
//Restaurant cuisine getter method 
public Cuisine getCuisisne()
{
	return cuisine; 
}
//toString method to print info about the Restaurant 
public String toString()
{
	//loop for counting the number of stars 
	String staring="", pricetring="";
	for (int i =0 ; i< getStars();i++)
	{
		staring+="*";
	}
	//loop for counting the number of dollars  
	for (int k =0 ; k< getPriceRange();k++)
	{
		pricetring+="$";
	}
	String tost = restrauntName + " restaurant\n"  +  staring + "\t\t" + pricetring + "\n" +  cuisine.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
	return tost;
}
}
