import java.util.ArrayList;
import java.util.List;

public class pathsumLC113 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root,new ArrayList<>(),targetSum,ans);
        return ans;
    }

    void helper(TreeNode root, List<Integer> lst,int targetsum,List<List<Integer>> ans){
        if(root == null){
            return;
        }
        lst.add(root.val);
        if (root.left == null && root.right == null && root.val==targetsum){

            ans.add(lst);
            return;
        }
        helper(root.left,new ArrayList<>(lst),targetsum-root.val,ans);
        helper(root.right,new ArrayList<>(lst),targetsum-root.val,ans);

        return;
    }
}
