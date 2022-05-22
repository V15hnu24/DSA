public class LC215KthLargestelement {
    public static void main(String[] args) {

    }

    // Using heaps
    public int findKthLargest(int[] nums, int k) {
        for(int i=nums.length/2; i>=0; i--){
            heapify(nums,nums.length,i);
        }

        for(int i=0; i<k-1; i++){
            delete(nums,nums.length-i);
        }
        return nums[0];
    }

    public void delete(int[] nums, int n){
        swap(nums,n-1,0);
        heapify(nums,n-1,0);
    }

    public void heapify(int[] nums, int n, int i){
        int l = (2*i)+1;
        int r = (2*i)+2;
        int lar = i;

        if(l<n && nums[l]>nums[lar]){
            lar = l;
        }

        if(r<n && nums[r]>nums[lar]){
            lar = r;
        }

        if(lar!=i){
            swap(nums, lar, i);
            heapify(nums,n,lar);
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
