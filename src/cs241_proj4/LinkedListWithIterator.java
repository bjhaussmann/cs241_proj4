/**
 * 
 */
package cs241_proj4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ben
 *
 */
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>{

	private Node <T> firstNode;
	private int numberOfEntries;
	public LinkedListWithIterator()
	{
		initializeDataFields();
	}
	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorForLinkedList();;
	}

	@Override
	public Iterator<T> getIterator() {
		return iterator();
	}

	private class IteratorForLinkedList implements Iterator<T>
	{
		private Node <T> nextNode;
		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		}
	}
}
