package ProblemSetV;

import java.util.ArrayList;

public class MatrxColRowMakeZero {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int[][] array = new int[a.size()][a.get(0).size()];
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(0).size(); j++) {
				array[i][j] = a.get(i).get(j);
			}
		}
		int[] col = new int[a.get(0).size()];
		int[] row = new int[a.size()];
		for (int i = 0; i < a.size(); i++)
			row[i] = 1;
		for (int j = 0; j < a.get(0).size(); j++)
			col[j] = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == 0) {
					row[i] = 0;
					col[j] = 0;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (row[i] == 0 || col[j] == 0)
					array[i][j] = 0;
			}
		}

		for (int i = 0; i < array.length; i++) {
			ArrayList<Integer> aa = new ArrayList<Integer>();
			for (int j = 0; j < array[0].length; j++) {
				aa.add(j, array[i][j]);
			}
			a.set(i, aa);
		}

	}

	public static void main(String[] args) {
		MatrxColRowMakeZero ss = new MatrxColRowMakeZero();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int arry[][] = { { 0, 0 }, { 1, 1 } };
		for (int i = 0; i < arry.length; i++) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			for (int j = 0; j < arry[0].length; j++) {
				b.add(arry[i][j]);
			}
			a.add(b);
		}
		ss.setZeroes(a);
		System.out.println(a);
	}
}
