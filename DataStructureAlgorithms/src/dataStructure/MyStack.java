package dataStructure;

import java.util.Arrays;

public class MyStack {

	private String [] stack;
	private int stackSize;
	private int topOfStack = -1;

	public MyStack(int size) {
		stackSize = size;
		stack = new String[size];
		Arrays.fill(stack, "-1");
	}

	public void push(String item) {
		if(topOfStack + 1 < stackSize) {
			topOfStack ++;
			stack[topOfStack] = item;
			System.out.println("PUSH " +item +" Successful");
		}
		else
			System.out.println("Sorry Stack is Full !!");
	}

	public void pop() {
		if(topOfStack >= 0) {
			stack[topOfStack] = "-1";
			topOfStack --;
			System.out.println("POP is successful");
		}
		else
			System.out.println("Sorry stack is empty");
	}

	public String peek() {

		System.out.println("PEEK : " +stack[topOfStack] +" is at the top of the Stack");
		return 	stack[topOfStack];
	}

	public void displayStack() {
		for(int i=0; i<stackSize; i++) {
			System.out.print(i + "  ");
			System.out.println(stack[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack s1 = new MyStack(5);
		s1.push("Ram");
		s1.push("Laxman");
		s1.push("Hanuman");
		s1.displayStack();
		s1.peek();
		s1.pop();
		s1.displayStack();
		s1.peek();
		//		s1.pop();
		//		s1.displayStack();
		//		s1.pop();
		//		s1.displayStack();
		//		s1.pop();
		//		s1.displayStack();
		//		s1.pop();
		//		s1.displayStack();
	}
}
