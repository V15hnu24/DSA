public class LC213_HouseRobber2 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob_helper(nums, 0, nums.length-2), rob_helper(nums,1,nums.length-1));
    }

    int rob_helper(int[] nums, int s, int r){

        int a = 0;
        int b = 0;

        for(int i = r; i>=s; i--){
            int c = Math.max(nums[i] + b, a);
            b = a;
            a =c;
        }

        return a;
    }
}
