import java.util.*;

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

    //Function to find the maximum profit and the number of jobs done. NlonN

    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job j1,Job j2){
                return j1.deadline - j2.deadline;
            }
        });

        ArrayList<Job> ans_aryList = new ArrayList<>();
        int[] ans = new int[]{0,0};
        PriorityQueue<Job> heap = new PriorityQueue<>(
                (a,b) -> {return b.profit - a.profit;});

        int slots = arr[arr.length-1].deadline;

        for (int i = n-1; i > -1 ; i--) {
            int slots;

            if (i==0){
                slots = arr[i].deadline;
            }else{
                slots = arr[i].deadline - arr[i-1].deadline;
            }

            heap.add(arr[i]);

            while (slots>0 && heap.size() > 0){

                Job job = heap.remove();
                slots--;

                ans_aryList.add(job);
            }
        }
        ans[0] = ans_aryList.size();
        for (Job j: ans_aryList) {
            ans[1] = ans[1] + j.profit;
        }

        return ans;
    }


    //N2 solution
    int[] job_sequencing(Job arr[], int n){
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        boolean[] res = new boolean[n];
        int[] job = new int[n];

        for (int i = 0; i<arr.length; i++) {

            for (int j = Math.min(n-1,arr[i].deadline-1); j >=0 ; j--) {
                if(res[j] == false){
                    res[j] = true;

                    job[i] = arr[i].id;
                    break;
                }
            }
        }

        return job;
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