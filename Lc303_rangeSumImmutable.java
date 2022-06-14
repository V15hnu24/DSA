public class Lc304_rangeSumImmutable {
    public static void main(String[] args) {

    }
    int[] nums;
    int[] seg;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.seg = new int[4*n];
        build(0, n-1, 0);
    }

    int build(int l, int r, int node){
        if(l==r){
            return seg[node] = nums[l];
        }

        int mid = (l + r)/2;
        int leftsum = build(l, mid, 2*node + 1);
        int rightsum = build(mid+1, r, 2*node + 2);

        return seg[node] = leftsum + rightsum;

    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, n-1, 0);
    }

    int sumRange(int l, int r, int ss, int se, int node){
        if(l>se || r<ss) return 0;
        if(l<=ss && se<=r){
            return seg[node];
        }

        int mid = ss + ((se - ss)) /2;
        int leftsum = sumRange(l,r,ss, mid,2*node+1);
        int rightsum = sumRange(l,r,mid+1, se,2*node+2);

        return leftsum + rightsum;
    }
}
