package ProblemSetV;

import java.util.*;

public class SortedMatrixSearchElementBinarySerach {

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		return binarySerachMatrix(a, b, 0, a.size() * a.get(0).size() - 1);
	}

	public int binarySerachMatrix(ArrayList<ArrayList<Integer>> a, int value,
			int start, int end) {
		int result = 0;
		if (start <= end) {
			int mid = start + (end - start) / 2;
			int div = 0;
			div = mid / (a.get(0).size());
			int per = mid % (a.get(0).size());
			int i = 0, j = 0;
			if (per == 0) {
				j = mid % a.get(0).size();
				i = div;
			} else {
				j = per;
				i = div;
			}
			if (a.get(i).get(j) == value)
				return 1;
			if (a.get(i).get(j) < value)
				result = binarySerachMatrix(a, value, mid + 1, end);
			if (a.get(i).get(j) > value)
				result = binarySerachMatrix(a, value, start, mid - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		SortedMatrixSearchElementBinarySerach ss = new SortedMatrixSearchElementBinarySerach();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int arry[][] = { { 22, 32, 67 } };
		for (int i = 0; i < arry.length; i++) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (int j = 0; j < arry[0].length; j++) {
				b.add(arry[i][j]);
			}
			a.add(b);
		}
		System.out.println(ss.searchMatrix(a, 68));
	}
}
