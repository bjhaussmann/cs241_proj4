/**
 * 
 */
package cs241_proj4;

/**
 * @author Ben
 *
 */
public interface StackInterface<T> {

	public void push(T newEntry);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public void clear();
}
