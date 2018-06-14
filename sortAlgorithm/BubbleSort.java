package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort {

	public BubbleSort(ArrayList<Integer> items) {
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
	
		int temp = 0;
		for (int i = 0; i < items.size(); i++) {
			for (int j = 0; j < items.size()-(1+i); j++) {
				if(items.get(j) > items.get(j+1)) {
					temp = items.get(j);
					items.set(j, items.get(j+1));
					items.set(j+1, temp);
				}
			}
		}
		return items;
		
	}
	
	public static void main(String[] args) {
	
		Random rdm = new Random();
		ArrayList<Integer> items = new ArrayList<Integer>(20);
		for (int i = 0; i < 20; i++) {
			items.add(rdm.nextInt(10001));
		}
		new BubbleSort(items);
	
	}
	
}