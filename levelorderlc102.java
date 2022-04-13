import java.util.*;

public class levelorderlc102 {
    public static void main(String[] args) {

    }

    // Leetcode
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrderTraversal(root, result, 0);
        return result;
    }

    public void levelOrderTraversal (TreeNode root, List<List<Integer>>result, int level){
        if(root == null) return;

        if(result.size() == level){
            List<Integer> list = new LinkedList<>();
            result.add(list);
        }

        result.get(level).add(root.val);
        levelOrderTraversal(root.left, result, level+1);
        levelOrderTraversal(root.right, result, level+1);
        return;
    }

    // Gfg

    static ArrayList <Integer> levelOrder(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node temp = q.poll();

            ans.add(temp.data);
            if(temp.left!=null){
                q.add(temp.left);
            }

            if(temp.right!=null){
                q.add(temp.right);
            }
        }

        return ans;
    }
}
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
