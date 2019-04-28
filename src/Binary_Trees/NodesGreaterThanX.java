package Binary_Trees;

public class NodesGreaterThanX {

    public static int nodesGreaterThanX(BinaryTreeNode<Integer> root, int x){

        if(root == null){
            return 0;
        }

        if(root.data > x && root.left == null && root.right == null){
            return 1;
        }
        int count = 0;

        if(root.data > x){
            count++;
        }
        if(root.left != null){
            count += nodesGreaterThanX(root.left,x);
        }
        if(root.right != null){
            count += nodesGreaterThanX(root.right,x);
        }

        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBtree();
        System.out.println(nodesGreaterThanX(root,8));
    }
}
