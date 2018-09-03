package graph;

public class NeighbourEdge {
	int vertexNumber;
	int weight;
	NeighbourEdge next;
	public NeighbourEdge(int vertexNumber, int weight, NeighbourEdge nbr) {
		this.vertexNumber = vertexNumber;
		this.weight = weight;
		next = nbr;
	}
}

