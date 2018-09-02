package graph;

import java.util.Scanner;

public class DFS {
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

		public void dfs(int v, boolean [] visited) {
			visited[v] = true;
			for(Neighbour nbr=adjLists[v].adjacencyList; nbr != null; nbr= nbr.next ) {
				if(!visited[nbr.vertexNumber]) {
					System.out.println(adjLists[v].name +"-->" +adjLists[nbr.vertexNumber].name );
					dfs(nbr.vertexNumber,visited);
				}
			}
		}
		
		public void dfs() {
			boolean [] visited = new boolean[adjLists.length];
			for(int i =0; i< visited.length; i++) {
				if(!visited[i]) {
					System.out.println("Starting the Driver at : "+adjLists[i].name);
					dfs(i,visited);
				}
			}
		}

		public static void main(String[] args) {
			DFS g1 = new DFS();
			g1.createVertices();
			g1.createEdgesDirected();
			g1.printGraph();
			g1.dfs();
		}
	}
