/**
 * 
 */
package cs241_proj4;

/**
 * @author Ben
 *
 */
public interface QueueInterface<T> {

	public void enqueue (T newEntry);
	public T dequeue();
	public T getFront();
	public boolean isEmpty();
	public void clear();
	
}
