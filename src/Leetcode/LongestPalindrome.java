package Leetcode;
import java.util.*;

/*Leetcode : 409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
Input: s = "abccccdd"
Output: 7*/

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));

	}

	public static int longestPalindrome(String s) {
		if (s == null || s.length() < 1) return 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i)))
				set.remove(s.charAt(i));
			else 
				set.add(s.charAt(i));
		}
		if (set.size() <= 1) 
			return s.length();
		System.out.println(s.length());
		System.out.println(set.size());
		System.out.println(s.length() - set.size() + 1);
		return s.length() - set.size() + 1;

	}

}
