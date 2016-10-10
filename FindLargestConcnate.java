package ProblemSetV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLargestConcnate {
	static class Comp implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			String conValue1 = String.valueOf(a) + String.valueOf(b);
			String conValue2 = String.valueOf(b) + String.valueOf(a);
			return conValue2.compareTo(conValue1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer[] array = { 9, 99, 999, 9999, 9998 };
		a.addAll(Arrays.asList(array));
		// System.out.println(ss.largestNumber(a));
		Collections.sort(a, new Comp());
		System.out.println(a);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (Integer value : a) {
			if (value == 0)
				count++;
			sb.append(String.valueOf(value));
		}
		System.out.println(a);
		if (count == a.size())
			System.out.println("0");
		System.out.println(sb);

	}
}
