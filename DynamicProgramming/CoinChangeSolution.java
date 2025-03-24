package CoinChangeSolution;
import java.util.Arrays;
import java.util.HashMap;

public class CoinChangeSolution {
	static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        int result = dp(coins, amount);
        return (result == Integer.MAX_VALUE) ? -1 : result; // If no solution, return -1
    }

    private static int dp(int[] coins, int amount) {
        if (amount == 0) return 0; // Base case: No coins needed for amount 0
        if (amount < 0) return Integer.MAX_VALUE; // Invalid case

        if (memo.containsKey(amount)) {
            return memo.get(amount); // Use stored result
        }

        int minCoins = Integer.MAX_VALUE; // Track minimum coins needed

        for (int coin : coins) {
            int subResult = dp(coins, amount - coin); // Try using this coin
            if (subResult != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, subResult + 1);
            }
        }

        memo.put(amount, minCoins); // Store result
        return minCoins;
	}

	public static void main(String[] args){
		int[] coins=new int[]{1,2,5};
		int amount=11;
		int ans=coinChange(coins,amount);

	}
}
