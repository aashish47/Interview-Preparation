package Binary_Trees;

public class CountLeafNodes {

    public static int leaf(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        int count = 0;

        if(root.left != null){
            count += leaf(root.left);
        }

        if(root.right != null){
            count += leaf(root.right);
        }

        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        System.out.println(leaf(root));
    }
}
