import java.util.ArrayList;
import java.util.List;

public class FindAllduplicatesinArrayLC442 {
    //Leetcode 442 O(n) time and constant space
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) ans.add(index +1);
            else nums[index] *= -1;
        }
        return ans;
    }

    //gfg O(n) time O(1) space


}
