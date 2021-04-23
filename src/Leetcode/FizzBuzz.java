package Leetcode;
import java.util.*;

/*Leetcode : 412. Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.*/

public class FizzBuzz {

	public static void main(String[] args) {

		int n = 15;
		List<String> fizzBuzzList = fizzBuzz(n);
		fizzBuzzList.forEach(op->System.out.println(op));
	}

	public static List<String> fizzBuzz(int n) {

		// ans list
		List<String> ans = new ArrayList<String>();

		for (int num = 1; num <= n; num++) {

			boolean divisibleBy3 = (num % 3 == 0);
			boolean divisibleBy5 = (num % 5 == 0);

			if (divisibleBy3 && divisibleBy5) {
				// Divides by both 3 and 5, add FizzBuzz
				ans.add("FizzBuzz");
			} else if (divisibleBy3) {
				// Divides by 3, add Fizz
				ans.add("Fizz");
			} else if (divisibleBy5) {
				// Divides by 5, add Buzz
				ans.add("Buzz");
			} else {
				// Not divisible by 3 or 5, add the number
				ans.add(Integer.toString(num));
			}
		}

		return ans;
	}

	public static List<String> fizzBuzzStringConcat(int n) {
		// ans list
		List<String> ans = new ArrayList<String>();

		for (int num = 1; num <= n; num++) {

			boolean divisibleBy3 = (num % 3 == 0);
			boolean divisibleBy5 = (num % 5 == 0);

			String numAnsStr = "";

			if (divisibleBy3) {
				// Divides by 3, add Fizz
				numAnsStr += "Fizz";
			}

			if (divisibleBy5) {
				// Divides by 5, add Buzz
				numAnsStr += "Buzz";
			}

			if (numAnsStr.equals("")) {
				// Not divisible by 3 or 5, add the number
				numAnsStr += Integer.toString(num);
			}

			// Append the current answer str to the ans list
			ans.add(numAnsStr);
		}

		return ans;
	}


	public static List<String> fizzBuzzHash(int n) {

		// ans list
		List<String> ans = new ArrayList<String>();

		// Hash map to store all fizzbuzz mappings.
		HashMap<Integer, String> fizzBizzDict =
				new HashMap<Integer, String>() {
			{
				put(3, "Fizz");
				put(5, "Buzz");
			}
		};

		for (int num = 1; num <= n; num++) {

			String numAnsStr = "";

			for (Integer key : fizzBizzDict.keySet()) {

				// If the num is divisible by key,
				// then add the corresponding string mapping to current numAnsStr
				if (num % key == 0) {
					numAnsStr += fizzBizzDict.get(key);
				}
			}

			if (numAnsStr.equals("")) {
				// Not divisible by 3 or 5, add the number
				numAnsStr += Integer.toString(num);
			}

			// Append the current answer str to the ans list
			ans.add(numAnsStr);
		}

		return ans;
	}
}
