package ProblemSetV;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOneInListElement {
	public ArrayList<Integer> BetterSolutionplusOne(ArrayList<Integer> A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int carry = 1;
		int num;
		for (int i = A.size() - 1; i >= 0; i--) {
			num = A.get(i);
			num += carry;
			carry = 0;
			if (num == 10) {
				num = 0;
				carry = 1;
			}
			A.set(i, num);
		}
		if (carry == 1)
			res.add(1);
		for (int x : A) {
			if (x == 0 && res.size() == 0)
				continue;
			res.add(x);
		}
		return res;
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int reminder = 0;
		int value = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			if (a.size() - 1 == i) {
				value = (a.get(i) + 1) % 10;
				if (value != 0)
					newList.add(value);
			} else if (reminder == 1) {
				value = (a.get(i) + 1) % 10;
				if (value != 0)
					newList.add(value);
				reminder = 0;
			} else if (value != 0) {
				newList.add(a.get(i));
			}
			if ((value == 0)) {
				newList.add(value + reminder);
				reminder = 1;
			}
		}
		if (reminder != 0)
			newList.add(reminder);
		boolean flag = true;
		for (int i = newList.size() - 1; i >= 0; i--) {
			if (flag) {
				if (newList.get(i) != 0) {
					result.add(newList.get(i));
					flag = false;
				}
			} else {
				result.add(newList.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PlusOneInListElement ss = new PlusOneInListElement();
		ArrayList<Integer> a = new ArrayList<Integer>();
		Integer a1[] = { 0, 0, 0, 9, 9 };

		a.addAll(Arrays.asList(a1));

		System.out.println(ss.plusOne(a));

	}
}
