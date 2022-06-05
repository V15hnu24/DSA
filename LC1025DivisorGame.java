public class LC1025DivisorGame {
    public static void main(String[] args) {

    }
    public boolean divisorGame(int n){
        return n%2==0;
    }

    //     int help(int n,int[] dp){
//         if(dp[n] != -1){
//             return dp[n];
//         }
//         if(n==1){
//             return 0;
//         }

//         for(int i=1; i*i<=n; i++){
//             if(n%i == 0){
//                 if(help(n-i, dp)==0) return dp[n] = 1;

//                 if(i!=1 && (help(n-(n/i),dp) == 0)) return dp[n] = 1;
//             }
//         }

//         return dp[n] = 0;
//     }

//     public boolean divisorGame(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         help(n,dp);

//         return dp[n]==1?true:false;
//     }
}
