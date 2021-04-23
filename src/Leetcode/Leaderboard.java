package Leetcode;
import java.util.*;

/*Leetcode : 1244. Design A Leaderboard
 * Design a Leaderboard class, which has 3 functions:
addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.
 */

public class Leaderboard {

	public static void main(String[] args) {
		String[] strArr = {"Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"};
		//int[] intArr = {{1,73},{2,56},{3,39},{4,51},{5,4},{1},{1},{2},{2,51},{3}};
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
		leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
		leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
		leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
		leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
		leaderboard.top(1);           // returns 73;
		leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
		leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
		leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
		leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
	}

	private HashMap<Integer, Integer> scores;

	public Leaderboard() {

		// Since this is a single threaded application and we don't need synchronized access, a 
		// HashMap is a good choice of data structure as compared to a Hashtable. Read more here:
		// https://stackoverflow.com/questions/40471/what-are-the-differences-between-a-hashmap-and-a-hashtable-in-java 
		this.scores = new HashMap<Integer, Integer>();
	}

	public void addScore(int playerId, int score) {

		if (!this.scores.containsKey(playerId)) {
			this.scores.put(playerId, 0);
		}

		this.scores.put(playerId, this.scores.get(playerId) + score);
	}

	public int top(int K) {

		List<Integer> values = new ArrayList<Integer>(this.scores.values());
		Collections.sort(values, Collections.reverseOrder());

		int total = 0;
		for (int i = 0; i < K; i++) {
			total += values.get(i);            
		}

		return total;
	}

	public void reset(int playerId) {
		this.scores.put(playerId, 0);
	}
}