package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class SelectionSort {

	public SelectionSort(ArrayList<Integer> items) {
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
		 for (int i = 0; i < items.size(); i++){
             int min = i;
             for (int j = i + 1; j < items.size(); j++){
                 if (items.get(j) < items.get(min))
                     min = j;    
             }
             Integer temp = items.get(min);
             items.set(min, items.get(i));
 			 items.set(i, temp);

         }
		return items;
	}
	
	public static void main(String[] args) {
	
		Random rdm = new Random();
		ArrayList<Integer> items = new ArrayList<Integer>(20);
		for (int i = 0; i < 20; i++) {
			items.add(rdm.nextInt(10001));
		}
		new SelectionSort(items);
	
	}
	
}