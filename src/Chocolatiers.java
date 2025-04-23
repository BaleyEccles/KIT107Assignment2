/**
 * Chocolatiers.java
 * 
 * KIT107 Assignment 2 -- Chocolatiers Implementation
 * 
 * @author Baley Eccles - 652137
 * @version	<<date of completion>>
 */


import java.text.DecimalFormat;

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
        int index = -1;
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
        int index = findChocolatier(e.chocolatier);
        
        if (index == -1)
        {
            Eggs eggs = new Eggs();
            eggs.addEggToEggs(e);
            
            chocolatiersCollection.add(eggs);
        } else
        {
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
        double[] data = new double[chocolatiersCollection.count];

        for (int i = 0; i < chocolatiersCollection.count; i++)
        {
            data[i] = chocolatiersCollection.get(i).processCategory(t, v);
        }


        System.out.println("Easter eggs -- " + d);
       
        int invalidEggs = 0;
        for (int i = 0; i < chocolatiersCollection.count; i++)
        {
            if (isValidChocolatier(chocolatiersCollection.get(i).getChocolatier()))
            {
                final int starCount = (int)(data[i]/25.0);

                if (t == 't' || t == 'f' || t == 'r' || t == 'c')
                {
                    final String stars = "*".repeat(starCount);
                    final String dataString = Double.toString(data[i]);
                    final String leftPad =  " ".repeat(11 - chocolatiersCollection.get(i).getChocolatier().length());
                    final String bar = leftPad + chocolatiersCollection.get(i).getChocolatier() + " | " + stars + "\t\t" + dataString;
                    System.out.println(bar);
                } else if (t == 'w' || t == 'v')
                {
                    final String dataString = Double.toString(data[i]);
                    final String leftPad =  " ".repeat(11 - chocolatiersCollection.get(i).getChocolatier().length());
                    final String bar = leftPad + chocolatiersCollection.get(i).getChocolatier() + " | " + "\t\t" + dataString;
                    System.out.println(bar);
                }

                        
            } else
            {
                invalidEggs += chocolatiersCollection.get(i).processCategory('t', -1);
            }
        }
            
        System.out.println("Invalid eggs: " + invalidEggs);

        double dataMax = 0.0;
        int maxIndex = -1;
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

    
    private boolean isValidChocolatier(String chocolatierName)
    {
        boolean isValid = false;
        for (int i = 0; i < CHOCOLATIERS.length; i++)
        {
            if (CHOCOLATIERS[i].equals(chocolatierName))
            {
                isValid = true;
            }
        }
        return isValid;
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
        return "";
    }
}
