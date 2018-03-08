/**
 * 
 */
package cs241_proj4;

/**
 * @author Ben
 *
 */
public class Node<T> {

	private T data;
	private Node <T> next;
	
	public Node (T dataPortion)
	{
		this(dataPortion, null);
	}
	
	public Node (T dataPortion, Node <T> nextNode)
	{
		data=dataPortion;
		next=nextNode;
	}
}
