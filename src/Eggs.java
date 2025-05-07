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
    
    // other instance variables
    protected Node eggCluster;
    protected int eggCount;

    
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
        eggCluster = new Node(null);
        eggCount = 0;
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
        return (eggCount == 0);
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
            return ((Egg)eggCluster.getData()).getChocolatier();
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
        if (isEmpty())
        {
            return 0.0;
        }
        else
        {
            return ((Egg)eggCluster.getData()).getVolume();
        }
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
        boolean hasAddedToCluster = false; // Boolean that indicates if the egg has been added yet
        Node currentEggNode = eggCluster; // The node in the linked list that is currently being checked. eggCluster is the first egg in the linked list
        Node previousEggNode = null; // The previous node that was checked
        Node newEggNode = new Node(null); // The node that will be placed in the linked list
        
        while (!hasAddedToCluster)
        {
            // Case 1: There are no nodes in the linked list
            if (eggCount == 0)
            {
                // add e to the egg cluster
                eggCluster.setData(e); 

                // Break from while loop
                hasAddedToCluster = true;
                // increment eggCount
                eggCount++;
            }
            // Case 2: We have reached the end of the linked list
            else if (currentEggNode.getNext() == null)
            {
                // Add e to a node at the end of the linked list
                newEggNode.setData(e);
                // Set the, now second last, node to point to the now last node
                currentEggNode.setNext(newEggNode);
                
                // Break from while loop
                hasAddedToCluster = true;
                // increment eggCount
                eggCount++;
            }
            // Case 3: The egg to be added has a volume less than the current node we are looking at
            else if (e.getVolume() < ((Egg)currentEggNode.getData()).getVolume())
            {
                // Add some e to a node inbetween two nodes
                newEggNode.setData(e);
                // Set the node containing e to point to the current node
                newEggNode.setNext(currentEggNode);

                // Only set the previous node to point to the new node if it exists
                // This handles the case when we need to add an egg to the front of the linked list
                if (previousEggNode != null)
                {
                    previousEggNode.setNext(newEggNode);
                }
                // set the eggCluster to point to the new node
                // This ensures that eggCluster is the first node in the list
                if (previousEggNode == null)
                {
                    eggCluster = newEggNode;
                }

                // Break from while loop
                hasAddedToCluster = true;
                // increment eggCount
                eggCount++;
            }
            // Case 4: We need to check the next node
            else
            {
                // Set the previous node to the current node
                previousEggNode = currentEggNode;
                // Set the current node to the next node in the list
                currentEggNode = currentEggNode.getNext();
            }
        }
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
        double total = 0.0; // The number to be returned, indicating the total sum/count of the requested catagory
        Node eggNode = eggCluster; // Used to itterate through the linked list, eggCluster points at the first element
        
        for (int i = 0; i < eggCount; i++) 
        {
            switch (t) {
            case 'c':
                { // Case: count chocolate corresponding to ordinal v
                    if (((Egg)eggNode.getData()).chocolate.ordinal() == v)
                    {
                        total++;
                    }
                    break;
                }
            case 'f':
                { // Case: count fill corresponding to ordinal v
                    if (((Egg)eggNode.getData()).fill.ordinal() == v)
                    {
                        total++;
                    }
                    break;
                }
            case 'r':
                { // Case: count fill corresponding to ordinal v
                    if (((Egg)eggNode.getData()).wrap.ordinal() == v)
                    {
                        total++;
                    }
                    break;
                }
            case 't':
                { // Case: count total number of eggs
                    total++;
                    break;
                }
            case 'v':
                { // Case: sum volume
                    total += ((Egg)eggNode.getData()).getVolume();
                    break;
                }
            case 'w':
                { // Case: sum weight
                    total += ((Egg)eggNode.getData()).getWeight();
                    break;
                }
            }
            // Go to next node in linked list
            eggNode = eggNode.getNext();
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
        String output = ""; // The string to be modified and returned
        Node eggNode = null; // Node that will be used for itteration
        // Verify that the list isn't empty
        if (!isEmpty()) 
        {
            eggNode = eggCluster; // Set eggNode to the first node
            for (int i = 0; i < eggCount; i++)
            {
                // append the string to output
                output += ((Egg)eggCluster.getData()).toString();
                // Add newline after each egg, as requried
                output += "\n";

                // Set the node to the next node in the linked list
                eggNode = eggNode.getNext();
            }
        }
        return output;
    }

}
