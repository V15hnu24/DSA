import java.util.LinkedList;
import java.util.Queue;

public class LC210 {
    public static void main(String[] args) {

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        int[] inD = new int[numCourses];

        for(int pre[]: prerequisites){
            inD[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inD[i] == 0){
                q.add(i);
            }
        }

        if(q.isEmpty()){
            return new int[0];
        }

        int i = 0;
        while(!q.isEmpty()){
            int c = q.remove();
            ans[i] = c;
            i++;
            for(int pre[] : prerequisites){
                if(pre[1]==c){
                    inD[pre[0]]--;

                    if(inD[pre[0]] == 0){
                        q.add(pre[0]);
                    }
                }
            }
        }

        for(int a: inD){
            if(a!=0){
                return new int[0];
            }
        }

        return ans;
    }
}
