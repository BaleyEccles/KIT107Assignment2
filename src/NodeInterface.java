/**
 * NodeInterface.java
 * 
 * KIT107 Assignment 2 -- Linked List Node Specification
 * 
 * @author Julian Dermoudy
 * @version	8/4/2025
 * 
 * FILE IS COMPLETE
 */


public interface NodeInterface
{
	//public Node(Object o);
	public void setData(Object o);
	public void setNext(Node n);
	public Object getData();
	public Node getNext();
}
