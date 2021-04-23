package Leetcode;

/*Leetcode : 1014. Best Sightseeing Pair
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. 
Two sightseeing spots i and j have a distance j - i between them.
The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
Return the maximum score of a pair of sightseeing spots.
Input: values = [8,1,5,2,6]
Output: 11
 */

public class BestSightseeingPair {

	public static void main(String[] args) {
		int[] values = {8,1,5,2,6};
		System.out.println(maxScoreSightseeingPair(values));

	}	

	public static int maxScoreSightseeingPair(int[] A) {
		if (A.length == 0 || A == null) {
			return 0;
		}
		int result = 0;
		int max = A[0] + 0;
		for (int i = 1; i < A.length; ++i) {
			result = Math.max(result, max + A[i] - i);
			max = Math.max(max, A[i] + i);
		}
		return result;
	}
}
