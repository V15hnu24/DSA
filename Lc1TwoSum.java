import java.util.HashMap;

public class Lc1TwoSum {
    public static void main(String[] args) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1,1);
        System.out.println(hm.get(1));
        hm.put(1,2);
        System.out.println(hm.get(1));
    }
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans[] = new int[2];

        for (int i=0; i<nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = hm.get(target-nums[i]);

                return ans;
            }

            hm.put(nums[i],i);
        }

        return ans;
    }
}
