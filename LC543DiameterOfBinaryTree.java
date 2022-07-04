public class LC543DiameterOfBinaryTree {
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

//         int l = 1 + height(root.left);
//         int r = 1 + height(root.right);

        // int ld = diameterOfBinaryTree(root.left);
        // int rd = diameterOfBinaryTree(root.right);
        heg h = new heg();
        height(root);
        // return Math.max(l+r, Math.max(ld, rd));

        return d;
    }

    int height(TreeNode root){
        if(root == null) return -1;
        int l = 1 + height(root.left);
        int r = 1 + height(root.right);

        d = Math.max(d,l+r);

        return Math.max(l,r);
    }

    class heg{
        int h;
    }
}
