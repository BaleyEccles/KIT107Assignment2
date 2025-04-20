/**
 * Egg.java
 * 
 * KIT107 Assignment 2 -- Egg Implementation
 * 
 * @author Julian Dermoudy
 * @version	8/4/2025
 * 
 * FILE IS COMPLETE
 */


import java.text.DecimalFormat;


public class Egg implements EggInterface
{
    protected String chocolatier;   // egg's producer
    protected double volume;        // egg's volume
    protected int weight;      		// egg's weight
    protected Chocolate chocolate;	// egg's chocolate type
    protected Wrapping wrap;        // egg's wrapping
    protected Filling fill;      	// egg's filling

	/**
	 * Constructor
	 * 
	 * @param n String -- egg's producer (chocolatier)
     * @param v double -- egg's volume
     * @param w int -- egg's weight
     * @param c Chocolate -- type of chocolate used
     * @param r Wrapping -- type of wrapping used
     * @param f Filling -- type of fill
   	 * 
	 * Precondition: None
	 * Postcondition: The new instance will have its instance variables
     *                  initialised with the relevant parameters.
	 * Informally: Initialise an egg object.
	 */
    public Egg(String n, double v, int w, Chocolate c, Wrapping r, Filling f)
    {
        chocolatier=n;
        volume=v;
        weight=w;
        chocolate=c;
        wrap=r;
        fill=f;
    }

    /**
	 * getChocolatier()
	 * 
	 * @return String -- the value in the chocolatier field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's chocolatier field is returned.
	 * Informally: Get the chocolatier field.
	 */
    public String getChocolatier()
    {
        return chocolatier;
    }

	/**
	 * setChocolatier()
	 * 
	 * @param n String -- String to be stored in chocolatier field of egg
	 * 
	 * Precondition: None
	 * Postcondition: the current object's chocolatier field is assigned the given
	 * 					value.
	 * Informally: Set the chocolatier field.
	 */
    public void setChocolatier(String n)
    {
        chocolatier=n;
    }

    /**
	 * getVolume()
	 * 
	 * @return double -- the value in the volume field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's volume field is returned.
	 * Informally: Get the volume field.
	 */
    public double getVolume()
    {
        return volume;
    }

	/**
	 * setVolume()
	 * 
	 * @param v double -- double to be stored in volume field of egg
	 * 
	 * Precondition: None
	 * Postcondition: the current object's volume field is assigned the given value.
	 * Informally: Set the volume field.
	 */
    public void setVolume(double v)
    {
        volume=v;
    }

    /**
	 * getWeight()
	 * 
	 * @return int -- the value in the weight field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's weight field is returned.
	 * Informally: Get the weight field.
	 */
    public int getWeight()
    {
        return weight;
    }

	/**
	 * setWeight()
	 * 
	 * @param w int -- int to be stored in weight field of egg
	 * 
	 * Precondition: None
	 * Postcondition: the current object's weight field is assigned the given value.
	 * Informally: Set the weight field.
	 */
    public void setWeight(int w)
    {
        weight=w;
    }

    /**
	 * getChoc()
	 * 
	 * @return Chocolate -- the value in the chocolate field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's chocolate field is returned.
	 * Informally: Get the chocolate field.
	 */
    public Chocolate getChoc()
    {
        return chocolate;
    }

	/**
	 * setChoc()
	 * 
	 * @param c Chocolate -- Chocolate to be stored in chocolate field of egg
	 * 
	 * Precondition: None
	 * Postcondition: the current object's chocolate field is assigned the given
	 * 					value.
	 * Informally: Set the chocolate field.
	 */
    public void setChoc(Chocolate c)
    {
        chocolate=c;
    }

    /**
	 * getWrapping()
	 * 
	 * @return Wrapping -- the value in the wrap field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's wrap field is returned.
	 * Informally: Get the wrap field.
	 */
    public Wrapping getWrapping()
    {
        return wrap;
    }

	/**
	 * setWrapping()
	 * 
	 * @param r Wrapping -- Wrapping to be stored in wrap field of egg
	 * 
	 * Precondition: None
	 * Postcondition: the current object's wrap field is assigned the given value.
	 * Informally: Set the wrap field.
	 */
    public void setWrapping(Wrapping r)
    {
        wrap=r;
    }

    /**
	 * getFilling()
	 * 
	 * @return Filling -- the value in the fill field
	 * 
	 * Precondition: None
	 * Postcondition: the current object's fill field is returned.
	 * Informally: Get the fill field.
	 */
    public Filling getFilling()
    {
        return fill;
    }

	/**
	 * setFilling()
	 * 
	 * @param f Filling -- Filling to be stored in fill field of egg
	 * 
	 * Precondition: None
	 * Postcondition: the current object's fill field is assigned the given value.
	 * Informally: Set the fill field.
	 */
    public void setFilling(Filling f)
    {
        fill=f;
    }

    
	/**
	 * toString()
	 * 
	 * @return String -- printable form of the egg's data
	 * 
	 * Precondition: None
	 * Postcondition: A printable (String) form of the egg's data is returned.  E.g.
	 * 					"a 10g filled white chocolate Lindt egg of volume 5.056cm3 with a plain wrapping"
	 * Informally: Convert an egg's data to a String.
	 */
    public String toString()
    {
		final DecimalFormat FMT=new DecimalFormat("#####.000");
		final String []FILLINGS = {"solid", "filled", "hollow"};
		final String []WRAPPINGS = {"stripy", "spotty", "plain"};
		final String []CHOCOLATES = {"dark", "milk", "white"};

		String f;
		String r;
		String c;

		f=FILLINGS[fill.ordinal()];
		r=WRAPPINGS[wrap.ordinal()];
		c=CHOCOLATES[chocolate.ordinal()];

        return "a " + weight + "g " + f + " " + c + " chocolate " + chocolatier + " egg of volume " + FMT.format(volume) + "cm3 with a " + r + " wrapping";
    }
}