/**
 * Eggs.java
 * 
 * KIT107 Assignment 2 -- Eggs Implementation
 * 
 * @author Baley Eccles - 652137
 * @version	<<date of completion>>
 */


public class Eggs implements EggsInterface
{
    // final instance variables

    // other instance variables
    protected Egg[] eggCluster;
    
	/**
	 * Constructor
	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its instance variable(s)
     *                  initialised with the relevant parameters.
	 * Informally: Initialise the cluster of eggs to be empty.
	 */
    public Eggs()
    {
        eggCluster = new Egg[0];
    }

	/**
	 * isEmpty()
	 * 
	 * @return boolean -- whether the cluster is empty
	 * 
	 * Precondition: None
	 * Postcondition: True is returned if the cluster of eggs is empty; false is
     *                  returned otherwise.
	 * Informally: Check whether the cluster is empty.
	 */
    public boolean isEmpty()
    {
        return (eggCluster.length == 0);
    }

    /**
	 * getChocolatier()
	 * 
	 * @return String -- the name of the chocolatier for all eggs in this cluster
     *                  or "" if the cluster is empty
	 * 
	 * Precondition: None
	 * Postcondition: the chocolatier of the first egg in the cluster -- or "" if
     *                  it is empty -- is returned.
	 * Informally: Get the name of the chocolatier for the current cluster of eggs.
	 */
    public String getChocolatier()
    {
        if (isEmpty())
        {
            return "";
        }
        else
        {
            //System.out.println(eggCluster[0].chocolatier);
            return eggCluster[0].chocolatier;
        }
        
    }

    /**
	 * getVolume()
	 * 
	 * @return double -- the volume of the first egg for this cluster or 0.0 if the
     *                      cluster is empty
	 * 
	 * Precondition: None
	 * Postcondition: the volume of the first egg in the cluster -- or 0.0 if it is
     *                  empty -- is returned.
	 * Informally: Get the volume of the first egg in the current cluster.
	 */
    public double getVolume()
    {
        return eggCluster[0].volume;
    }

    /**
	 * addEggToEggs()
	 * 
	 * @param e Egg -- the egg to add to this cluster
	 * 
	 * Precondition: The given egg parameter has been properly constructed
	 * Postcondition: The given egg has been added to the cluster of
     *                  eggs preserving the order by increasing volume.
	 * Informally: Add an egg to a cluser of eggs in order of egg volume.
	 */
    public void addEggToEggs(Egg e)
    {
        Egg[] eggClusterNew = new Egg[eggCluster.length + 1];
        for (int i = 0; i < eggCluster.length; i++)
        {
            eggClusterNew[i] = eggCluster[i];
        }
        eggClusterNew[eggClusterNew.length - 1] = e;
        eggCluster = eggClusterNew;
    }

    /**
	 * processCategory()
	 * 
	 * @param t char -- the request type ('c', 'f', 'r', 't', 'v', or 'w') 
	 * @param v int -- the ordinal position of the value in the relevant enumeration,
     *                  or, when the request type is 't', 'v', or 'w', -1
     * 
     * @return double -- the relevant calculated total
	 * 
	 * Precondition: The request type (t) is valid and the ordinal position (v) is valid
	 * Postcondition: The cluster has been traversed and the accumulated total returned.
	 * Informally: Count/sum the requested attribute of each egg in the cluster.
	 */
    public double processCategory(char t, int v)
    {
        double total = 0.0;
        
        for(int i = 0; i < eggCluster.length; i++)
        {
            switch (t) {
            case 'c': {
                if (eggCluster[i].chocolate.ordinal() == v)
                {
                    total++;
                }
                break;
            }
            case 'f': {
                if (eggCluster[i].fill.ordinal() == v)
                {
                    total++;
                }
                break;
            }
            case 'r': {
                if (eggCluster[i].wrap.ordinal() == v)
                {
                    total++;
                }
                break;
            }
            case 't': {
                total++;
                break;
            }
            case 'v': {
                total += eggCluster[i].volume;
                break;
            }
            case 'w': {
                total += eggCluster[i].weight;
                break;
            }
            }
        }
        return total;
    }

	/**
	 * toString()
	 * 
	 * @return String -- printable form of the cluster of eggs
	 * 
	 * Precondition: None
	 * Postcondition: A printable (String) form of the egg data is returned, one
     *                  egg per line.  If the cluster of eggs is empty then "" is 
     *                  returned.
	 * Informally: Convert the cluster of eggs to a multi-line String.
	 */
    public String toString()
    {
        String output = "";
        if (!isEmpty())
        {
            for(int i = 0; i < eggCluster.length; i++)
            {
                output += eggCluster[i].toString();
                output += "\n";
            }
        }
        return output;
    }

}
