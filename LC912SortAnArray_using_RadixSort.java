import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Using Radix Sort
public class LC912SortAnArray_using_RadixSort {
    public static void main(String[] args) {
        int ans[] = sortArray(new int[]{-1, 3});
        System.out.println(Arrays.toString(ans));
    }
    public static int[] sortArray(int[] nums) {
        List<Integer>[] temp = new List[19];

        for(int i = 0; i<5;i++){

            for(int l=0; l<19; l++){
                temp[l] = new ArrayList<>();
            }

            for(int j: nums){
                String t = Integer.toString(j);
                if(t.length()-i-1 < 0 || (t.charAt(t.length()-i-1) == '-')){
                    temp[9].add(j);
                    continue;
                }
                if(j<0){
                    if(t.charAt(t.length()-i-1) != '-'){
                        int k = Integer.parseInt(String.valueOf(t.charAt(t.length()-i-1)));
                        temp[9-k].add(j);
                    }
                }else{
                    int k = Integer.parseInt(String.valueOf(t.charAt(t.length()-i-1)));
                    temp[9+k].add(j);
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

        return nums;
    }
}
