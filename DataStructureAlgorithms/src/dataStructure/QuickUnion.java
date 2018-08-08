package dataStructure;

public class QuickUnion {

	private int [] arr;

	public QuickUnion(int n) {
		arr = new int [n];
		for(int i =0; i<n ;i++)
			arr[i] = i;
	}

	int findRoot(int element) {
		int root = arr[element];
		while(arr[root] != root) {
			root = arr[root];
		}
		return root;
	}

	boolean connected(int x, int y) {
		int root_x = findRoot(x);
		int root_y = findRoot(y);
		return(root_x == root_y);
	}

	public void union(int x, int y) {
		int root_x = findRoot(x);
		int root_y = findRoot(y);
		arr[root_x] = root_y;
	}

	public void display() {
		for(int i=0; i<arr.length; i++)
			System.out.println("Index : "+i +" Value :"+arr[i]);
	}

	public static void main(String[] args) {

		QuickUnion a = new QuickUnion(10);
		a.display();
		a.union(3, 8);
		System.out.println("*******");
		a.display();
		a.union(3, 9);
		System.out.println("*******");
		a.display();
		System.out.println(a.connected(8,7));
		
	}
}
