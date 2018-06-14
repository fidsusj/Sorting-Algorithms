package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RadixSort {
	
	public RadixSort(int[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println("");
		int[] sortItems = sort(items);
		for (int i = 0; i < sortItems.length; i++) {
			System.out.print(sortItems[i] + " ");
		}
	}
	
	private int[] sort(int[] items) {
		
		ArrayList<Stack<Integer>> buckets = new ArrayList<Stack<Integer>>(10);
		
		for (int i = 0; i < 10; i++) {
			buckets.add(i, new Stack<Integer>());
		}
		
		int maxDigits = getMaxAmountOfDigits(items);
		for (int i = 0; i < maxDigits; i++) {
			for (int j = 0; j < items.length; j++) {
				int currentDigit = (int) ((items[j] % Math.pow(10, i+1))/ Math.pow(10, i));
				buckets.get(currentDigit).push(new Integer(items[j]));
			}
			
			int count = 0;
			for (int j = 0; j < 10; j++) {
				int bucketSize = buckets.get(j).size();
				for (int n = 0; n < bucketSize; n++) {
					items[buckets.get(j).size()-1 + count] = buckets.get(j).pop().intValue();
				}
				count += bucketSize;
			}
		}
		return items;
	}
	
	private int getMaxAmountOfDigits(int[] items) {
		int maxNumber = 0;
		for (int i = 0; i < items.length; i++) {
			int number = new Integer(items[i]).toString().length();
			if(number > maxNumber)
				maxNumber = number;
		}
		return maxNumber;
	}
	
	public static void main(String[] args) {
		
		Random rdm = new Random();
		int[] items = new int[20];
		for (int i = 0; i < items.length; i++) {
			items[i] = rdm.nextInt(10001);
		}
		new RadixSort(items);
		
	}

}