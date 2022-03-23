import java.util.Arrays;
import java.util.TreeMap;

class Solution
{

    //leetcode 1235
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for(int i=0;i<n;i++){
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }

        Arrays.sort(jobs,(a,b) -> a[1] -b[1]);

        TreeMap<Integer,Integer> dp = new TreeMap<>();
        dp.put(0,0);

        for(int[] job:jobs){
            int val = job[2] + dp.floorEntry(job[0]).getValue();

            if(val > dp.lastEntry().getValue()){
                dp.put(job[1],val);
            }
        }

        return dp.lastEntry().getValue();
    }

    //Function to find the maximum profit and the number of jobs done.

    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b) -> a.profit - b.profit);
        int[] ary = new int[n+1];
        Arrays.fill(ary,-1);

        for(int i = n - 1;i>=0;i--){
            int k = arr[i].deadline;
            if(ary[k] == -1 ){
                ary[k] = arr[i].profit;
            }
            else{
                while(ary[k]!=-1){
                    k--;
                }
                ary[k] = arr[i].profit;
            }
        }

        int num = 0, max_profit = 0;

        for(int i  = 1; i<n+1;i++){
            if(ary[i]!=-1){
                num++;
                max_profit += ary[i];
            }
        }

        int temp[] = new int[]{num,max_profit};
        return temp;
    }
    class Job{
        int id,deadline,profit;
        public Job(int a,int b,int c){
            this.id = a;
            this.deadline = b;
            this.profit = c;
        }
    }

}