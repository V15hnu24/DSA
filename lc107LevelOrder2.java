import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc107LevelOrder2 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(root, ans, 0);
        Stack<List<Integer>> st = new Stack<>();
        for(int i=0; i<ans.size(); i++){
            st.add(ans.get(i));
        }
        List<List<Integer>> ans1 = new ArrayList<>();

        for(int i = 0; i<ans.size(); i++){
            ans1.add(st.pop());
        }
        return ans1;
    }

    void helper(TreeNode root, List<List<Integer>> ans, int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            List<Integer> n = new ArrayList<>();
            n.add(root.val);
            ans.add(n);
            helper(root.left, ans, level+1);
            helper(root.right, ans,level +1);
            return;
        }

        ans.get(level).add(root.val);
        helper(root.left, ans, level+1);
        helper(root.right, ans,level +1);
    }
}
