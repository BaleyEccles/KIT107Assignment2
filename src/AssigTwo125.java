/**
 * AssigTwo125.java
 * 
 * KIT107 Assignment 2 -- Harness Class
 * 
 * @author Julian Dermoudy
 * @version	9/4/2025
 * 
 * FILE IS COMPLETE
 */


public class AssigTwo125
{
	/**
	 * main() -- entry point
	 * 
	 * @param args String[] -- command line arguments
	 * 
	 * Precondition: None
	 * Postcondition: A dataset will have been read from a CSV file and stored,
	 * 					and the required reports will be shown.
	 * Informally: Read the datafile, store it, process it, and produce the
	 * 					results.
	 */
    public static void main(String []args)
    {
		final String FILENAME="data.csv";	// Filename of the file holding the dataset
		final int INVALID=-1;				// a sentinel value for "don't care"

		FileHandler myFile;					// object for A2-related file handling
		Chocolatiers basket;				// collection of data within the program


		// initialise collection and read in dataset
		basket=new Chocolatiers();
		myFile=new FileHandler(FILENAME);
		myFile.readFile(basket);

		//System.out.println(basket.toString());  // uncomment when debugging
		
		// generate the reports
		basket.showGraph('t', "total number", INVALID);
		basket.showGraph('v', "summed volume", INVALID);
		basket.showGraph('w', "summed weight", INVALID);
		basket.showGraph('c', "dark chocolate", Chocolate.DARK.ordinal());
		basket.showGraph('c', "milk chocolate", Chocolate.MILK.ordinal());
		basket.showGraph('c', "white chocolate", Chocolate.WHITE.ordinal());
		basket.showGraph('r', "stripy wrap", Wrapping.STRIPY.ordinal());
		basket.showGraph('r', "plain wrap", Wrapping.PLAIN.ordinal());
		basket.showGraph('r', "spotty wrap", Wrapping.SPOTTY.ordinal());
		basket.showGraph('f', "solid", Filling.SOLID.ordinal());
		basket.showGraph('f', "filled", Filling.FILLED.ordinal());
		basket.showGraph('f', "hollow", Filling.HOLLOW.ordinal());
    }
}