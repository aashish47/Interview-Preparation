package BinarySearchTrees;


public class DuplicateNode {

    public static void insertDuplicate(BinaryTreeNode<Integer> root){
        if(root == null){
            return ;
        }

        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);

        newNode.left = root.left;
        root.left = newNode;



        insertDuplicate(newNode.left);
        insertDuplicate(root.right);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        insertDuplicate(root);
        BinaryTreeNode.printLevelOrder(root);

    }
}
