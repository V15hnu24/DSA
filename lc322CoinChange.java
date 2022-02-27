import java.util.Arrays;

public class lc322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        return coin(coins,amount,dp)==2147483647? -1:coin(coins,amount,dp);
    }
    int coin(int[] coins, int amount, int[] dp){
        if(amount == 0) return 0;

        int f = Integer.MAX_VALUE;

        for(int i = 0;i<coins.length;i++){

            if(amount-coins[i] >= 0){
                int ans = 0;
                if(dp[amount-coins[i]]!=-1){
                    ans = dp[amount-coins[i]];
                }else{
                    ans = coin(coins,amount-coins[i],dp);
                }
                if(ans != Integer.MAX_VALUE && ans+1 < f){
                    f = ans+1;
                }
            }
        }
        return dp[amount] = f;
    }
}
