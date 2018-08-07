package dataStructure;

public class UnionFind {
	
	private int [] arr;
	
	public UnionFind(int n) {
		arr = new int[n]; 
		for(int i =0 ;i<n ;i++)
			arr[i] = i;
		
		
	}
	
	boolean connected(int x, int y) {
		if (arr[x] == arr[y])
			return true;
		else
			return false;
	}
	
	public void union(int x ,int y) {
		int x_value = arr[x];
		int y_value = arr[y];
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == y_value) {
				arr[i] = x_value;
			}
		}
	}
	
	public void display() {
		for(int i=0; i<arr.length; i++)
		System.out.println("Index : "+i +" Value :"+arr[i]);
	}
	
	public static void main(String[] args) {
		
		UnionFind l1 = new UnionFind(10);
		l1.display();
		l1.union(2, 7);
		System.out.println("********************");
		l1.display();
		l1.union(4, 0);
		System.out.println("********************");
		l1.display();
		System.out.println(l1.connected(2, 7));
		System.out.println(l1.connected(4, 0));
		
	}

}
