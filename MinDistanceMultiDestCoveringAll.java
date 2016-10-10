package ProblemSetV;

import java.util.ArrayList;
import java.util.Arrays;

public class MinDistanceMultiDestCoveringAll {
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int step = 0;
		for (int i = 0; i < X.size() - 1; i++) {
			int x = X.get(i);
			int y = Y.get(i);
			int destx = X.get(i + 1);
			int desty = Y.get(i + 1);
			step = step
					+ Math.max(Math.abs(Math.abs(x) - Math.abs(destx)),
							Math.abs(Math.abs(y) - Math.abs(desty)));
		}
		return step;
	}
	public static void main(String[] args) {
		MinDistanceMultiDestCoveringAll ss = new MinDistanceMultiDestCoveringAll();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		Integer a1[] = { 4, 8, -7, -5, -13, 9, -7, 8 };
		Integer b1[] = { 4, -15, -10, -3, -13, 12, 8, -8 };
		a.addAll(Arrays.asList(a1));
		b.addAll(Arrays.asList(b1));

		System.out.println(ss.coverPoints(a, b));

	}
}
