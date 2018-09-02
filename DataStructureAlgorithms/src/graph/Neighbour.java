package graph;

public class Neighbour {
	int vertexNumber;
	Neighbour next;
	public Neighbour(int vertexNumber, Neighbour nbr) {
		this.vertexNumber = vertexNumber;
		next = nbr;
	}
}
