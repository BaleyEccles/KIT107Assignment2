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

    // other instance variables


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
COMPLETE ME!
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
COMPLETE ME!
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
COMPLETE ME!
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
COMPLETE ME!
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
COMPLETE ME!
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
COMPLETE ME!
    }
}
