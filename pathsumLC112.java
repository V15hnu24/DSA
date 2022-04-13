public class pathsumLC112 {
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root ==null) {
            return false;
        }else if (root.left==null && root.right == null && targetSum==root.val){
            return true;
        }else{
            return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}