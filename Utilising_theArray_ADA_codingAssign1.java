import java.util.*;

public class Utilising_theArray_ADA_codingAssign1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int ary[] = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = s.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 2; i <= 200; i++) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            subSequenceSum(ans,ary,new ArrayList<>(),i,0);
            map.put(i,ans.size());
        }

        int max = Integer.MIN_VALUE;
        for (int i:map.keySet()) {
            max = Math.max(max,map.get(i));
        }
        System.out.println(max);
        System.out.println(n-max);
    }

    public static void subSequenceSum(
            ArrayList<ArrayList<Integer>> ans,
            int a[], ArrayList<Integer> temp,
            int k, int start)
    {
        // Here we have used ArrayList
        // of ArrayList in in Java for
        // implementation of Jagged Array

        // if k < 0 then the sum of
        // the current subsequence
        // in temp is greater than K
        if(start > a.length || k < 0)
            return ;

        // if(k==0) means that the sum
        // of this subsequence
        // is equal to K
        if(k == 0)
        {
            ans.add(
                    new ArrayList<Integer>(temp)
            );
            return ;
        }
        else {
            for (int i = start;
                 i < a.length; i++) {

                // Adding a new
                // element into temp
                temp.add(a[i]);

                // After selecting an
                // element from the
                // array we subtract K
                // by that value
                subSequenceSum(ans, a,
                        temp, k - a[i],i+1);

                // Remove the lastly
                // added element
                temp.remove(temp.size() - 1);
            }
        }
    }
}