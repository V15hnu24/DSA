import java.util.Arrays;

class Solution
{
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