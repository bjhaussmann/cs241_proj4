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
	private LinkedListWithIterator<Edge> edgeList;
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
		return label;
	}

	@Override
	public void visit() {
		visited = true;
	}

	@Override
	public void unvisit() {
		visited = false;
	}

	@Override
	public boolean isVisited() {
		return visited;
	}
	
	@Override
	public boolean equals (Object other)
	{
		boolean result;
		if((other == null) || (getClass() != other.getClass()))
			result = false;
		else
		{
			@SuppressWarnings("unchecked")
			Vertex<T> otherVertex = (Vertex<T>) other;
			result = label.equals(otherVertex.label);
		}
		return result;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean disconnect (VertexInterface<T> endVertex)
	{
		boolean result = false;
		//requires a cast to compile. Won't let me cast. Should work otherwise.
		edgeList.remove((Vertex<T>.Edge) endVertex.getLabel());
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
		return new getWeightIterator();
	}

	@Override
	public boolean hasNeighbor() {
		return !edgeList.isEmpty();
	}

	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {
		VertexInterface <T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		while (neighbors.hasNext() && (result == null))
		{
			VertexInterface<T> nextNeighbor = neighbors.next();
			if( !nextNeighbor.isVisited())
				result = nextNeighbor;
		}
		return result;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		previousVertex = predecessor;
		
	}

	@Override
	public VertexInterface<T> getPredecessor() {
		return previousVertex;
	}

	@Override
	public boolean hasPredecessor() {
		return (previousVertex != null);
	}

	@Override
	public void setCost(double newCost) {
		cost = newCost;
	}

	@Override
	public double getCost() {
		return cost;
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
	
	private class getWeightIterator implements Iterator<Double>
	{
		private Iterator <Edge> edges;
		private getWeightIterator()
		{
			edges = edgeList.getIterator();
		}
		public boolean hasNext()
		{
			return edges.hasNext();
		}
		public Double next()
		{
			Double edgeWeight = new Double(0);
			if(edges.hasNext()) {
				Edge edgeToNextNeighbor = edges.next();
				edgeWeight = edgeToNextNeighbor.getWeight();
			}
			else 
				throw new NoSuchElementException();
			return edgeWeight;
		}
	}
}
