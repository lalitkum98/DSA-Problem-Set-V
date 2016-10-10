package ProblemSetV;

import java.util.*;

public class SpiralPrintCoveringAllTestCases {

	public ArrayList<Integer> spiralOrder(List<List<Integer>> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// Populate result;
		int endRow = a.size();
		int endCol = a.get(0).size();
		int startRow = 0;
		int startCol = 0;
		
		while (result.size() < a.size() * a.get(0).size()) {

			for (int i = startCol; i < endCol; i++) {
				result.add(a.get(startRow).get(i));
				//System.out.println(a.get(startRow).get(i));
			}
			startRow++;
			for (int i = startRow; i < endRow; i++) {
				result.add(a.get(i).get(endCol - 1));
				//System.out.println(a.get(i).get(endCol - 1));
			}
			endCol--;
			for (int i = endCol - 1; i >= startCol; i--) {
				if (startRow != endRow)
					result.add(a.get(endRow - 1).get(i));
				//System.out.println(a.get(endRow - 1).get(i));
			}
			endRow--;
			for (int i = endRow - 1; i >= startRow; i--) {
				if (startCol != endCol)
					result.add(a.get(i).get(startCol));
				//System.out.println(a.get(i).get(startCol));
			}
			startCol++;
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralPrintCoveringAllTestCases ss = new SpiralPrintCoveringAllTestCases();

		List<List<Integer>> a = new ArrayList<List<Integer>>();
		int arry[][] = { { 1 }, { 6 }, { 11 }, { 16 } };

		for (int i = 0; i < arry.length; i++) {
			List<Integer> b = new ArrayList<Integer>();
			for (int j = 0; j < arry[0].length; j++) {
				b.add(arry[i][j]);
			}
			a.add(b);
		}
		//System.out.println(a);
		System.out.println(ss.spiralOrder(a));

	}
}
