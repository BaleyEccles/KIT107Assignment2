/**
 * EggInterface.java
 * 
 * KIT107 Assignment 2 -- Egg Specification
 * 
 * @author Julian Dermoudy
 * @version	8/4/2025
 * 
 * FILE IS COMPLETE
 */


public interface EggInterface
{
    //public Egg(String n, double v, int w, Chocolate c, Wrapping r, Filling f);
    public String getChocolatier();
    public void setChocolatier(String n);
    public double getVolume();
    public void setVolume(double v);
    public int getWeight();
    public void setWeight(int w);
    public Chocolate getChoc();
    public void setChoc(Chocolate c);
    public Wrapping getWrapping();
    public void setWrapping(Wrapping w);
    public Filling getFilling();
    public void setFilling(Filling f);
    public String toString();
}