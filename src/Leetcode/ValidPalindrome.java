package Leetcode;

import java.util.Stack;

/*Leetcode : 125. Valid Palindrome
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(str));		
	}

	public static boolean isPalindrome(String str) {
		boolean status = false;
		String strReplace = str.replaceAll("[,:\\s]", "");
		String revStr = "";
		for(int i = strReplace.length()-1;i>=0;i--) {
			revStr+=strReplace.charAt(i);
		}
		if(strReplace.equalsIgnoreCase(revStr)) {
			status = true;
		}
		return status;
	}

	public boolean isPalindromeSb(String s) {
		StringBuilder builder = new StringBuilder();

		for (char ch : s.toCharArray()) {
			if (Character.isLetterOrDigit(ch)) {
				builder.append(Character.toLowerCase(ch));
			}
		}

		String filteredString = builder.toString();
		String reversedString = builder.reverse().toString();

		return filteredString.equals(reversedString);
	}

	public boolean isPalindromeUsingStreams(String s) {
		StringBuilder builder = new StringBuilder();

		s.chars()
		.filter(c -> Character.isLetterOrDigit(c))
		.mapToObj(c -> Character.toLowerCase((char) c))
		.forEach(builder::append);

		return builder.toString().equals(builder.reverse().toString());
	}

	public boolean isPalindromeTwoPointers(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
		}

		return true;
	}


}
