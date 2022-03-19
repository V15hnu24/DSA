import java.util.Arrays;
import java.util.TreeSet;

public class LongestIncreasingSubsquenceLeetcode300 {
    // leetcode 300 N^2 Time
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = 1; i<n;i++){
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j] && dp[i] < dp[j] +1){
                    dp[i] = dp[j] +1;
                }
            }
        }

        int ans = 0;
        for(int i : dp){
            if(ans<i){
                ans = i;
            }
        }

        return ans;
    }
    // GFG NlogN
    static int longestSubsequence(int size, int a[]){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(a[0]);

        for(int i = 1;i<size; i++){
            if(a[i]>ts.first()){
                ts.add(a[i]);
            }
            else{
                ts.remove(ts.ceiling(a[i]));
                ts.add(a[i]);
            }
        }

        return ts.size();
    }
    static int bs(int[] ary, int target,int s,int e){

        while (s<e){
            int mid = (s+e)/2;
            if(ary[mid]>target) {
                e = mid;
            }else {
                s = mid;
            }
        }

        return s;
    }

}
