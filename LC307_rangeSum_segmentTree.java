import java.util.ArrayList;

public class LC307_rangeSum_segmentTree {
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1,5);
        System.out.println(temp.get(1));
    }


    private int[] nums;
    private int[] seg;
    int n;
    /*
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        seg = new int[4*n];
        build(0,n-1, 0);
    }
     */
    int build(int left, int right, int node){
        int mid=0;
        int leftsum = 0, rightsum =0;
        if(left==right){
            return seg[node] = nums[left];
        }

        mid = left + ((right - left)/2);
        leftsum = build(left, mid, 2*node +1);
        rightsum = build(mid+1,right, 2*node +2);
        return seg[node] = leftsum + rightsum;
    }

    public void update(int index, int val) {
        update(index,val, 0, nums.length -1, 0);
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, nums.length -1,0);
    }

    int sumRange(int l, int r, int ss, int se, int node){
        if(r<ss || l > se ){
            return 0;
        }
        if(l<=ss && se<=r){
            return seg[node];
        }
        int mid = (ss + se)/2;
        int leftsum = sumRange(l,r, ss, mid,2*node + 1);
        int rightsum = sumRange(l,r, mid +1, se,2*node + 2);
        return leftsum + rightsum;

    }

    int update(int i, int val, int ss, int se, int node){
        if(i<ss || i>se){
            return seg[node];
        }

        if(ss == se){
            return seg[node] = val;
        }
        int mid = (ss + se)/2;
        int leftsum = update(i, val, ss, mid,2*node + 1);
        int rightsum = update(i,val, mid +1, se,2*node + 2);
        return seg[node] = leftsum + rightsum;

    }
}

class segmentTreeNode{
    private int start, end;
    private segmentTreeNode left, right;
    private int sum;

    public segmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
    segmentTreeNode root = null;
    segmentTreeNode buidlTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        else{
            segmentTreeNode ans = new segmentTreeNode(start,end);
            if (start == end){
                ans.sum = nums[start];
                return ans;
            }else {
                int mid = root.start + (root.end - root.start)/2;
                ans.left = buidlTree(nums,start, mid);
                ans.right = buidlTree(nums,mid+1,end);
                ans.sum = ans.left.sum + ans.right.sum;
            }
            return ans;
        }
    }

    void update(int i, int val){
        updateHelper(root, i, val);
    }

    void updateHelper(segmentTreeNode root, int i, int val) {
        if (root.start == root.end){
            root.sum = val;
        }
        else{
            int mid = root.start + (root.end - root.start)/2;
            if (i<=mid){
                updateHelper(root.left,i,val);
            }else{
                updateHelper(root.right,i,val);
            }
            root.sum = root.left.sum = root.right.sum;
        }
    }

    int sumRange(int i, int j){
        return sumRangeHelper(root, i, j);
    }

    int sumRangeHelper(segmentTreeNode root, int i, int j) {
        if (root.end == end && root.start == start){
            return root.sum;
        }else{
            int mid = root.start + (root.end - root.start)/2;
            if (end<=mid){
                return sumRangeHelper(root.left,i,j);
            }else if(start>= mid-1){
                return sumRangeHelper(root.right,mid+1,j);
            }else{
                return sumRangeHelper(root.left,i,mid) + sumRangeHelper(root.right,mid+1,j);
            }
        }
    }
}
