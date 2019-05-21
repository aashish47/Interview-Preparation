package Binary_Trees;

public class NodesWithoutSiblings {

    public static void printNodesWthoutSiblings(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right != null){
            System.out.println(root.data + " ");
        }

        if(root.left == null && root.right != null){
            System.out.println(root.data + " ");
        }
        printNodesWthoutSiblings(root.left);
        printNodesWthoutSiblings(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
    }
}
