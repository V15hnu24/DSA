public class LC775GlobalandLocalInversions {
    public static void main(String[] args) {

    }

    public boolean isIdealPermutation(int[] nums) {
        // int global = 0;
        // int local = 0;
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] > i){
        //         global= global + nums[i] - i;
        //         if(i+1<nums.length && nums[i] > nums[i+1]){
        //             local++;
        //         }
        //     }
        // }
        // return global==local;

        for(int i=0; i<nums.length; i++){
            if(Math.abs(nums[i]-i) > 1){
                return false;
            }
        }

        return true;
    }
}
