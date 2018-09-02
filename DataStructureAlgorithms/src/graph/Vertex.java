package graph;

public class Vertex {
	String name;
	Neighbour adjacencyList;
	Vertex(String name, Neighbour neighbour) {
		this.name = name;
		this.adjacencyList = neighbour;
	}
}
