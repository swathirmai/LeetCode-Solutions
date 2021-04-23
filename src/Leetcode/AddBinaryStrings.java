package Leetcode;

/*Leetcode : 67. Add Binary
Input: a = "11", b = "1"
Output: "100"*/

public class AddBinaryStrings {

	public static void main(String[] args) {

		String a = "1010", b="1011";

		System.out.print(addBinary(a, b));
	}

	public static String addBinary(String a, String b)
	{

		// Initialize result
		String result = ""; 

		// Initialize digit sum
		int s = 0;         

		// Traverse both strings starting 
		// from last characters
		int i = a.length() - 1, j = b.length() - 1;
		while (i >= 0 || j >= 0 || s == 1)
		{

			// Comput sum of last 
			// digits and carry
			s += ((i >= 0)? a.charAt(i) - '0': 0);
			s += ((j >= 0)? b.charAt(j) - '0': 0);

			// If current digit sum is 
			// 1 or 3, add 1 to result
			result = (char)(s % 2 + '0') + result;

			// Compute carry
			s /= 2;

			// Move to next digits
			i--; j--;
		}

		return result;
	}

	public String binarySum(String a, String b) {
		int n = a.length(), m = b.length();
		if (n < m) 
			return addBinary(b, a);
		int L = Math.max(n, m);

		StringBuilder sb = new StringBuilder();
		int carry = 0, j = m - 1;
		for(int i = L - 1; i > -1; --i) {
			if (a.charAt(i) == '1') 
				++carry;
			if (j > -1 && b.charAt(j--) == '1') 
				++carry;

			if (carry % 2 == 1) 
				sb.append('1');
			else sb.append('0');

			carry /= 2;
		}
		if (carry == 1) 
			sb.append('1');
		sb.reverse();

		return sb.toString();
	}
}
