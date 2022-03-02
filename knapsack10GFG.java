import java.util.Arrays;

public class knapsack10GFG {
    public static void main(String[] args) {
        int[] ary = new int[]{1,2,3};
        int[] bry = new int[]{4,5,6};

        System.out.println(knapSack(3,bry,ary,3));
    }
    //gfg
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] two = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(j==0 || i==0) {
                    two[i][j]=0;
                }
                else if(wt[i-1]<=j){
                    two[i][j] = Math.max(two[i-1][j],two[i-1][j-wt[i-1]]+val[i-1]);
                }
                else{
                    two[i][j] = two[i-1][j];
                }
            }
        }
        return two[n][W];
    }
}
