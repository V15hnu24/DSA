import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LC1122Relativesorting {
    public static void main(String[] args) {


    }

    //bruteforce
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<arr2.length;i++){
            hm.put(arr2[i],i);
        }

        ArrayList<node> l = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0;i<arr1.length;i++){
            node n = new node(arr1[i],-1);
            if(hm.containsKey(arr1[i])){
                n.value = hm.get(arr1[i]);
                l.add(n);
            }else{
                a.add(arr1[i]);
            }
        }

        Integer[] ary = new Integer[a.size()];
        ary = a.toArray(ary);
        if(ary.length>1){
            Arrays.sort(ary);
        }

        node[] bry = new node[l.size()];
        bry = l.toArray(bry);
        Arrays.sort(bry, new sortbyValue());

        for(int i=0;i<bry.length;i++){
            arr1[i]=bry[i].a;
        }

        for(int i=0; i<ary.length; i++){
            arr1[bry.length +i] = ary[i];
        }


        return arr1;
    }
    class sortbyValue implements Comparator<node> {
        public int compare(node a, node b)
        {
            return a.value - b.value;
        }
    }

    class node{
        int a;
        int value;

        public node(int a, int value){
            this.a = a;
            this.value = value;
        }
    }
}
