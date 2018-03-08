/**
 * 
 */
package cs241_proj4;

import java.util.Iterator;

/**
 * @author Ben
 *
 */
public interface ListWithIteratorInterface <T> extends ListInterface<T>, Iterable<T> {

	public Iterator<T> getIterator();
}
