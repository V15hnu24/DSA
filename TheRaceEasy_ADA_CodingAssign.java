import java.util.Scanner;

public class TheRaceEasy_ADA_CodingAssign {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = s.nextInt();
            y[i] = s.nextInt();
        }

        double ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            //System.out.println("i =" + i);
            for (int j = 0; j <n; j++) {
                //System.out.println("j =" + j);
                if (i==j){
                    continue;
                }
                for (int k = 0; k < n; k++) {
               //     System.out.println("k =" + k);
                    if (j==k || k==i){
                        continue;
                    }

                    ans = Math.min(dist(x[i],y[i],x[j],y[j]) + dist(x[i],y[i],x[k],y[k]) + dist(x[k],y[k],x[j],y[j]),ans);

                }
            }
        }

        System.out.println(ans);
    }

    static double dist(int x1, int y1, int x2, int y2){
        return (double)Math.sqrt(((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2)));
    }
}
