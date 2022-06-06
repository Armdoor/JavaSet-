// Assignment: 8
// Name:Akshit Sanoria
// StudentID:1220420435
// Lecture:T/TH 1:30 -2:45 pm 
// Description: This is the cuisine class that provides the information on cuisine name and returns a string type 

import java.io.Serializable;

public class Cuisine implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String signatureDish;
    private String name;

    public Cuisine(String signatureDish, String name) {
        this.name = name;
        this.signatureDish = signatureDish;
    }
//getter method for name of Cuisine 
    public String getName() {
        return name;
    }

    // to string method to print the Cuisine 
    public String toString() {
        return name + " Cuisine\n" +
                "Signature Dish:\t" + signatureDish + '\n';
    }
}
