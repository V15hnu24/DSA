import java.util.ArrayList;
import java.util.Arrays;

public class prims {
    public static void main(String[] args) {

    }

    static void prismMst(int graph[][]){

        int v = graph.length;
        int[] parent = new int[v];
        int key[] = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        
        key[0] = 0;
        
        parent[0] = -1;
        visited[0] = true;
        for (int i = 0; i < v-1; i++) {

            int min = minKey(key,visited);
            
            visited[min] = true;

            for (int j = 0; j < v; j++) {
                if (graph[min][j] != 0 && visited[j] == false && graph[min][j] < key[v]){
                    parent[v] = min;
                    key[v] = graph[min][j];
                }
            }
        }
    }

    static int minKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int min_index=0;
        
        for (int i = 0; i < key.length; i++) {

            if (visited[i] == false && key[i]<min){
                min = key[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
}
