public class MaximumSubarrayLC53 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int maxsum = nums[0];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            if(sum<nums[i]) {
                sum = nums[i];
            }

            if(maxsum<sum){
                maxsum = sum;

            }
        }

        return maxsum;

    }
    // gfg
    long maxSubarraySum(int arr[], int n){

        long max_so_far = Integer.MIN_VALUE;
        long max_end_here = 0;

        for(int i = 0;i<n;i++){
            max_end_here += arr[i];

            if(max_so_far < max_end_here){
                max_so_far = max_end_here;
            }

            if(max_end_here<0){
                max_end_here = 0;
            }
        }

        return max_so_far;
    }
}
