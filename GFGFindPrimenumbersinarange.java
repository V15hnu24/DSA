import java.util.ArrayList;
import java.util.Arrays;

public class GFGFindPrimenumbersinarange {
    public static void main(String[] args) {

    }
    ArrayList<Integer> primeRange(int M, int N) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] ary = new boolean[N+1];
        Arrays.fill(ary,true);

        for(int i = 2; i*i <= N; i++){
            if(ary[i]){
                for(int j=i*i;j<=N;j+=i){
                    ary[j] = false;
                }
            }
        }

        for(int i = Math.max(2,M); i <=N;i++){
            if(ary[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
