package ADAHw2;

import java.io.*;
import java.util.*;

public class w1 {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] ary = new int[n][n];
        boolean [][] visited = new boolean[n][n];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String k = s.next();
            for (int j = 0; j < n; j++) {
                ary[i][j] = (k.charAt(j)=='0') ?0:1;
            }
        }

        while (true){
            boolean flag = false;

            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {

                    if (visited[i][j] || ary[i][j] == 0){
                        continue;
                    }

                    int Cases = 0;
                    int Case = 0;

                    if (i < n-1 && !visited[i + 1][j] && ary[i + 1][j] == 1) {
                        Cases++;
                        Case = 1;
                    }
                    if (i - 1 >= 0 && !visited[i - 1][j] && ary[i - 1][j] == 1) {
                        Cases++;
                        Case = 2;
                    }
                    if (j < n-1 && !visited[i][j + 1] && ary[i][j + 1] == 1) {
                        Cases++;
                        Case = 3;
                    }
                    if (j - 1 >= 0 && !visited[i][j - 1] && ary[i][j - 1] == 1) {
                        Cases++;
                        Case = 4;
                    }
                    if (Cases == 0) {
                        System.out.println(0);
                        return;
                    }

                    if (Cases == 1) {
                        flag = true;
                        visited[i][j] = true;
                        List<Integer> tem = new ArrayList<>();

                        switch (Case) {
                            case 1:
                                tem.add(i);
                                tem.add(j);
                                tem.add(i + 1);
                                tem.add(j);

                                ans.add(tem);
                                visited[i + 1][j] = true;
                                break;

                            case 2 :
                                tem.add(i);
                                tem.add(j);
                                tem.add(i - 1);
                                tem.add(j);

                                ans.add(tem);
                                visited[i - 1][j] = true;
                                break;

                            case 3 :

                                tem.add(i);
                                tem.add(j);
                                tem.add(i);
                                tem.add(j + 1);

                                ans.add(tem);
                                visited[i][j + 1] = true;
                                break;

                            case 4:
                                tem.add(i);
                                tem.add(j);
                                tem.add(i);
                                tem.add(j - 1);

                                ans.add(tem);
                                visited[i][j - 1] = true;
                                break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }

            if(!flag){
                break;
            }
        }

        for(int i=0;i<n;i++)

            for(int j=0;j<n;j++){
                if(visited[i][j] || ary[i][j]==0){
                    continue;
                }

                int Case = 0;

                if(i<n-1 && !visited[i+1][j] && ary[i+1][j] ==1){
                    Case = 1;
                }
                if(i-1>=0 && !visited[i-1][j] && ary[i-1][j] == 1){
                    Case = 2;
                }
                if(j<n-1 && !visited[i][j+1] && ary[i][j+1]==1){
                    Case = 3;
                }
                if(j-1>=0 && !visited[i][j-1] && ary[i][j-1]==1) {
                    Case = 4;
                }

                if (Case==0){
                    System.out.println(0);
                    return;
                }

                visited[i][j] = true;
                List<Integer> tem = new ArrayList<>();

                switch (Case) {

                    case 1:
                        tem.add(i);
                        tem.add(j);
                        tem.add(i + 1);
                        tem.add(j);

                        ans.add(tem);
                        visited[i + 1][j] = true;
                        break;

                    case 2 :
                        tem.add(i);
                        tem.add(j);
                        tem.add(i - 1);
                        tem.add(j);

                        ans.add(tem);
                        visited[i - 1][j] = true;
                        break;

                    case 3 :
                        tem.add(i);
                        tem.add(j);
                        tem.add(i);
                        tem.add(j + 1);

                        ans.add(tem);
                        visited[i][j + 1] = true;
                        break;

                    case 4:
                        tem.add(i);
                        tem.add(j);
                        tem.add(i);
                        tem.add(j - 1);

                        ans.add(tem);
                        visited[i][j - 1] = true;
                        break;
                }
            }
        System.out.println(1);
        System.out.println(ans.size());
        for(int i = 0; i< ans.size(); i++){
            for(int j = 0; j< ans.get(i).size(); j++){
                System.out.print((ans.get(i).get(j)+1)+" ");
            }
            System.out.println();
        }
    }
}