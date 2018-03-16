/**
 * 
 */
package cs241_proj4;

import java.util.EmptyStackException;

/**
 * @author bjhau
 *
 */
public class LinkedQueue<T> implements QueueInterface<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	}
	@Override
	public void enqueue(T newEntry) {
		Node <T> newNode = new Node<T>(newEntry, null);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}
	
	@Override
	public T dequeue() {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if(firstNode == null)
			lastNode = null;
		return front;
	}
	
	@Override
	public T getFront() {
		if(isEmpty())
		throw new EmptyStackException();
		else
			return (T) firstNode.getData();
	}
	
	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}
	
	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
