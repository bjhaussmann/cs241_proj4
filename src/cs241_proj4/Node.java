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
	private Node <T> nextNode;
	
	public Node ()
	{
		this(null);
	}
	public Node (T dataPortion)
	{
		this(dataPortion, null);
	}
	
	public Node (T dataPortion, Node <T> nextNode)
	{
		data=dataPortion;
		this.nextNode=nextNode;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNextNode(Node<T> next) {
		this.nextNode = next;
	}
}
