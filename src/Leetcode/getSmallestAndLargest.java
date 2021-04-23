package Leetcode;

public class getSmallestAndLargest {

	/*
	 * Given String str and an integer k, find the lexicographically smallest and
	 * largest substring of length k. 
	 * Lexicography order, also called as alphabetical order or dictionary order 
	 * A < B <... < Y < Z < a < b <.. < y < z
	 */

	public static void main(String[] args) {

		String str = "welcometoleetcode";
		int k = 3;
		System.out.println(getSmallestAndLargest(str, k));

	}

	public static String getSmallestAndLargest(String s, int k) {

		String currStr = s.substring(0, k);
		String lexMin = currStr;
		String lexMax = currStr;

		for (int i = k; i < s.length(); i++) {
			currStr = currStr.substring(1, k) + s.charAt(i);
			if (lexMax.compareTo(currStr) < 0)     
				lexMax = currStr;
			if (lexMin.compareTo(currStr) > 0)
				lexMin = currStr;            
		}

		return lexMin + "\n" + lexMax;
	}

}