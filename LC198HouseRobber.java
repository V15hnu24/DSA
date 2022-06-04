public class LC198HouseRobber {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 2];

        dp[nums.length] = 0;
        dp[nums.length + 1] = 0;

        for(int i = nums.length-1; i>=0; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return dp[0];
    }
    // Optimised SC to O(1)
    public int rob_updated(int[] nums) {

        int a = 0;
        int b = 0;

        for(int i = nums.length-1; i>=0; i--){
            int temp1 = nums[i] + b;
            int temp2 = a;

            int c = Math.max(temp1, temp2);
            b = a;
            a = c;
        }

        return a;
    }
}
