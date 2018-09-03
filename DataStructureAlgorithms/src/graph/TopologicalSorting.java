package graph;

import java.util.Scanner;

public class TopologicalSorting {
	Vertex [] adjLists;
	Scanner sc = new Scanner(System.in);

	public void createVertices() {
		adjLists = new Vertex[6];
		adjLists[0] = new Vertex("A",null);
		adjLists[1] = new Vertex("B",null);
		adjLists[2] = new Vertex("C",null);
		adjLists[3] = new Vertex("D",null);
		adjLists[4] = new Vertex("E",null);
		adjLists[5] = new Vertex("F",null);
	}
	public void createEdgesDirected() {
		int edges=0;
		for(int i =0; i<6; i++) {
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
			//			System.out.println("\n");
		}
	}

	public int dfsTopologicalSorting(int v, boolean [] visited, int [] order, int n) {
		visited[v] = true;
		for(Neighbour nbr=adjLists[v].adjacencyList; nbr != null; nbr= nbr.next ) {
			if(!visited[nbr.vertexNumber]) {
				System.out.println(adjLists[v].name +"-->" +adjLists[nbr.vertexNumber].name );
				n = dfsTopologicalSorting(nbr.vertexNumber,visited,order,n);
				System.out.println("Value of n in DFS : "+n);
			}
		}
		//		System.out.println("Vertex : "+v);
		order[v] = n;
		System.out.println("Order of Vertex : "+v +" is : "+n );
		return (n-1);
	}

	public int [] dfs() {
		boolean [] visited = new boolean[adjLists.length];
		int [] order = new int[adjLists.length];
		int n = adjLists.length-1;
		for(int i =0; i< visited.length; i++) {
			if(!visited[i]) {
				System.out.println("Starting the Driver at : "+adjLists[i].name);
				n = dfsTopologicalSorting(i,visited,order,n);
				System.out.println("Value of n : "+n);
			}
		}
		return order;
	}

	public static void main(String[] args) {
		int [] order = new int[6];
		TopologicalSorting g1 = new TopologicalSorting();
		g1.createVertices();
		g1.createEdgesDirected();
		g1.printGraph();
		order = g1.dfs();
		for(int i : order)
			System.out.println(i);
	}
}
