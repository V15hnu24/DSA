package ADAHw2;

import java.io.*;
import java.util.*;

public class ADAHw2Q2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();

        // This function helps to detect primes and play around with them
        int[] divisor = helper((int)1e6);
        int[][] dynamic = new int[n+1][k+1];

        for(int i=0;i<=n;i++) {
            Arrays.fill(dynamic[i],Integer.MAX_VALUE);
        }

        ArrayList<edge>[] adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            int w= s.nextInt();

            adj[x].add(new edge(y,w));
            adj[y].add(new edge(x,w));
        }

        int a = s.nextInt();
        int b = s.nextInt();
        dynamic[a][0] = 0;

        List<int[]> traversed = new ArrayList<>();
        traversed.add(new int[]{a,0});

        int i = 1;
        while(i<=n-1){

            if(traversed.size()==0){
                break;
            }

            List<int[]> updated = new ArrayList<>();

            for(int[] temp : traversed) {
                int x = temp[0];
                int q = temp[1];

                // This con helps get all the neighbours
                for (edge con : adj[x]) {
                    int y = con.e;
                    int w = con.w;

                    if(dynamic[y][q] >  dynamic[x][q] + w){
                        dynamic[y][q] = dynamic[x][q] + w;
                        updated.add(new int[]{y,q});
                    }


                    if(q+1 <= k){
                        int temp_util =w;
                        int l = w;
                        while (w > 1){
                            int divsor = divisor[w];
                            temp_util = Math.min(temp_util,(l/divsor) + (2 *divsor));
                            while (divisor[w]==divsor){
                                w/=divsor;
                            }
                        }

                        int v = temp_util;
                        if(v < w && dynamic[y][q+1] > dynamic[x][q] + v){
                            dynamic[y][q+1] = dynamic[x][q] + v;
                            updated.add(new int[]{y,q+1});
                        }
                    }
                }
            }
            traversed = updated;
            i++;
        }

        int ans = dynamic[b][0];
        for(i=0;i<=k;i++){
            ans = Math.min(ans,dynamic[b][i]);
        }

        System.out.println(ans);
    }

    public static int[] helper(int n){
        int[] divisor = new int[n+1];
        for(int i=0;i<=n;i++){
            divisor[i] = i;
        }
        for(int i=2;i*i<=(n);i++) {
            if (divisor[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (divisor[j] == j) {
                        divisor[j] = i;
                    }
                }
            }
        }
        return divisor;
    }
}

class edge{
    int e;
    int w;
    public edge(int e, int w){
        this.e = e;
        this.w = w;
    }
}