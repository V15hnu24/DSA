import java.util.Arrays;

public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","def"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        Arrays.fill(dp[dp.length-1],0);

        for(int i = 0;i<dp.length;i++){
            dp[i][dp[0].length - 1] = 0;
        }

        for(int i=dp.length -2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                    System.out.println("DP " + dp[i][j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                    System.out.println("Dp " + dp[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}