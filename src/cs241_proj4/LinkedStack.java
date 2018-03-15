/**
 * 
 */
package cs241_proj4;

import java.util.EmptyStackException;

/**
 * @author Ben
 *
 */
public final class LinkedStack<T> implements StackInterface<T> {

	private Node<T> topNode;
	
	public LinkedStack() {
		topNode = null;
	}
	
	/* (non-Javadoc)
	 * @see cs241_proj4.StackInterface#push(java.lang.Object)
	 */
	@Override
	public void push(T newEntry) {
		topNode = new Node<T>(newEntry, topNode);
	}

	/* (non-Javadoc)
	 * @see cs241_proj4.StackInterface#pop()
	 */
	@Override
	public T pop() {
		T top = peek();
		
		assert topNode != null;
		
		topNode = topNode.getNextNode();
		return top;
	}

	/* (non-Javadoc)
	 * @see cs241_proj4.StackInterface#peek()
	 */
	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	}

	/* (non-Javadoc)
	 * @see cs241_proj4.StackInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	/* (non-Javadoc)
	 * @see cs241_proj4.StackInterface#clear()
	 */
	@Override
	public void clear() {
		topNode = null;
		}

}
