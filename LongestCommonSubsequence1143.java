import java.util.Arrays;

public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","def"));
        Character ans [] = PrintinglongestCommonSubsequence("abcdef","bdf");

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    //top down approach
    /*
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
     */
    //bottom up approach
    public static int longestCommonSubsequence(String text1,String text2){

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        Arrays.fill(dp[0],0);

        for(int i=1;i<text1.length();i++){
            dp[i][0] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    //Printing the subsequence
    public static Character[] PrintinglongestCommonSubsequence(String text1,String text2){

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        Arrays.fill(dp[0],0);

        for(int i=1;i<text1.length();i++){
            dp[i][0] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int len = dp[text1.length()][text2.length()];

        Character ans[] = new Character[len];
        int index = ans.length-1;
        int i=text1.length(), j = text2.length();
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans[index] = text1.charAt(i-1);
                index--;
                i--;
                j--;
            }else if (dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        return ans;
    }

}