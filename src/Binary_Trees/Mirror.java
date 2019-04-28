package Binary_Trees;

public class Mirror {

    public static void mirror(BinaryTreeNode<Integer> root){
        if(root == null){
            return ;
        }

        mirror(root.left);
        mirror(root.right);

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        BinaryTreeNode.printLevelOrder(root);
        mirror(root);
        System.out.println();
        BinaryTreeNode.printLevelOrder(root);
    }
}
