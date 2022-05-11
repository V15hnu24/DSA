package ADAHw2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
public class ADAHw2Q1 {

    public static void solve(int n) throws IOException {
        char[][] grid = new char[n][n];
        for(int i = 0;i<n;i++)grid[i] = s.next().toCharArray();
        boolean [][] isTaken = new boolean[n][n];
        List<int[]> ans = new ArrayList<>();

        for(;;){
            boolean added = false;
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    if (isTaken[i][j] || grid[i][j] == '0') continue;
                    int cnt = 0;
                    int which = 0;
                    if (i + 1 < n && !isTaken[i + 1][j] && grid[i + 1][j] == '1') {
                        cnt++;
                        which = 1;
                    }
                    if (i - 1 >= 0 && !isTaken[i - 1][j] && grid[i - 1][j] == '1') {
                        cnt++;
                        which = 2;
                    }
                    if (j + 1 < n && !isTaken[i][j + 1] && grid[i][j + 1] == '1') {
                        cnt++;
                        which = 3;
                    }
                    if (j - 1 >= 0 && !isTaken[i][j - 1] && grid[i][j - 1] == '1') {
                        cnt++;
                        which = 4;
                    }
                    if (cnt == 0) {
                        System.out.println(0);
                        return;
                    }
                    if (cnt == 1) {
                        added = true;
                        isTaken[i][j] = true;
                        if (which == 1) {
                            ans.add(new int[]{i, j, i + 1, j});
                            isTaken[i + 1][j] = true;
                        }
                        if (which == 2) {
                            ans.add(new int[]{i, j, i - 1, j});
                            isTaken[i - 1][j] = true;
                        }
                        if (which == 3) {
                            ans.add(new int[]{i, j, i, j + 1});
                            isTaken[i][j + 1] = true;
                        }
                        if (which == 4) {
                            ans.add(new int[]{i, j, i, j - 1});
                            isTaken[i][j - 1] = true;
                        }

                    }
                    if(added)break;
                }
                if(added)break;
            }
            if(added)break;
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(isTaken[i][j] || grid[i][j]=='0')continue;
                int which = 0;
                if(i+1<n && !isTaken[i+1][j] && grid[i+1][j] =='1'){
                    which = 1;
                }
                if(i-1>=0 && !isTaken[i-1][j] && grid[i-1][j] == '1'){
                    which = 2;
                }
                if(j+1<n && !isTaken[i][j+1] && grid[i][j+1]=='1'){
                    which = 3;
                }
                if(j-1>=0 && !isTaken[i][j-1] && grid[i][j-1]=='1') {
                    which = 4;
                }
                if(which==0){
                    System.out.println(0);
                    return;
                }
                isTaken[i][j] = true;
                if(which==1){
                    ans.add(new int[]{i,j,i+1,j});
                    isTaken[i+1][j] = true;
                }
                if(which==2){
                    ans.add(new int[]{i,j,i-1,j});
                    isTaken[i-1][j] = true;
                }
                if(which==3){
                    ans.add(new int[]{i,j,i,j+1});
                    isTaken[i][j+1] = true;
                }
                if(which==4){
                    ans.add(new int[]{i,j,i,j-1});
                    isTaken[i][j-1] = true;
                }
            }
        System.out.println(1);
        System.out.println(ans.size());
        for(int[] x : ans){
            for(int y : x) {
                System.out.print((y+1)+" ");
            }
            System.out.println();
        }
    }

    static Scanner s;
    public static void main(String[] args) throws IOException {
        s = new Scanner(System.in);
        int n = s.nextInt();
        solve(n);
    }
/*
    /-------------------------------------------EDITING CODE ENDS HERE-------------------------------------------/
            /--------------------------------------HELPER FUNCTIONS STARTS HERE-----------------------------------------/

    public static int mod = (int) 1e9 + 7;
    //    public static int mod =  998244353;
    public static int inf_int = (int) 1e9;

    /--------------------------------------HELPER FUNCTIONS ENDS HERE-----------------------------------------/
            /-------------------------------------------FAST INPUT STARTS HERE---------------------------------------------/

 */


/*
    private static class Scanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();

        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
 */
//    /---------------------------------------------FAST INPUT ENDS HERE ---------------------------------------------/
}
/*
public class ADAHw2Q1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] ary = new int[n][n];
        for (int i = 0; i < n; i++) {
            String k = s.next();
            for (int j = 0; j < n; j++) {
                ary[i][j] = (k.charAt(j)=='0') ?0:1;
            }
        }
        int ans = 0;
        ArrayList<ArrayList<Integer>> bns = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (ary[i][j] == 1) {
                    if (i == n - 1 && j == n - 1) {
                        break;
                    }
                    else if (j == n - 1) {
                        if (ary[i + 1][j] == 1) {
                            ary[i][j] = 0;
                            ary[i + 1][j] = 0;
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(i + 1);
                            temp.add(j + 1);
                            temp.add(i + 1 + 1);
                            temp.add(j + 1);
                            bns.add(temp);
                            ans++;
                        }
                    } else if (i == n - 1) {
                        if (ary[i][j + 1] == 1) {
                            ary[i][j] = 0;
                            ary[i][j + 1] = 0;
                            ans++;
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(i + 1);
                            temp.add(j + 1);
                            temp.add(i + 1);
                            temp.add(j + 1 + 1);
                            bns.add(temp);
                        }

                    } else {
                        if (ary[i + 1][j] == 1) {
                            ary[i][j] = 0;
                            ary[i + 1][j] = 0;
                            ans++;
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(i + 1);
                            temp.add(j + 1);
                            temp.add(i + 1 + 1);
                            temp.add(j + 1);
                            bns.add(temp);
                        }
                        else if (ary[i][j + 1] == 1) {
                            ary[i][j] = 0;
                            ary[i][j + 1] = 0;
                            ans++;
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(i + 1);
                            temp.add(j + 1);
                            temp.add(i + 1);
                            temp.add(j + 1 + 1);
                            bns.add(temp);
                        }
                    }
                }
            }
        }
        if (ans>0) {
            System.out.println(1);
            System.out.println(ans);
            for (int i = 0; i < bns.size(); i++) {
                for (int j = 0; j < bns.get(i).size(); j++) {
                    if(j==bns.get(i).size()-1){
                        System.out.println(bns.get(i).get(j));
                        continue;
                    }
                    System.out.print(bns.get(i).get(j) + " ");
                }
            }
        }else{
            System.out.println(0);
        }
    }
}
*/