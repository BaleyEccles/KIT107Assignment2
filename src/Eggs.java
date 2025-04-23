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

    private class DynamicArray {
        public DynamicArray()
        {
            // Set the size of the array to `INITIAL_SIZE`
            size = INITIAL_SIZE;

            // Allocate `size` amount of memory slots for data
            data = new Egg[size];

            // Set number of items in the array to zero (this is unnecessary, as java should initialise it to zero any way)
            count = 0;
        }
    
        public void add(Egg obj)
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

        public Egg get(int idx)
        {
            // Should do error checking for idx < count, but I wont misuse the my own data structure incorrectly :)
            // Returns the relevant data at the given index
            return data[idx];
        }

        private void increase(int newSize)
        {

            Egg[] dataNew = new Egg[newSize];
            for (int i = 0; i < size; i++)
            {
                dataNew[i] = data[i];
            }
            data = dataNew;
            size = newSize;
        }
    
        private Egg[] data; // Where the data is stored
        private int size; // The total amount of elements that could be stored in the arry before increasing in size
        public int count; // The current number of elements used in the array
    
        private final int INCREASE_RATIO = 2; // The amount at which we will increase the size of the array when full
        // I saw a video that the best ratio is acctually the golden ratio, but 2 is fine too. (https://www.youtube.com/watch?v=GZPqDvG615k)
    
        private final int INITIAL_SIZE = 256; // The size that the array will take when initalised.
        // 256 is feels like a good inital number. Power of 2 and not so small that we will need to increase the size of the array needlessly.
    
    }

    // final instance variables

    // other instance variables
    protected DynamicArray eggCluster;

    
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
        eggCluster = new DynamicArray();
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
        return (eggCluster.count == 0);
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
            return eggCluster.get(0).chocolatier;
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
        return eggCluster.get(0).volume;
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
        eggCluster.add(e);
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
        
        for(int i = 0; i < eggCluster.count; i++)
        {
            switch (t) {
            case 'c': {
                if (eggCluster.get(i).chocolate.ordinal() == v)
                {
                    total++;
                }
                break;
            }
            case 'f': {
                if (eggCluster.get(i).fill.ordinal() == v)
                {
                    total++;
                }
                break;
            }
            case 'r': {
                if (eggCluster.get(i).wrap.ordinal() == v)
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
                total += eggCluster.get(i).volume;
                break;
            }
            case 'w': {
                total += eggCluster.get(i).weight;
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
            for(int i = 0; i < eggCluster.count; i++)
            {
                output += eggCluster.get(i).toString();
                output += "\n";
            }
        }
        return output;
    }

}
