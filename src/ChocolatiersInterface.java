/**
 * ChocolatiersInterface.java
 * 
 * KIT107 Assignment 2 -- Chocolatiers Specification
 * 
 * @author Julian Dermoudy
 * @version	8/4/2025
 * 
 * FILE IS COMPLETE
 */


public interface ChocolatiersInterface
{
    //public Chocolatiers();
    public boolean isEmpty();
    public int findChocolatier(String c);
    public void addEggToChocolatiers(Egg e);
    public void showGraph(char t, String c, int v);
    public String toString();
 }