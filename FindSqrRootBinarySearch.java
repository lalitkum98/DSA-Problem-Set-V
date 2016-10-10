package ProblemSetV;

import java.util.*;

public class FindSqrRootBinarySearch {
	public int sqrt(int a) {
		if (a == 0)
			return a;
		int start = 1;
		int end = a;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid == a / mid)
				return mid;
			if (mid < a / mid) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		FindSqrRootBinarySearch ss = new FindSqrRootBinarySearch();
		ArrayList<Integer> a = new ArrayList<Integer>();
		System.out.println(ss.sqrt(11));
	}
}
