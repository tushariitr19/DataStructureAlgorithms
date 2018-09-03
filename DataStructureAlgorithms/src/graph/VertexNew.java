package graph;

public class VertexNew {
	String name;
	NeighbourEdge adjacencyList;
	VertexNew(String name, NeighbourEdge neighbour) {
		this.name = name;
		this.adjacencyList = neighbour;
	}
}