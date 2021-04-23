package Leetcode;
import java.util.*;

/*Leetcode : 1189. Maximum Number of Balloons
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.
Input: text = "nlaebolko"
Output: 1*/

public class MaximumNumberofBalloons {

	public static void main(String[] args) {


		String str = "leetcode";
		System.out.println(maxNumberOfBalloons(str));

	}

	public static int maxNumberOfBalloons(String text) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : text.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int res = Integer.MAX_VALUE;

		res = Math.min(res, map.getOrDefault('b', 0));
		res = Math.min(res, map.getOrDefault('a', 0));
		res = Math.min(res, map.getOrDefault('n', 0));
		res = Math.min(res, map.getOrDefault('l', 0) / 2);
		res = Math.min(res, map.getOrDefault('o', 0) / 2);

		return res;
	}

}
