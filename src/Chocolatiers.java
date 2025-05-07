/**
 * Chocolatiers.java
 * 
 * KIT107 Assignment 2 -- Chocolatiers Implementation
 * 
 * @author Baley Eccles - 652137
 * @version	<<date of completion>>
 */


import java.text.DecimalFormat;
import java.util.Arrays;

public class Chocolatiers implements ChocolatiersInterface
{

    
    private class DynamicArray {
        public DynamicArray()
        {
            // Set the size of the array to `INITIAL_SIZE`
            size = INITIAL_SIZE;

            // Allocate `size` amount of memory slots for data
            data = new Eggs[size];

            // Set number of items in the array to zero (this is unnecessary, as java should initialise it to zero any way)
            count = 0;
        }
    
        public void add(Eggs obj)
        {
            // Increase the size of the array if it is full
            if (count == size)
            {
                increase(size * INCREASE_RATIO);
            }

            // Put the object in the next avalible memory slot
            data[count] = obj;
            // Increase the count by one, so we know where to put the next object
            count++;

        }

        public Eggs get(int idx)
        {
            // Should do error checking for idx < count, but I wont misuse the my own data structure incorrectly :)
            // Returns the relevant data at the given index
            return data[idx];
        }

        private void increase(int newSize)
        {

            Eggs[] dataNew = new Eggs[newSize];
            for (int i = 0; i < size; i++)
            {
                dataNew[i] = data[i];
            }
            data = dataNew;
            size = newSize;
        }
    
        private Eggs[] data; // Where the data is stored
        private int size; // The total amount of elements that could be stored in the arry before increasing in size
        public int count; // The current number of elements used in the array
    
        private final int INCREASE_RATIO = 2; // The amount at which we will increase the size of the array when full
        // I saw a video that the best ratio is acctually the golden ratio, but 2 is fine too. (https://www.youtube.com/watch?v=GZPqDvG615k)
    
        private final int INITIAL_SIZE = 256; // The size that the array will take when initalised.
        // 256 is feels like a good inital number. Power of 2 and not so small that we will need to increase the size of the array needlessly.
    
    }

    // final instance variables
    
    // The chocolatiers that will be printed in the graph
    final String []CHOCOLATIERS =
    {
        "Lindt",
        "Cadbury",
        "Pink Lady",
        "Darrell Lea",
        "Kinder",
        "Ferrero",
        "Mars"
    };

    // The maximum of the CHOCOLATIERS string length. Will be used for formatting the graph.
    final int MAX_CHOCOLATIERS_STRING_LENGTH = 11;
    
    // other instance variables
    protected DynamicArray chocolatiersCollection;

	/**
	 * Constructor
	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its instance variable(s)
     *                  initialised with the relevant parameters.
	 * Informally: Initialise the collection of chocolatiers to be empty.
	 */
    public Chocolatiers()
    {
        chocolatiersCollection = new DynamicArray();
    }

	/**
	 * isEmpty()
	 * 
	 * @return boolean -- whether the collection is empty
	 * 
	 * Precondition: None
	 * Postcondition: True is returned if the collection is empty; false is
     *                  returned otherwise.
	 * Informally: Check whether the collection is empty.
	 */
    public boolean isEmpty()
    {
        return (chocolatiersCollection.count == 0);
    }

    /**
	 * findChocolatier()
	 * 
	 * @param c String -- the chocolatier to search for
     * 
	 * @return int -- the index of the chocolatier in the chocolatier list, or -1 if the
     *                the chocolatier is unknown
	 * 
	 * Precondition: None
	 * Postcondition: The index of the given chocolatier is returned if it is present
     *                  in the list of chocolatiers; -1 is returned otherwise.
	 * Informally: Check whether the chocolatier is a 'preferred' chocolatier.
	 */
    public int findChocolatier(String c)
    {
        int index = -1; // The index that will be returned. Initally -1, as that will be reutrned if nothing is found.

        // iterate through each set of eggs and compare the input string to the chocolatier of that collection
        for (int i = 0; i < chocolatiersCollection.count; i++)
        {
            if (chocolatiersCollection.get(i).getChocolatier().equals(c))
            {
                index = i;
            }
        }
        
        return index;
    }

    /**
	 * addEggToChocolatiers()
	 * 
	 * @param e Egg -- the egg to add to this collection
	 * 
	 * Precondition: The given egg parameter has been constructed
	 * Postcondition: The given egg has been added to the collection and, in
     *                  particular to the cluster of eggs from the same chocolatier, 
     *                  and within the cluster, ordered by ascending value of volume.
	 * Informally: Add an egg to the appropriate cluster of eggs in the
     *                  collection based on chocolatier.
	 */
    public void addEggToChocolatiers(Egg e)
    {
        int index = findChocolatier(e.chocolatier); // The index at which the collection for the eggs chocolatier occurs

        // If the chocolatier does not have a collection yet, we make one
        if (index == -1) 
        {
            Eggs eggs = new Eggs();
            eggs.addEggToEggs(e);
            chocolatiersCollection.add(eggs);
        } else
        {
            // add the egg to the collection, if it exists
            chocolatiersCollection.get(index).addEggToEggs(e);
        }
    }

    /**
	 * showGraph()
	 * 
	 * @param t char -- the request type ('c', 'f', 'r', 't', 'v', or 'w')
	 * @param d String -- a request description
	 * @param v int -- the ordinal position of the value in the relevant enumeration,
     *                  or, when the request type is 't', 'v', or 'w', -1
	 * 
	 * Precondition: The request type (t) is valid and the ordinal position (v) is valid
	 * Postcondition: The appropriate histogram has been shown according to the request
     *                  type and ordinal position
	 * Informally: Produce the requested histogram and total.
	 */
    public void showGraph(char t, String d, int v)
    {
        double[] data = new double[chocolatiersCollection.count]; // An array that contains all the data for the specific request
        int[] starCounts = new int[chocolatiersCollection.count]; // An array that stores the number of stars that will be used in the bar graph
        int invalidEggs = 0; // Number of eggs that dont have a chocolatier that we care about
        String dataString; // String which will contain the the data in string form instead of double, and formatted to either 0 or 3 numbers after decimal place

        for (int i = 0; i < chocolatiersCollection.count; i++)
        {
            // Process the catagroy, from the users input
            data[i] = chocolatiersCollection.get(i).processCategory(t, v);
            
            // Get the number of stars for the bar graph
            starCounts[i] = (int)(data[i]/25.0);
        }


        // Print the headder for the graph
        System.out.println("Easter eggs -- " + d);

        for (int i = 0; i < chocolatiersCollection.count; i++)
        {
            // Only print bar if the chocolatier one of the ones that we care about
            if (isValidChocolatier(chocolatiersCollection.get(i).getChocolatier()))
            {

                if (t == 'v')
                {
                    // If we are processing the volume catagory
                    // Format the dataString to contain 3 numbers after the decimal place
                    dataString = String.format("%.3f", data[i]);
                } else
                {
                    // Else, we will print the data as an integer. There will be no decimal places
                    dataString = String.format("%.0f", data[i]);
                }

                // Number of spaces that will go before the name in the graph
                final String leftPad =  " ".repeat(MAX_CHOCOLATIERS_STRING_LENGTH - chocolatiersCollection.get(i).getChocolatier().length());
                // Number of spaces that will go after the stars in the graph
                final String starPad =  " ".repeat(maxElement(starCounts) + 4 - starCounts[i]);


                if (t == 't' || t == 'f' || t == 'r' || t == 'c')
                {
                    // Only print stars if we are dealing with a catagory that needs stars
                    
                    // Stars to be printed
                    final String stars = "*".repeat(starCounts[i]);

                    // Bar to be printed
                    final String bar = leftPad + chocolatiersCollection.get(i).getChocolatier() + " | " + stars + starPad + dataString;

                    // print the bar with stars
                    System.out.println(bar);
                } else if (t == 'w' || t == 'v') 
                {
                    // Print graph without stars

                    // Bar to be printed
                    final String bar = leftPad + chocolatiersCollection.get(i).getChocolatier() + " | " + "    " + dataString;

                    // print the bar without stars
                    System.out.println(bar);
                }
            } else
            {
                // Increase the number of invalid eggs, by the number of eggs in the collection
                invalidEggs += chocolatiersCollection.get(i).processCategory('t', -1);
            }
        }

        // Print the number of invalid eggs
        System.out.println("Invalid eggs: " + invalidEggs);

        // Print the most common egg for some description
        printMostCommon(data, d);
    }

    private void printMostCommon(double[] data, String d)
    {
        double dataMax = 0.0; // Max number in data
        int maxIndex = -1; //Where the max occurs

        // Find the max elemnt in the data array
        for (int j = 0; j < data.length; j++)
        {
            if (data[j] > dataMax && isValidChocolatier(chocolatiersCollection.get(j).getChocolatier()))
            {
                dataMax = data[j];
                maxIndex = j;
            }
        }

        System.out.println("And the most common chocolatier for " + d + " eggs is......" + chocolatiersCollection.get(maxIndex).getChocolatier() + "!");

    }

    // Check if a chocolatier is one that we care about
    private boolean isValidChocolatier(String chocolatierName)
    {
        boolean isValid = false; // Assume that the input chocolatier is invalid 
        for (int i = 0; i < CHOCOLATIERS.length; i++)
        {
            if (CHOCOLATIERS[i].equals(chocolatierName))
            {
                isValid = true;
            }
        }
        return isValid;
    }

    // Gets the max element of an array of ints
    private int maxElement(int[] array)
    {
        int max = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (max < array[i])
            {
                max = array[i];
            }
        }
        return max;
    }
    
    /**
	 * toString()
	 * 
	 * @return String -- printable form of the collection of chocolatiers
     *  
	 * Precondition: None
	 * Postcondition: A printable (String) form of the collection of chocolatier data
     *                  is returned, separated by a blank line.  If there are no eggs
     *                  then "" is returned.
	 * Informally: Convert the collection of chocolatier data to a multi-line String.
	 */
    public String toString()
    {
        String output = ""; 
        if (!isEmpty()) {
            for (int i = 0; i < chocolatiersCollection.count; i++) {
                output += chocolatiersCollection.get(i).toString();
                output += "\n";
            }
        }
        return output;
    }
}
