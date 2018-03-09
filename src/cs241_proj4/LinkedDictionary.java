/**
 * 
 */
package cs241_proj4;

import java.util.Iterator;

/**
 * @author Ben
 *
 */
public class LinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private Node firstNode;
	private int numberOfEntries;
	private int counter;

	public LinkedDictionary() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public V add(K key, V value) {
		V result = null;

		Node currentNode = firstNode;
		Node nodeBefore = null;

		while ((currentNode != null) && key.compareTo(currentNode.getKey()) > 0) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}

		if ((currentNode != null) && key.equals(currentNode.getKey())) {
			result = currentNode.getValue();
			currentNode.setValue(value);
		} else {
			Node newNode = new Node(key, value);
			if (nodeBefore == null) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else {
				newNode.setNextNode(currentNode);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		counter ++;
		return result;
	}

	public V remove(K key) {
		V result = null;
		Node currentNode = firstNode;
		Node nodeBefore = null;

		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			return null;
		} else {
			result = currentNode.getValue();
			nodeBefore.setNextNode(currentNode.getNextNode());
			currentNode.setKey(null);
			currentNode.setValue(null);
			currentNode.setNextNode(null);
			counter--;
		}
		return result;
	}

	public V getValue(K key) {
		Node currentNode = firstNode;

		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			return null;
		} else {
			return currentNode.getValue();
		}
	}

	public boolean contains(K key) {
		Node currentNode = firstNode;

		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			return false;
		} else {
			return true;
		}
	}

	public Iterator<K> getKeyIterator() {
		Iterator <K> keyIt = new Iterator <K>()
				{
					private Node currentKNode = firstNode;
					@Override
					public boolean hasNext() {
						if (currentKNode.getNextNode() != null)
						{
							return true;
						}
						else
						{
							return false;
						}
					}

					@Override
					public K next() {
						return currentKNode.getNextNode().getKey();
					}
				};
		return keyIt;
	}

	public Iterator<V> getValueIterator() {
		Iterator <V> valueIt = new Iterator <V>()
				{
					private Node currentVNode = new Node();
					
					public boolean hasNext() {
						if (currentVNode.getNextNode() != null)
						{
							return true;
						}
						else
						{
							return false;
						}
					}

					public V next() {
						return currentVNode.getNextNode().getValue();
					}
			
				};
		return valueIt;
	}

	public boolean isEmpty() {
		if (firstNode.getNextNode() == null) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return counter;
	}

	public void clear() {
		Node currentNode = firstNode.getNextNode();
		Node beforeNode = firstNode;

		while (currentNode != null) {
			beforeNode.setNextNode(null);
			currentNode.setKey(null);
			currentNode.setValue(null);
			beforeNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		counter = 0;
	}
	public class Node {

		private K key;
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		private V value;
		private Node nextNode;
		
		public Node ()
		{
			this(null, null);
		}
		public Node (K key, V value)
		{
			this(key, value, null);
		}
		
		public Node (K key, V value, Node nextNode)
		{
			this.key=key;
			this.value = value;
			this.nextNode=nextNode;
		}
	}
}
