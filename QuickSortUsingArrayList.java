package ProblemSetV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortUsingArrayList {

	public List<Integer> swap(List<Integer> a, int i, int j) {
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
		return a;
	}

	public int findPartition(List<Integer> a, int start, int end) {
		int i = start;
		int j = end + 1;
		int pivot = a.get(start);
		while (i <= j) {
			do {
				i++;
			} while (i < j && a.get(i) < pivot);

			do {
				j--;
			} while (i < j && a.get(j) > pivot);
			if (i < j)
				a = swap(a, i, j);
		}
		a = swap(a, start, j);
		return j;
	}

	public List<Integer> sortArray(List<Integer> a, int start, int end) {
		if (start == end)
			return a;
		else if (start == end - 1) {
			if (a.get(start) > a.get(end))
				a = swap(a, start, end);
			return a;
		}

		int partition = findPartition(a, start, end);
		if (partition > start)
			a = sortArray(a, start, partition - 1);
		if (partition < end)
			a = sortArray(a, partition + 1, end);
		return a;
	}

	public static void main(String[] args) {
		QuickSortUsingArrayList ss = new QuickSortUsingArrayList();
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer[] array = { 1, 7, 5, 4, 3 };
		a.addAll(Arrays.asList(array));
		System.out.println(ss.sortArray(a, 0, a.size() - 1));

	}
}
