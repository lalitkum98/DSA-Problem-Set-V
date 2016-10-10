package ProblemSetV;

import java.util.ArrayList;

public class SpiralPrintRowWiseGivenNumber {

	public ArrayList<ArrayList<Integer>> spiralOrder(Integer A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int size = (A + (A - 1));
		int value = A;
		int mid = size / 2;
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(0);
		if (A == 0) {
			result.add(row1);
			return result;
		}

		for (int i = 0; i < size; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			int k = 0;
			for (int j = 0; j < size; j++) {
				if (i <= mid) {
					if (j <= mid) {
						row.add(value);
						if (j < i)
							value--;
					} else if (j > mid) {
						if (i > mid - (j % mid == 0 ? mid : (j % mid)))
							value++;
						row.add(value);
					}
				} else if (i > mid) {
					if (j <= mid) {
						row.add(value);
						if (j < (mid - (i % mid == 0 ? mid : (i % mid))))
							value--;
					} else if (j > mid) {
						if ((mid - (i % mid == 0 ? mid : (i % mid))) > (mid - (j
								% mid == 0 ? mid : (j % mid))))
							value++;
						row.add(value);
					}
				}
			}
			result.add(row);
			value = A;
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralPrintRowWiseGivenNumber ss = new SpiralPrintRowWiseGivenNumber();
		System.out.println(ss.spiralOrder(3));
	}
}
