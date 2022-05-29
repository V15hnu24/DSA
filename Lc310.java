import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc310 {
    public static void main(String[] args) {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if(n<=0){
            return res;
        }

        if(n==1){
            res.add(0);
            return res;
        }


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inD = new int[n];

        for(int i=0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            inD[edges[i][0]]++;
            inD[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(inD[i] == 1){
                q.add(i);
            }
        }

        while(n>2){
            int size = q.size();
            n = n - size;

            while(size-->0){
                int temp = q.poll();
                for(int k: adj.get(temp)){
                    inD[k]--;
                    if(inD[k] == 1){
                        q.add(k);
                    }
                }
            }
        }

        res.addAll(q);


        return res;
    }
}
