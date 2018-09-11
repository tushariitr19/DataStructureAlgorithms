package dataStructure;

import java.util.Arrays;

public class MyQueue {

	private String [] queue;
	private int front, rear, numberOfItems = 0;
	private int sizeOfQueue = 0 ;

	public MyQueue(int size) {
		sizeOfQueue = size;
		queue = new String[size];
		Arrays.fill(queue, "-1");
	}

	public void insert(String item) {
		if(numberOfItems +1 <= sizeOfQueue ) {
			queue[rear] = item;
			rear++;
			numberOfItems++;
		}
		else
		{
			System.out.println("Sorry Queue is full");
		}
		System.out.println("Item : " +item +" Inserted Successfully !");
	}

	public void delete() {
		if(numberOfItems > 0) {
			System.out.println("Item : "+queue[front] +" is deleted Successfully ! ");
			queue[front] = "-1";
			numberOfItems --;
			front++;
		}
		else
		{
			System.out.println("Sorry Queue is Empty !");
		}	
	}
	
	public String peek() {
		System.out.println("PEEK : "+queue[front] +" is the first element in the Queue");
		return queue[front];
	}

	public void display() {
		for(int i=0; i<sizeOfQueue; i++) {
			System.out.println(i +" " +queue[i]);
		}
		System.out.println("Front Pointer : "+front);
		System.out.println("Rear Pointer : "+ (rear-1));
	}

	public static void main(String[] args) {

		MyQueue q1 = new MyQueue(5);
		q1.insert("10");
		q1.insert("25");
		q1.insert("34");
		q1.display();
		q1.delete();
		q1.display();
		q1.delete();
		q1.display();
		q1.insert("94");
		q1.display();
		q1.peek();
	}
}
