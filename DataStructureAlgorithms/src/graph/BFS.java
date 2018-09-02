package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
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

	public void bfs(int v, boolean [] visited, Queue<Integer> q) {
		visited[v] = true;
		System.out.println("Visiting node "+adjLists[v].name);
		q.add(v);
		while(!q.isEmpty()) {
			int node = q.remove();
			for(Neighbour nbr=adjLists[node].adjacencyList; nbr != null; nbr= nbr.next ) {
				int vnum = nbr.vertexNumber;
				if(!visited[vnum]) {
					System.out.println(adjLists[v].name +"-->" +adjLists[nbr.vertexNumber].name );
					visited[nbr.vertexNumber] = true;
					q.add(vnum);
				}
			}
		}
	}

	public void bfs() {
		boolean [] visited = new boolean[adjLists.length];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =0; i< visited.length; i++) {
			if(!visited[i]) {
				System.out.println("Starting the Driver at : "+adjLists[i].name);
				bfs(i,visited,q);
			}
		}
	}

	public static void main(String[] args) {
		BFS g1 = new BFS();
		g1.createVertices();
		g1.createEdgesDirected();
		g1.printGraph();
		g1.bfs();
	}
}
