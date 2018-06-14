package sortAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class ShellsSort {

	public ShellsSort(ArrayList<Integer> items) {
		for (int i = 0; i < items.size(); i++) {
			System.out.print(items.get(i).intValue() + " ");
		}
		System.out.println("");
		
		int inc = 0;
		if(items.size()%2 == 0) 
			inc = items.size()/2;
		else
			inc = items.size()/2+1;
		ArrayList<Integer> sortItems = sort(items,inc);
		
		for (int i = 0; i < sortItems.size(); i++) {
			System.out.print(sortItems.get(i).intValue() + " ");
		}
	}
	
	private ArrayList<Integer> sort(ArrayList<Integer> items, int inc) {
		if(inc == 0)
			return items;
		
		for (int i = 0; i < items.size(); i++) {
			items = compareAndSwitch(i, i+inc, items);
		}
		return sort(items, decreaseCnt(inc));	
	}
	
	private ArrayList<Integer> compareAndSwitch(int index, int cmp, ArrayList<Integer> items) {
		
		if(cmp <= items.size()-1 && index >= 0 && items.get(index) > items.get(cmp)){
			Integer temp = items.get(index);
			items.set(index, items.get(cmp));
			items.set(cmp, temp);
			compareAndSwitch(index-(cmp-index), index, items);
		}
		return items;
		
	}
	
	private int decreaseCnt(int cnt) {
		
		if(cnt == 1)
			return 0;
		else if(cnt%2 == 0) 
			return cnt/2;
		else
			return cnt/2+1;
		
	}
	
	
	public static void main(String[] args) {
	
		Random rdm = new Random();
		ArrayList<Integer> items = new ArrayList<Integer>(20);
		for (int i = 0; i < 20; i++) {
			items.add(rdm.nextInt(10001));
		}
		new ShellsSort(items);
	
	}
	
}