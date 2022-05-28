import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC6085contest79MaxtotalImportanceofRoads {
    public static void main(String[] args) {

    }
    public long maximumImportance(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        int[][] ary = new int[n][2];

        for (int i = 0; i < n; i++) {
            ary[i][0] = i;
            ary[i][1] = adj.get(i).size();
            for (int j = 0; j < adj.get(i).size(); j++) {
                ary[i][1] += adj.get(adj.get(i).get(j)).size();
            }
        }

        Arrays.sort(ary, (a,b) -> {
            return a[1] - b[1];
        });

        int[] imp = new int[n];
        int p = 1;

        for (int i = 0; i < n; i++) {
            imp[ary[i][0]] = p++;
        }

        long ans = 0;
        for (int i = 0; i < roads.length ; i++) {
            ans+= imp[roads[i][0]] + imp[roads[i][1]];
        }

        return ans;
    }
}
