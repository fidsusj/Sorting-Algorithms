package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class HeapSort {

	private ArrayList<Integer> items;
	private int lastIndex;
	
	public HeapSort(ArrayList<Integer> items) {
		this.items = items;
		this.lastIndex = items.size()-1;
		for (int i = 0; i < items.size(); i++) {
			System.out.print(items.get(i).intValue() + " ");
		}
		System.out.println("");
		ArrayList<Integer> sortItems = sort(items);
		for (int i = 0; i < sortItems.size(); i++) {
			System.out.print(sortItems.get(i).intValue() + " ");
		}
	}
	
	private ArrayList<Integer> sort(ArrayList<Integer> items) {
		
		for (int i = (items.size()-1)/2; i >= 0; i--) {
			heapify(i);
		}
		
		for (int i = items.size()-1; i > 0; i--) {
			Integer temp = items.get(i);
			items.set(i, items.get(0));
			items.set(0, temp);
			lastIndex--;
			heapify(0);
		}
		
		return items;

	}
	
	private void heapify(int index) {
		
		int leftChildIndex = 2*index + 1;
		int rightChildIndex = 2*index + 2;
		int maxIndex = index;
		
		if(leftChildIndex <= lastIndex && items.get(maxIndex) < items.get(leftChildIndex))
			maxIndex = leftChildIndex;
		
		if(rightChildIndex <= lastIndex && items.get(maxIndex) < items.get(rightChildIndex))
			maxIndex = rightChildIndex;
		
		if(index != maxIndex) {
			
			Integer temp = items.get(index);
			items.set(index, items.get(maxIndex));
			items.set(maxIndex, temp);
			
			heapify(maxIndex);
			
		}
		
	}

	public static void main(String[] args) {
	
		Random rdm = new Random();
		ArrayList<Integer> items = new ArrayList<Integer>(20);
		for (int i = 0; i < 20; i++) {
			items.add(rdm.nextInt(10001));
		}
		new HeapSort(items);
	
	}
	
}