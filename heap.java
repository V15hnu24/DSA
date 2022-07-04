public class heap {
    int[] nums;
    int size;
    int maxsize;
    public heap(int size){
        this.maxsize= size;
        this.size = 0;
        this.nums = new int[maxsize];
    }
    public static void main(String[] args) {

    }
    void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] =temp;
    }
    void insert(int[] nums, int val){

        int cur = 0;
        while(nums[cur] > nums[parent(cur)]){
            swap(nums, cur, parent(cur));
            cur = parent(cur);
        }
        size++;
    }
    private int parent(int pos) { return (pos - 1) / 2; }
    void maxheapify(int pos, int[] nums, int n){
        int l = 2*pos + 1;
        int r = 2*pos + 2;
        int temp = pos;
        if (l<n && nums[pos] < nums[l]){
            pos = l;
        }
        if(r<n && nums[pos] < nums[r]){
            pos = r;
        }
        if (temp!=pos){
            swap(nums, pos, temp);
            maxheapify(pos, nums,n);
        }
    }
    int delete(int[] nums, int n){
        int ans = nums[0];
        swap(nums,0,n-1);
        maxheapify(0,nums, n-1);
        size--;
        return ans;
    }
}
