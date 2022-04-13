import java.util.ArrayList;
import java.util.List;

public class leetcode94inorder {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }

    void helper(TreeNode root, List<Integer> ans){

        if(root == null){
            return;
        }

        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right, ans);
    }
}
