import java.util.HashMap;

public class LC697DegreeOFAnArray {
    public static void main(String[] args) {

    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> degree = new HashMap<>();
        int d = 0;

        HashMap<Integer, Integer> first = new HashMap<>();
        int min = 0;

        for(int i=0; i<nums.length; i++){
            first.putIfAbsent(nums[i], i);
            degree.put(nums[i], degree.getOrDefault(nums[i],0) + 1);

            if(d < degree.get(nums[i])){
                d = degree.get(nums[i]);
                min = i - first.get(nums[i]) + 1;
            }else if(d == degree.get(nums[i])){
                min = Math.min(min, i - first.get(nums[i]) + 1);
            }
        }


        return min;
    }
}
