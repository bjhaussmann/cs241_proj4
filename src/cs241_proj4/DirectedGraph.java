/**
 * 
 */
package cs241_proj4;

/**
 * @author Ben
 *
 */
public class DirectedGraph<T> implements GraphInterface<T> {

	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	public DirectedGraph()
	{
		vertices = new LinkedDictionary<>();
		edgeCount = 0;
	}

	@Override
	public boolean addVertex(T vertexLabel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(T begin, T end, double edgeWeight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(T begin, T end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QueueInterface<T> getBreadthFirstTraversal(T origin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueInterface<T> getDepthFirstTraversal(T origin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StackInterface<T> getTopologicalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getShortestPath(T begin, T end, StackInterface<T> path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCheapestPath(T begin, T end, StackInterface<T> path) {
		// TODO Auto-generated method stub
		return 0;
	}
}
