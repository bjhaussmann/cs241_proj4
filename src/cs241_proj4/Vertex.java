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
public class Vertex <T> implements VertexInterface<T> {
	
	private T label;
	private ListWithIteratorInterface<Edge> edgeList;
	private boolean visited;
	private VertexInterface<T> previousVertex;
	private double cost;
	
	public Vertex(T vertexLabel)
	{
		label = vertexLabel;
		edgeList = new LinkedListWithIterator<>();
		visited = false;
		previousVertex = null;
		cost = 0;
	}

	@Override
	public T getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unvisit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisited() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		boolean result = false;
		if (!this.equals(endVertex))
		{
			Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
			boolean duplicateEdge = false;
			while (!duplicateEdge && neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = neighbors.next();
				if (endVertex.equals(nextNeighbor))
					duplicateEdge = true;
				}
			if (!duplicateEdge)
			{
				edgeList.add(new Edge(endVertex, edgeWeight));
				result = true;
				}
			}
		return result; 
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex, 0);
	}

	@Override
	public Iterator<VertexInterface<T>> getNeighborIterator() {
		return new NeighborIterator();
	}

	@Override
	public Iterator<Double> getWeightIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNeighbor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VertexInterface<T> getPredecessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPredecessor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCost(double newCost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected class Edge
	{
		private VertexInterface<T> vertex;
		private double weight;
		protected Edge (VertexInterface<T> endVertex, double edgeWeight)
		{
			vertex = endVertex;
			weight = edgeWeight;
		}
		protected VertexInterface<T> getEndVertex()
		{
			return vertex;
		}
		protected double getWeight()
		{
			return weight;
		}
	}
	private class NeighborIterator implements Iterator<VertexInterface<T>>
	{
		private Iterator <Edge> edges;
		private NeighborIterator()
		{
			edges = edgeList.getIterator();
		}
		public boolean hasNext()
		{
			return edges.hasNext();
		}
		public VertexInterface<T> next()
		{
			VertexInterface<T> nextNeighbor = null;
			if(edges.hasNext())
			{
				Edge edgeToNextNeighbor = edges.next();
				nextNeighbor = edgeToNextNeighbor.getEndVertex();
			}
			else
				throw new NoSuchElementException();
			return nextNeighbor;
		}
	}
}
