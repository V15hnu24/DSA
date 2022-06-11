public class rangeSum_segmentTree {
    public static void main(String[] args) {

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
