package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {

	public InsertionSort(ArrayList<Integer> items) {
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
	
		for (int i = 0; i < items.size(); i++) {
			for (int j = i-1; j > -2; j--) {
				if(j == -1 || items.get(j)<items.get(i)) {
					items.add(j+1,items.remove(i));
					break;
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
		new InsertionSort(items);
	
	}
	
}