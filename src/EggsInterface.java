/**
 * EggsInterface.java
 * 
 * KIT107 Assignment 2 -- Eggs Specification
 * 
 * @author Julian Dermoudy
 * @version	8/4/2025
 * 
 * FILE IS COMPLETE
 */


public interface EggsInterface
{
    //public Eggs();
    public boolean isEmpty();
    public String getChocolatier();
    public double getVolume();
    public void addEggToEggs(Egg e);
    public double processCategory(char t, int v);
    public String toString();
}