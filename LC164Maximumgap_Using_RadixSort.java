import java.util.ArrayList;
import java.util.List;

public class LC164Maximumgap_Using_RadixSort {
    public static void main(String[] args) {

    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        List<Integer>[] temp = new List[10];

        for(int i = 0; i<9; i++){

            for(int l=0; l<10; l++){
                temp[l] = new ArrayList<>();
            }

            for(int j:nums){

                String s = Integer.toString(j);

                if(s.length()-i-1 <0){
                    temp[0].add(j);
                }else{
                    temp[Integer.parseInt(String.valueOf(s.charAt(s.length() - i - 1)))].add(j);
                }

            }

            int v = 0;
            for(List<Integer> r: temp){
                for (int j = 0; j < r.size(); j++) {
                    nums[v] = r.get(j);
                    v++;
                }
            }
        }

        int max = 0;
        for(int i = 0; i< nums.length-1; i++){
            max = Math.max(max,nums[i+1]-nums[i]);
        }

        return max;
    }
}
