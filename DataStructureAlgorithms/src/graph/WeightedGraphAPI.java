package graph;

import java.util.Scanner;

public class WeightedGraphAPI {
	VertexNew [] adjLists;
	Scanner sc = new Scanner(System.in);
	public void createVertices() {
		adjLists = new VertexNew[6];
		adjLists[0] = new VertexNew("A",null);
		adjLists[1] = new VertexNew("B",null);
		adjLists[2] = new VertexNew("C",null);
		adjLists[3] = new VertexNew("D",null);
		adjLists[4] = new VertexNew("E",null);
		adjLists[5] = new VertexNew("F",null);
	}
	public void createEdgesUnDirected(String source, String destination, int weight) {
		int v1 = indexForName(source);
		int v2 = indexForName(destination);

		adjLists[v1].adjacencyList = new NeighbourEdge(v2,weight, adjLists[v1].adjacencyList);
		adjLists[v2].adjacencyList = new NeighbourEdge(v1,weight, adjLists[v2].adjacencyList);
	}

	public void createEdgesDirected(String vertex1, String vertex2, int weight) {
		int v1 = indexForName(vertex1);
		int v2 = indexForName(vertex2);

		adjLists[v1].adjacencyList = new NeighbourEdge(v2,weight, adjLists[v1].adjacencyList);
	}

	int indexForName(String name) {
		for(int i=0 ; i<adjLists.length; i++) {
			if(adjLists[i].name.equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void printGraph() {
		System.out.println();
		for(int v=0; v<adjLists.length; v++) {
			System.out.println(adjLists[v].name);
			for(NeighbourEdge nbr=adjLists[v].adjacencyList; nbr != null; nbr= nbr.next ) {
				System.out.println("-->" +adjLists[nbr.vertexNumber].name + "with weight "+nbr.weight);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		WeightedGraphAPI g1 = new WeightedGraphAPI();
		g1.createVertices();
		g1.createEdgesDirected("A","B",5);
		g1.createEdgesDirected("A","C",15);
		g1.createEdgesDirected("B","D",20);
		g1.createEdgesDirected("C","D",10);
		g1.createEdgesDirected("D","E",3);
		g1.createEdgesDirected("E","F",4);
		g1.printGraph();
	}
}
