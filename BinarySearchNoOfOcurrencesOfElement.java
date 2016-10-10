package ProblemSetV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchNoOfOcurrencesOfElement {

	public int binarySearchFirstOcc(List<Integer> a, int value, int start,
			int end) {
		int result = -1;
		if (start == end && a.get(start) == value)
			return start;
		else if (start == end && a.get(start) != value)
			return -1;
		else if (start == end - 1 && a.get(start) == value)
			return start;
		else if (start == end - 1 && a.get(end) == value)
			return end;
		else if (start == end - 1
				&& (a.get(start) != value || a.get(end) != value))
			return -1;

		int mid = start + ((end - start) / 2);

		if (a.get(mid) == value)
			result = mid;

		if (a.get(mid) >= value) {
			int someValue = binarySearchFirstOcc(a, value, start, mid - 1);
			result = someValue == -1 ? result : someValue;
		} else {
			int someValue1 = binarySearchFirstOcc(a, value, mid + 1, end);
			result = someValue1 == -1 ? result : someValue1;
		}
		return result;
	}

	public int binarySearchLastOcc(List<Integer> a, int value, int start,
			int end) {
		int result = -1;
		if (start == end && a.get(start) == value)
			return start;
		else if (start == end && a.get(start) != value)
			return -1;
		else if (start == end - 1 && a.get(end) == value)
			return end;
		else if (start == end - 1 && a.get(start) == value)
			return start;
		else if (start == end - 1
				&& (a.get(start) != value || a.get(end) != value))
			return -1;
		int mid = start + ((end - start) / 2);

		if (a.get(mid) == value)
			result = mid;

		if (a.get(mid) <= value) {
			int someValue1 = binarySearchLastOcc(a, value, mid + 1, end);
			result = someValue1 == -1 ? result : someValue1;
		} else {
			int someValue = binarySearchLastOcc(a, value, start, mid - 1);
			result = someValue == -1 ? result : someValue;
		}
		return result;
	}

	public int findCount(List<Integer> a, int b) {
		if (a.size() == 1 && a.get(0) != b)
			return 0;
		int firstOcc = binarySearchFirstOcc(a, b, 0, a.size() - 1);
		int lastOcc = binarySearchLastOcc(a, b, 0, a.size() - 1);
		if (lastOcc == -1 && firstOcc == -1)
			return 0;
		return lastOcc - firstOcc + 1;
	}

	public static void main(String[] args) {
		BinarySearchNoOfOcurrencesOfElement ss = new BinarySearchNoOfOcurrencesOfElement();
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer[] array = { 0, 1, 2, 2, 3 };
		a.addAll(Arrays.asList(array));
		System.out.println(ss.findCount(a, 2));
	}
}
