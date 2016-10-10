package ProblemSetV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	static class InternalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return Integer.compare(i1.start, i2.start);
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> removal = new ArrayList<Interval>();
		Collections.sort(intervals, new InternalComparator());
		Interval prev = new Interval(0, 0);
		if (intervals.size() == 1)
			return intervals;
		for (Interval intvr : intervals) {
			if (Math.max(prev.start, intvr.start) <= Math.min(prev.end,
					intvr.end)) {
				intvr.start = Math.min(prev.start, intvr.start);
				intvr.end = Math.max(prev.end, intvr.end);
				removal.add(prev);
			} else if (prev.start > intvr.start && prev.end > intvr.end) {
				intvr.start = Math.min(prev.start, intvr.start);
				intvr.end = Math.max(prev.end, intvr.end);
				removal.add(prev);
			}
			prev = intvr;
		}
		for (Interval remv : removal)
			intervals.remove(remv);
		return intervals;
	}

	public void print(ArrayList<Interval> intervals) {
		for (Interval intvr : intervals) {
			System.out.print("[" + intvr.start + "," + intvr.end + "]");
		}
	}

	public static void main(String[] args) {
		MergeIntervals ss = new MergeIntervals();
		ArrayList<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(23, 44));
		a.add(new Interval(34, 35));
		a.add(new Interval(79, 80));
		a.add(new Interval(22, 89));
		a.add(new Interval(21, 27));
		a.add(new Interval(39, 49));
		a.add(new Interval(41, 80));
		a.add(new Interval(83, 87));
		a.add(new Interval(4, 29));
		a.add(new Interval(3, 3));
		a.add(new Interval(72, 81));
		a.add(new Interval(25, 55));
		a = ss.merge(a);
		ss.print(a);

	}
}
