package ProblemSetV;

import java.util.Arrays;

public class StringAnagram {

	public int findPivot(char[] array, int start, int end) {
		int i = start;
		int j = end;
		char pivot = array[start];
		while (j > i) {
			while (i < j && array[i + 1] < pivot) {
				i++;
			}
			while (j > i && array[j] > pivot) {
				j--;
			}
			if (j > i) {
				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		char temp = array[j];
		array[j] = pivot;
		array[start] = temp;
		return j;
	}

	public void sortArray(char[] array, int i, int j) {
		if (i == j)
			return;
		if (j == i + 1) {
			if (array[i] > array[j]) {
				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				return;
			} else {
				return;
			}
		}
		int pivot = findPivot(array, i, j);
		if (pivot > i)
			sortArray(array, i, pivot - 1);
		if (pivot < j)
			sortArray(array, pivot + 1, j);
	}
	//Method 1
	public boolean FindStringAnagram(String str1, String str2) {
		char[] string1 = new char[str1.length()];
		char[] string2 = new char[str2.length()];
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				string1[i] = str1.charAt(i);
				string2[i] = str2.charAt(i);
			}
		} else
			return false;
		sortArray(string1, 0, string1.length - 1);
		sortArray(string2, 0, string2.length - 1);
		if (Arrays.equals(string1, string2))
			return true;
		return false;
	}
	//Method 2
	public boolean FindStringAnagramM2(String str1, String str2){
		int[] string1 = new int[256];
		int[] string2 = new int[256];	
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				string1[str1.charAt(i)]++;
				string2[str2.charAt(i)]++;
			}
		}else
			return false;
		if(Arrays.equals(string1, string2))
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAnagram sa = new StringAnagram();
		System.out.println(sa.FindStringAnagram("wdcbf", "bdcf"));
		System.out.println(sa.FindStringAnagramM2("dcfa", "acfd"));

	}

}
