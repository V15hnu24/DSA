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
}
