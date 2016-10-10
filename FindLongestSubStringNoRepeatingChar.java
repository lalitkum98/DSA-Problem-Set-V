		package ProblemSetV;
		
		import java.util.ArrayList;
		import java.util.List;
		
		public class FindLongestSubStringNoRepeatingChar {
			public String findLongestSubString(String str) {
				List<Character> list = new ArrayList<Character>();
				int Max_so_far = 0;
				int start = 0;
				int end = 0;
				int maxstr = 0;
				int initial = 0;
				for (int i = 0; i < str.length(); i++) {
					if (!list.contains(str.charAt(i))) {
						list.add(str.charAt(i));
						maxstr++;
					} else {
						if (Max_so_far < maxstr) {
							Max_so_far = maxstr;
							end = i;
							start = initial;
						}
						initial = i;
						list.clear();
						list.add(str.charAt(i));
						maxstr = 0;
					}
		
				}
				return str.substring(start, end);
			}
		
			public static void main(String[] args) {
				String str = "geeksforgeeks";
				FindLongestSubStringNoRepeatingChar lss = new FindLongestSubStringNoRepeatingChar();
				System.out.println(lss.findLongestSubString(str));
			}
		
		}
