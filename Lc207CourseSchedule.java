import java.util.LinkedList;
import java.util.Queue;

public class Lc207CourseSchedule {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // in-degree topological sort BFS
        int[] indegree = new int[numCourses];

        for(int pre[] : prerequisites){
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        if(q.isEmpty()){
            return false;
        }

        while(!q.isEmpty()){
            int e = q.remove();
            for(int pre[] : prerequisites){
                if(pre[1] == e){
                    indegree[pre[0]]--;
                    if(indegree[pre[0]] == 0){
                        q.add(pre[0]);
                    }
                }
            }
        }

        for(int i: indegree){
            if(i!=0){
                return false;
            }
        }

        return true;

        // Using graph coloring or cyclic detection
/*
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] ary = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++){
            if(preq(adj, ary, i)){
                return false;
            }
        }
        return true;
    }

    boolean preq(ArrayList<ArrayList<Integer>> adj, int[] ary, int c){
        if(ary[c] == 2){
            return true;
        }

        for(int i=0; i<adj.get(c).size(); i++){
            ary[c] = 2;
            if(ary[adj.get(c).get(i)]!=1){
                if(preq(adj,ary, adj.get(c).get(i))){
                    return true;
                }
            }
        }
        ary[c] = 1;

        return false;
        */
    }
}
