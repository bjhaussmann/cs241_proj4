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
	private void initializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}
	@Override
	public void add(T newEntry) {
		Node<T> newNode = new Node <T> (newEntry);
		if(isEmpty())
			firstNode = newNode;
		else
		{
			Node<T> lastNode = getNodeAt (numberOfEntries);
			lastNode.setNextNode(newNode);
		}
		numberOfEntries ++;
	}
	
	public int getNodePosition(VertexInterface<T> node)
	{
		int position = 0;
		Node<T> newNode = firstNode;
		while (newNode != node)
		{
			newNode = newNode.getNextNode();
			position++;
		}
		
		return position;
	}

	private Node<T> getNodeAt(int numberOfEntries) {
		Node<T> newNode = firstNode;
		for (int i = 1; i < numberOfEntries; i++)
			newNode = newNode.getNextNode();
		return newNode;
	}
	@Override
	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			Node <T> newNode = new Node<T>(newEntry);
			if (newPosition == 1)
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				Node <T> nodeBefore = getNodeAt(newPosition-1);
				Node <T> nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to add operation."); 
	}

	@Override
	public T remove(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{      
			assert !isEmpty();
			if (givenPosition == 1)
			{
				result = firstNode.getData();         
				firstNode = firstNode.getNextNode();
			}
			else
			{
				Node <T> nodeBefore = getNodeAt(givenPosition-1);
				Node <T> nodeToRemove = nodeBefore.getNextNode();
				result = nodeToRemove.getData();
				Node<T> nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
			}
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	@Override
	public void clear() {
		initializeDataFields();
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			Node <T> desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;   
		}   
		else      
			throw new IndexOutOfBoundsException("Illegal position given to replace operation."); 
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation."); 
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		Node <T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{      
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found; 
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null);
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorForLinkedList();
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
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}
		@Override
		public T next() {
		if (hasNext())
		{
			Node <T> returnNode = nextNode;
			nextNode = nextNode.getNextNode();
			return returnNode.getData();
		}
		else
			throw new NoSuchElementException("Illegal call to next(); iterator is after end of list."); 
		}
	}
}
