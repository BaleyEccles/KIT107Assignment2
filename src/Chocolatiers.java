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
    // final instance variables
    final String []CHOCOLATIERS = { "Lindt", "Cadbury",
                                    "Pink Lady", "Darrell Lea", "Kinder", "Ferrero",
                                    "Mars" };
    // other instance variables

    
    protected Eggs[] chocolatiersCollection;

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
        chocolatiersCollection = new Eggs[0];
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
        return (chocolatiersCollection.length == 0);
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
        for (int i = 0; i < chocolatiersCollection.length; i++)
        {
            if (chocolatiersCollection[i].getChocolatier().equals(c))
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
            
            Eggs[] chocolatiersCollectionNew = new Eggs[chocolatiersCollection.length + 1];
            for (int i = 0; i < chocolatiersCollection.length; i++)
            {
                chocolatiersCollectionNew[i] = chocolatiersCollection[i];
            }
            chocolatiersCollectionNew[chocolatiersCollectionNew.length - 1] = eggs;
            chocolatiersCollection = chocolatiersCollectionNew;
        } else
        {
            chocolatiersCollection[index].addEggToEggs(e);
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
        double[] data = new double[chocolatiersCollection.length];

        for (int i = 0; i < chocolatiersCollection.length; i++)
        {
            data[i] = chocolatiersCollection[i].processCategory(t, v);
        }


        System.out.println("Easter eggs -- " + d);
        switch (t){
        case 't':
        case 'f':
        case 'r':
        case 'c': { // Do bar graph
            for (int i = 0; i < chocolatiersCollection.length; i++)
            {
                if (isValidChocolatier(chocolatiersCollection[i].getChocolatier()))
                {
                    final int starCount = (int)(data[i]/25.0);
                    
                    final String stars = "*".repeat(starCount);
                    final String dataString = Double.toString(data[i]);
                    final String leftPad =  " ".repeat(11 - chocolatiersCollection[i].getChocolatier().length());
                    final String bar = leftPad + chocolatiersCollection[i].getChocolatier() + " | " + stars + "\t\t" + dataString;
                    System.out.println(bar);
                }
            }

            // TODO: Invalid Eggs
            break;
        }
        case 'w':
        case 'v': { // Only display numbers
            for (int i = 0; i < chocolatiersCollection.length; i++)
            {
                if (isValidChocolatier(chocolatiersCollection[i].getChocolatier()))
                {
                    final String dataString = Double.toString(data[i]);
                    final String leftPad =  " ".repeat(11 - chocolatiersCollection[i].getChocolatier().length());
                    final String bar = leftPad + chocolatiersCollection[i].getChocolatier() + " | " + "\t\t" + dataString;
                    System.out.println(bar);
                }
            }
            break;
        }
        }

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
