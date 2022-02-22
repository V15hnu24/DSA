public class MaximumProductSubarrayLC152 {
    public static void main(String[] args) {
        
    }
    //leetcode
    public int maxProduct(int[] nums) {
        int pm = nums[0];
        int nm = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                pm=1;
                nm=1;
                continue;
            }
            int temp = pm*nums[i];
            pm = Math.max(nums[i],Math.max(temp,nm*nums[i]));
            nm = Math.min(nums[i],Math.max(temp,nm*nums[i]));
            max = Math.max(pm,max);
        }
        return max;
    }
    // gfg
    long maxProduct(int[] arr, int n) {
        if(n==1){
            return arr[0];
        }
        long max_product = 1;
        long min_product = 1;
        long max = 1;

        for(int i = 0;i<n;i++){
            if(arr[i]>0){
                max_product *= arr[i];
                min_product = Math.min(min_product*arr[i],1);
            }
            else if(arr[i] == 0){
                max_product =1;
                min_product =1;
            }
            else{
                long temp = max_product;
                max_product = Math.max(min_product*arr[i],1);
                min_product = temp*arr[i];
            }

            if(max<max_product){
                max = max_product;
            }
        }
        return max;
    }
}