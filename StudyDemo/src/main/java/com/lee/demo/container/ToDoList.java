package com.lee.demo.container;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.TodoItem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static class TodoItem implements Comparable<TodoItem> {

		private char primary;
		private int secondary;
		private String item;
		
		public TodoItem (String td, char pri, int sec) {
			this.item = td;
			this.primary = pri;
			this.secondary = sec;
		}
		@Override
		public int compareTo(TodoItem arg) {
			if (primary > arg.primary) {
				return +1;
			}
			if (primary == arg.primary) {
				if (secondary > arg.secondary) {
					return +1;
				} else if (secondary == arg.secondary){
					return 0;
				}
			}
			return -1;
		}
		
		public String toString() {
			return Character.toString(primary) + secondary + ": " + item;
		}
		
	}
	
	public void add(String td, char pri, int sec) {
		super.add(new TodoItem(td, pri, sec));
	}
	public static void main(String[] args) {

		/*HashMap<K, V>*/
		System.out.println((2 & 4));
		ToDoList toDoList = new ToDoList();
		toDoList.add("Empty trash", 'C', 4);
		toDoList.add("Feed dog", 'A', 2);
		toDoList.add("Mow lawn", 'B', 7);
		toDoList.add("Water lawn", 'A', 1);
		while (!toDoList.isEmpty()) {
			System.out.println(toDoList.remove());
		}
	}

}
