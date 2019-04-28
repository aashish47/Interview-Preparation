package Binary_Trees;

public class SumOfAllNodes {

    public static int sum(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.data;
        }

        return root.data + sum(root.left) + sum(root.right);

    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        System.out.println(sum(root));
    }
}
