import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc128LongestConsequtivesequence {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        int ans = 0;
        for (int i : nums) {
            if (!s.contains(i-1)){
                int len = 0;
                while(s.contains(i+len)){
                    len++;
                }
                ans = Math.max(len,ans);
            }
        }

        return ans;
    }
}
