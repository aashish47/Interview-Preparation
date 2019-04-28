package Binary_Trees;

public class FindNode {

    public static boolean haveNode(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }

        return root.data == x || haveNode(root.left,x) || haveNode(root.right,x);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        System.out.println(haveNode(root,7));
    }
}
