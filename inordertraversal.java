public class inordertraversal {
    public static void main(String[] args) {

    }

    // Recursive function to print value in Inorder Left, Root, Right
    static void Inorder(node root){

        if (root==null){
            return;
        }

        //Prints left
        Inorder(root.getLeft());

        //Prints node value
        System.out.println(root.getVal());

        //Prints right value
        Inorder(root.getRight());
    }
}

class node{

    private int val;
    private node left;
    private node right;

    //Constructor to initialise the value
    public node(int val){
        this.val = val;
    }

    // Constructor for normal node
    public node(int val, node left, node right){
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public node getLeft() {
        return left;
    }

    public node getRight() {
        return right;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public void setRight(node right) {
        this.right = right;
    }
}