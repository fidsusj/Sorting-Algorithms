package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class MergeSort {

	public MergeSort(ArrayList<Integer> items) {
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
		
		if(items.size()<= 1)
			return items;
		
		ArrayList<ArrayList<Integer>> divide = divide(items);
		return merge(sort(divide.get(0)),sort(divide.get(1)));
	}
	
	private ArrayList<ArrayList<Integer>> divide(ArrayList<Integer> items) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(2);
		int leftSize = items.size()/2 + items.size()%2;
		int rightSize = items.size()/2;
		ArrayList<Integer> left = new ArrayList<Integer>(leftSize);
		ArrayList<Integer> right = new ArrayList<Integer>(rightSize);		
		
		for (int i = 0; i < leftSize; i++) {
			left.add(items.remove(0));
		}
		
		for (int i = 0; i < rightSize; i++) {
			right.add(items.remove(0));
		}
		result.add(new ArrayList<Integer>(left));
		result.add(new ArrayList<Integer>(right));
		return result;
	}
	
	private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!(left.isEmpty() && right.isEmpty())) {
			if(left.isEmpty()) {
				for (int i = 0; i < right.size(); i++) {
					result.add(right.remove(0));
				}
			}
			else if(right.isEmpty()) {
				for (int i = 0; i < left.size(); i++) {
					result.add(left.remove(0));
				}
			}
			else {
				if(left.get(0).intValue() <= right.get(0).intValue()) {
					result.add(left.remove(0));
				}
				else {
					result.add(right.remove(0));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Random rdm = new Random();
		ArrayList<Integer> items = new ArrayList<Integer>(20);
		for (int i = 0; i < 20; i++) {
			items.add(rdm.nextInt(10001));
		}
		new MergeSort(items);
		
	}
	
}