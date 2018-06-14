package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {

	public QuickSort(ArrayList<Integer> items) {
		for (int i = 0; i < items.size(); i++) {
			System.out.print(items.get(i).intValue() + " ");
		}
		System.out.println("");
		ArrayList<Integer> sortItems = sort(items);
		for (int i = 0; i < sortItems.size(); i++) {
			System.out.print(sortItems.get(i).intValue() + " ");
		}
	}
	
	public QuickSort(int[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println("");
	    items = sort(items, 0, items.length-1);
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
	}
	
	private ArrayList<Integer> sort(ArrayList<Integer> items) {
		
		if(items.size() <= 1)
			return items;
		
		Integer pivot = items.remove(items.size()-1).intValue();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int size = items.size();
		
		for (int i = 0; i < size; i++) {
			if(items.get(0).intValue() <= pivot)
				left.add(items.remove(0));
			else
				right.add(items.remove(0));
		}
		
		left = sort(left);
		right = sort(right);
		
		size = left.size();
		for (int i = 0; i < size; i++) {
			result.add(left.remove(0));
		}
		result.add(new Integer(pivot));
		size = right.size();
		for (int i = 0; i < size; i++) {
			result.add(right.remove(0));
		}
		
		return result;
	}
	
	private int[] sort(int[] items, int l, int r) {
		
		if(l >=r)
			return items;
		
		int left = l;
		int right = r;
		
		int indexLeft = left;
		int indexRight = right;
		int pivot = (indexLeft + indexRight) / 2;
		
		while(indexLeft < indexRight) {
			while(items[indexLeft] < items[pivot])
				indexLeft++;
			
			while(items[indexRight] > items[pivot])
				indexRight--;
		
			if(indexLeft < indexRight && indexLeft < pivot && indexRight > pivot) {
				int temp = items[indexLeft];
				items[indexLeft++] = items[indexRight];
				items[indexRight--] = temp;
			}
			else if(indexLeft < indexRight && indexLeft < pivot && indexRight == pivot) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < items.length; i++) {
					list.add(items[i]);
				}
				list.add(pivot, list.remove(indexLeft));
				pivot -= 1;
				for (int i = 0; i < items.length; i++) {
					items[i] = list.get(i).intValue();
				}
			}
			else if(indexLeft < indexRight && indexLeft == pivot && indexRight > pivot) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < items.length; i++) {
					list.add(items[i]);
				}
				list.add(pivot, list.remove(indexRight));
				pivot += 1;
				for (int i = 0; i < items.length; i++) {
					items[i] = list.get(i).intValue();
				}
			}
			else {
				break;
			}
		}
		
		items = sort(items, l, indexLeft-1);
		items = sort(items, indexRight+1, r);
		
		return items;
		
	}

	public static void main(String[] args) {
	
		Random rdm = new Random();
		ArrayList<Integer> items = new ArrayList<Integer>(20);
		for (int i = 0; i < 20; i++) {
			items.add(rdm.nextInt(10001));
		}
		new QuickSort(items);
		System.out.println("\n--------------");
		int[] sortItems = new int[20];
		for (int i = 0; i < sortItems.length; i++) {
			sortItems[i] = rdm.nextInt(10001);
		}
		new QuickSort(sortItems);
	
	}
	
}