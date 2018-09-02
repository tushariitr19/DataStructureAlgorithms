package graph;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Graph {
	Vertex [] adjLists;
	Scanner sc = new Scanner(System.in);
	public void createVertices() {
		adjLists = new Vertex[10];
		adjLists[0] = new Vertex("Rama",null);
		adjLists[1] = new Vertex("Tushar",null);
		adjLists[2] = new Vertex("Hanuman",null);
		adjLists[3] = new Vertex("Radha",null);
		adjLists[4] = new Vertex("Krishna",null);
		adjLists[5] = new Vertex("Hari",null);
		adjLists[6] = new Vertex("Gopal",null);
		adjLists[7] = new Vertex("Happy",null);
		adjLists[8] = new Vertex("Moni",null);
		adjLists[9] = new Vertex("Charu",null);
	}
	public void createEdgesUnDirected() {
		int edges=0;
		for(int i =0; i<9; i++) {
			String vertex1, vertex2;
			System.out.println("Enter the name of First Vertex");
			vertex1 = sc.nextLine();
			System.out.println("Enter the name of Second Vertex");
			vertex2 = sc.nextLine();

			int v1 = indexForName(vertex1);
			int v2 = indexForName(vertex2);
			
			System.out.println("Vertex1 : "+vertex1 +" Index : "+v1);
			System.out.println("Vertex2 : "+vertex2 +" Index : "+v2);

			adjLists[v1].adjacencyList = new Neighbour(v2, adjLists[v1].adjacencyList);
			adjLists[v2].adjacencyList = new Neighbour(v1, adjLists[v2].adjacencyList);
		}
	}
	
	public void createEdgesDirected() {
		int edges=0;
		for(int i =0; i<9; i++) {
			String vertex1, vertex2;
			System.out.println("Enter the name of First Vertex");
			vertex1 = sc.nextLine();
			System.out.println("Enter the name of Second Vertex");
			vertex2 = sc.nextLine();

			int v1 = indexForName(vertex1);
			int v2 = indexForName(vertex2);
			
			System.out.println("Vertex1 : "+vertex1 +" Index : "+v1);
			System.out.println("Vertex2 : "+vertex2 +" Index : "+v2);

			adjLists[v1].adjacencyList = new Neighbour(v2, adjLists[v1].adjacencyList);
//			adjLists[v2].adjacencyList = new Neighbour(v1, adjLists[v2].adjacencyList);
		}
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
		Graph g1 = new Graph();
		g1.createVertices();
		g1.createEdgesDirected();
		g1.printGraph();
	}
}
