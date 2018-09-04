package graph;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class GraphAPI {
	Vertex [] adjLists;
	Scanner sc = new Scanner(System.in);
	public void createVertices() {
		adjLists = new Vertex[10];
		adjLists[0] = new Vertex("A",null);
		adjLists[1] = new Vertex("B",null);
		adjLists[2] = new Vertex("C",null);
		adjLists[3] = new Vertex("D",null);
		adjLists[4] = new Vertex("E",null);
		adjLists[5] = new Vertex("F",null);
		adjLists[6] = new Vertex("G",null);
		adjLists[7] = new Vertex("H",null);
		adjLists[8] = new Vertex("I",null);
		adjLists[9] = new Vertex("J",null);
	}
	public void createEdgesUnDirected(String vertex1, String vertex2) {

			int v1 = indexForName(vertex1);
			int v2 = indexForName(vertex2);
		
			adjLists[v1].adjacencyList = new Neighbour(v2, adjLists[v1].adjacencyList);
			adjLists[v2].adjacencyList = new Neighbour(v1, adjLists[v2].adjacencyList);
	}
	
	public void createEdgesDirected(String vertex1, String vertex2) {

		int v1 = indexForName(vertex1);
		int v2 = indexForName(vertex2);
	
		adjLists[v1].adjacencyList = new Neighbour(v2, adjLists[v1].adjacencyList);
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
			for(Neighbour nbr=adjLists[v].adjacencyList; nbr != null; nbr= nbr.next ) {
				System.out.println("-->" +adjLists[nbr.vertexNumber].name );
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		GraphAPI g1 = new GraphAPI();
		g1.createVertices();
		g1.createEdgesUnDirected("A","B");
		g1.createEdgesUnDirected("A","C");
		g1.createEdgesUnDirected("A","D");
		g1.createEdgesUnDirected("B","C");
		g1.createEdgesUnDirected("D","E");
		g1.createEdgesUnDirected("E","F");
		g1.createEdgesUnDirected("E","G");
		g1.createEdgesUnDirected("E","I");
		g1.createEdgesUnDirected("E","H");
		g1.printGraph();
	}
}

