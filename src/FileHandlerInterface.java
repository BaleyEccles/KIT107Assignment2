/**
 * FileHandlerInterface.java
 * 
 * KIT107 Assignment 2 -- FileHandler Specification
 * 
 * @author Julian Dermoudy
 * @version	8/4/2025
 * 
 * FILE IS COMPLETE
 */


public interface FileHandlerInterface
{
    //public FileHandler(final String FILENAME);
    public void openFile();
    public void closeFile();
    public String readLine();
    public void readFile(Chocolatiers basket);
}